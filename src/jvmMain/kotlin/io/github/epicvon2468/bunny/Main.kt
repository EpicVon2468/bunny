package io.github.epicvon2468.bunny

import generated.antlr.MainLexer
import generated.antlr.MainParser

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode

import org.llvm.Core_h.*

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

// void* generics https://discord.com/channels/448959983657156608/448959983657156612/1458013565091971202
// https://llvm.org/doxygen/group__LLVMCCoreType.html
// https://llvm.org/doxygen/group__LLVMCCoreContext.html
// https://llvm.org/doxygen/files.html
fun main(args: Array<String>) {
	println("Got args: ${args.contentToString()}")
	println("Java library path: ${System.getProperty("java.library.path")}")
//	System.setProperty("java.library.path", "${System.getProperty("java.library.path")}:${System.getenv("LIB_LLVM_LOCATION")}/lib")
//	println("Java library path: ${System.getProperty("java.library.path")}")
	test()
	println("Starting parser-based codegen")
	Arena.ofShared().use { arena: Arena ->
		val parser = MainParser(CommonTokenStream(MainLexer(CharStreams.fromFileName("minimal.bun"))))
		MainVisitor<Unit>(parser, arena, LLVMContextCreate(), "test").use(parser.top()::accept)
	}
}

@JvmField
val EMPTY_STRING: MemorySegment = Arena.global().allocateFrom("")

fun String?.cstr(arena: Arena): MemorySegment = if (this == "" || this == null) EMPTY_STRING else arena.allocateFrom(this)

// TODO: When a struct is parsed, update env to contain it as a type
data class MainVisitor<T>(
	val parser: MainParser,
	val arena: Arena,
	val context: LLVMContextRef,
	val name: String
) : ParseTreeVisitor<T>, AutoCloseable {

	val module: LLVMModuleRef = LLVMModuleCreateWithNameInContext(name.cstr(arena), context)
	val builder: LLVMBuilderRef = LLVMCreateBuilderInContext(context)

	var scope: Scope = Scope.globalScope(context, module)
		private set

	override fun visit(tree: ParseTree): T? {
		val tree: ParserRuleContext = tree as ParserRuleContext
		return null
	}

	override fun visitChildren(node: RuleNode): T? {
		val node: ParserRuleContext = node as ParserRuleContext
		if (node !is MainParser.TopContext) {
			visit(node)
			for (child: ParseTree in node.children) child.accept(this)
			return null
		}
		println(node.version().children.joinToString(separator = " ", transform = ParseTree::getText))
		val topLevelEntries: List<MainParser.TopLevelContext> = node.topLevel() ?: return null
		topLevelEntries.forEach {
			when (val declaration: ParserRuleContext = it.functionDefinition() ?: it.structDefinition()) {
				is MainParser.FunctionDefinitionContext -> visitFunctionDefinition(declaration)
				is MainParser.StructDefinitionContext -> visitStructDefinition(declaration)
			}
		}
		return null
	}

	// TODO: functions within structs, actual struct variables, find out if this even actually works, maybe turn TypeInfo into an interface & make one for StructInfo & another for SimpleTypeInfo
	fun visitStructDefinition(struct: MainParser.StructDefinitionContext) {
		val name: String = struct.IDENTIFIER()!!.text
		val llvmStruct: LLVMTypeRef = LLVMStructCreateNamed(context, name.cstr(arena))
		val variableTypes: List<LLVMTypeRef>? = struct.variableDefinition()?.map {
			if (it.ASSIGNMENT() != null) error("Variable was provided an assignment in a struct!  Only a definition of the name and type was expected!")
			scope.determineLLVMType(it.identifierWithType().type()).llvmType
		}
		LLVMStructSetBody(
			/*StructTy =*/ llvmStruct,
			/*ElementTypes =*/ variableTypes?.toNativeArray(arena, LLVMTypeRef) ?: arena.allocateArray(LLVMTypeRef),
			/*ElementCount =*/ variableTypes?.size ?: 0,
			/*Packed =*/ 0
		)
		scope = scope.childScope(addedTypes = mapOf(name to TypeInfo(llvmStruct, name)))
	}

	// TODO: Fix difference in type between 'expected' definition and actual implementation.  Also fix the fact that function parameter names can be repeated.
	fun visitFunctionDefinition(funct: MainParser.FunctionDefinitionContext) {
		var localScope: Scope = scope
		val paramList: MainParser.ParameterListContext? = funct.parameterList()
		val params: List<MainParser.IdentifierWithTypeContext>? = paramList?.identifierWithType()
		val name: String = funct.IDENTIFIER().text
		val nativeName: MemorySegment = name.cstr(arena)
		val returnType: TypeInfo = localScope.determineLLVMType(funct.type())
		val parameters: List<NamedParameter> = buildParams(paramList, params, localScope)
		// Retrieve or create if not found.
		val function: FunctionInfo = localScope.lookupFunctOrNull(name) ?: run {
			val function: LLVMValueRef = LLVMAddFunction(
				/*M =*/ module,
				/*Name =*/ nativeName,
				/*FunctionTy =*/ LLVMFunctionType(
					/*ReturnType =*/ returnType.llvmType,
					/*ParamTypes =*/ parameters.map { it.typeInfo.llvmType }.toNativeArray(arena, LLVMTypeRef),
					/*ParamCount =*/ params?.size ?: 0,
					/*IsVarArg =*/ paramList?.VARARG()?.let { 1 } ?: 0
				)
			)
			FunctionInfo(name, parameters, returnType, function).apply {
				scope = localScope.childScope(addedFunctions = mapOf(name to this))
				localScope = localScope.mergeLookups(scope)
			}
		}
		localScope = localScope.childScope(returnType = function.returnType)
		visitFunctionBody(
			funct.functionBody() ?: return,
			function,
			localScope
		)
	}

	fun buildParams(
		paramList: MainParser.ParameterListContext?,
		params: List<MainParser.IdentifierWithTypeContext>?,
		scope: Scope
	): List<NamedParameter> {
		paramList ?: return emptyList()
		val output: MutableList<NamedParameter> = mutableListOf()
		params!!.map {
			it to scope.determineLLVMType(it.type())
		}.forEachIndexed { index: Int, pair: Pair<MainParser.IdentifierWithTypeContext, TypeInfo> ->
			val name: String = pair.first.IDENTIFIER().text + ".addr"
			val typeInfo: TypeInfo = pair.second
			output += NamedParameter(
				name = name,
				typeInfo = typeInfo,
				addressSupplier = { function: LLVMValueRef ->
					val addressVariable: MemorySegment = LLVMBuildAlloca(
						builder,
						typeInfo.llvmType,
						name.cstr(arena)
					)
					LLVMBuildStore(builder, LLVMGetParam(function, index), addressVariable)
					addressVariable
				},
				index = index
			)
		}
		return output
	}

	fun visitFunctionBody(
		body: MainParser.FunctionBodyContext,
		function: FunctionInfo,
		scope: Scope
	) {
		LLVMPositionBuilderAtEnd(
			builder,
			LLVMAppendBasicBlockInContext(
				context,
				function.llvmFunction,
				"entry".cstr(arena)
			)
		)
//		val alloca = LLVMBuildAlloca(builder, scope.lookupType("size_t").llvmType, "blah".cstr(arena))
//		LLVMBuildStore(builder, LLVMSizeOf(scope.lookupType("i32").llvmType), alloca)
		var localScope: Scope = scope
		function.parameters.forEach { it.runInit(function.llvmFunction) }
		body.children.forEach { child: ParseTree ->
			bodyImpl(child as ParserRuleContext, localScope) { localScope = it; it }
		}
	}

	fun bodyImpl(
		input: ParserRuleContext,
		scope: Scope,
		setScope: (Scope) -> Scope
	) {
		var localScope: Scope = scope
		when (input) {
			is MainParser.ReturnExpressionContext -> {
				val expression: MainParser.ExpressionContext? = input.expression()
				if (expression == null) LLVMBuildRetVoid(builder)
				else LLVMBuildRet(
					builder,
					evaluateExpression(expression, localScope)
				)
				return
			}
			is MainParser.VariableDefinitionContext -> {
				val identifierWithType: MainParser.IdentifierWithTypeContext = input.identifierWithType()
				val name: String = identifierWithType.IDENTIFIER().text + ".addr"
				val type: TypeInfo = localScope.determineLLVMType(identifierWithType.type())
				val variable = LocalVariable(
					name,
					type,
					LLVMBuildAlloca(
						builder,
						type.llvmType,
						name.cstr(arena)
					)
				)
				localScope = setScope(localScope.childScope(addedVariables = mapOf(name to variable)))
				variable.storeValue(
					builder,
					evaluateExpression(
						input.expression() ?: return,
						localScope
					)
				)
				return
			}
			is MainParser.AssignmentExpressionContext -> {
				localScope.lookupVariable(input.IDENTIFIER().text).storeValue(
					builder,
					evaluateExpression(input.expression(), localScope)
				)
				return
			}
			else -> {}
		}
	}

	fun evaluateExpression(expr: MainParser.ExpressionContext, scope: Scope): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.EqualityExpressionContext>(0), scope)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.EqualityExpressionContext, scope: Scope): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.ComparisonExpressionContext>(0), scope)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.ComparisonExpressionContext, scope: Scope): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.TermExpressionContext>(0), scope)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.TermExpressionContext, scope: Scope): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.FactorExpressionContext>(0), scope)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.FactorExpressionContext, scope: Scope): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.UnaryExpressionContext>(0), scope)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.UnaryExpressionContext, scope: Scope): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.PrimaryExpressionContext>(0), scope)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.PrimaryExpressionContext, scope: Scope): LLVMValueRef {
		if (expr.expression() != null) {
			TODO("Grouped expression")
		}
		expr.NUM_INT()?.let {
			return LLVMConstInt(scope.returnType!!.llvmType, it.text.toLong(), 0)
		}
		expr.NUM_FLOAT()?.let {
			return LLVMConstReal(scope.returnType!!.llvmType, it.text.toDouble())
		}
		expr.STRING_LITERAL()?.let {
			return LLVMBuildGlobalString(
				builder,
				it.text
					.drop(1) // Drop first '"'
					.dropLast(1) // Drop last '"'
					.cstr(arena),
				EMPTY_STRING
			)
		}
		expr.TRUE()?.let {
			return LLVMConstInt(scope.lookupType("bool").llvmType, 1L, 0)
		}
		expr.FALSE()?.let {
			return LLVMConstInt(scope.lookupType("bool").llvmType, 0L, 0)
		}
		return scope.lookupVariable(expr.IDENTIFIER().text).loadValue(builder)
	}

	override fun visitTerminal(node: TerminalNode): T? {
		return null
	}

	override fun visitErrorNode(node: ErrorNode): T? {
		return null
	}

	override fun close() {
		LLVMDisposeBuilder(builder)
		println("'''\n${LLVMPrintModuleToString(module).getString(0)}'''")
		LLVMDisposeModule(module)
		LLVMContextDispose(context)
	}
}

// TODO: Use this for "auto"-like keyword, so we can just infer info about the type by evaluating the expression literally.
fun ParseTree.isLiteralExpression(): Boolean {
	tailrec fun recurseThrough(tree: ParseTree): Boolean {
		if (tree.childCount != 1) return false
		if (tree !is MainParser.PrimaryExpressionContext) return recurseThrough(tree.getChild(0))
		return true
	}
	return recurseThrough(this)
}

inline fun <reified T : ParseTree> ParserRuleContext.getChildOrNull(i: Int): T? = this.getChild(T::class.java, i)
inline fun <reified T : ParseTree> ParserRuleContext.getChild(i: Int): T = this.getChildOrNull(i)!!

fun MemorySegment.jvmNull(): MemorySegment? = if (this == MemorySegment.NULL) null else this
fun MemorySegment?.nativeNull(): MemorySegment = this ?: MemorySegment.NULL
// This always evaluates 'other' (even if inlined)
infix fun MemorySegment.elvis(other: MemorySegment): MemorySegment = this.jvmNull() ?: other
// This version does not have the same problem, but might not always want braces
infix fun MemorySegment.elvis(other: () -> MemorySegment): MemorySegment = this.jvmNull() ?: other()

fun Scope.determineLLVMType(type: MainParser.TypeContext?): TypeInfo {
	if (type == null) return this.lookupType("")
	if (type.pointerType() != null) return this.lookupType("ptr")
	return this.lookupType(type.IDENTIFIER()!!.text)
}