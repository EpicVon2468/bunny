package io.github.epicvon2468.bunny

import generated.antlr.MainLexer
import generated.antlr.MainParser

import io.github.epicvon2468.bunny.typeinfo.BooleanTypeInfo
import io.github.epicvon2468.bunny.typeinfo.FloatTypeInfo
import io.github.epicvon2468.bunny.typeinfo.IntTypeInfo
import io.github.epicvon2468.bunny.typeinfo.NumberTypeInfo
import io.github.epicvon2468.bunny.typeinfo.PrimitiveTypeInfo
import io.github.epicvon2468.bunny.typeinfo.StructTypeInfo
import io.github.epicvon2468.bunny.typeinfo.TypeInfo

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
// https://llvm.org/docs/LangRef.html
fun main(args: Array<String>) {
	println("Got args: ${args.contentToString()}")
	println("Java library path: ${System.getProperty("java.library.path")}")
//	System.setProperty("java.library.path", "${System.getProperty("java.library.path")}:${System.getenv("LIB_LLVM_LOCATION")}/lib")
//	println("Java library path: ${System.getProperty("java.library.path")}")
	test()
	println("Starting parser-based codegen")
	Arena.ofShared().use { arena: Arena ->
		val parser = MainParser(CommonTokenStream(MainLexer(CharStreams.fromFileName("minimal.bun"))))
		MainVisitor(parser, arena, LLVMContextCreate(), "test").use(parser.top()::accept)
	}
}

@JvmField
val EMPTY_STRING: MemorySegment = Arena.global().allocateFrom("")

fun String?.cstr(arena: Arena): MemorySegment = if (this == "" || this == null) EMPTY_STRING else arena.allocateFrom(this)

data class MainVisitor(
	val parser: MainParser,
	val arena: Arena,
	val context: LLVMContextRef,
	val name: String
) : ParseTreeVisitor<Unit>, AutoCloseable {

	val module: LLVMModuleRef = LLVMModuleCreateWithNameInContext(name.cstr(arena), context)
	val builder: LLVMBuilderRef = LLVMCreateBuilderInContext(context)

	var scope: Scope = Scope.globalScope(context, module)
		private set

	override fun visit(tree: ParseTree) = Unit

	override fun visitChildren(node: RuleNode) {
		val node: ParserRuleContext = node as ParserRuleContext
		if (node !is MainParser.TopContext) {
			visit(node)
			for (child: ParseTree in node.children) child.accept(this)
			return
		}
		println(node.version().children.joinToString(separator = " ", transform = ParseTree::getText))
		val topLevelEntries: List<MainParser.TopLevelContext> = node.topLevel() ?: return
		topLevelEntries.forEach {
			when (val declaration: ParserRuleContext = it.functionDefinition() ?: it.structDefinition()) {
				is MainParser.FunctionDefinitionContext -> visitFunctionDefinition(declaration)
				is MainParser.StructDefinitionContext -> visitStructDefinition(declaration)
			}
		}
	}

	// TODO: functions within structs, actual struct variables, find out if this even actually works
	fun visitStructDefinition(struct: MainParser.StructDefinitionContext) {
		val name: String = struct.IDENTIFIER()!!.text
		val llvmStruct: LLVMTypeRef = LLVMStructCreateNamed(context, name.cstr(arena))
		val variableTypes: List<TypeInfo>? = struct.variableDefinition()?.map {
			if (it.ASSIGNMENT() != null) error("Variable was provided an assignment in a struct!  Only a definition of the name and type was expected!")
			scope.determineLLVMType(it.identifierWithType().type())
		}
		LLVMStructSetBody(
			/*StructTy =*/ llvmStruct,
			/*ElementTypes =*/ variableTypes?.map(TypeInfo::llvmType)?.toNativeArray(arena, LLVMTypeRef) ?: arena.allocateArray(LLVMTypeRef),
			/*ElementCount =*/ variableTypes?.size ?: 0,
			/*Packed =*/ 0
		)
		scope = scope.withTypes(StructTypeInfo(llvmStruct, name, variableTypes ?: emptyList()))
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
		localScope = localScope.withVariables(*parameters.toTypedArray())
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
				scope = scope.withFunctions(this)
				localScope = localScope.mergeLookups(scope)
			}
		}
		localScope = localScope.withReturnType(function.returnType)
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
//		val alloca = LLVMBuildAlloca(builder, scope.lookupType("size").llvmType, "blah".cstr(arena))
//		LLVMBuildStore(builder, LLVMSizeOf(scope.lookupType("i32").llvmType), alloca)
		var localScope: Scope = scope
		function.parameters.forEach { it.runInit(function.llvmFunction) }
		body.children?.forEach { child: ParseTree ->
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
				else LLVMBuildRet(builder, evaluateExpression(expression, localScope))
				return
			}
			is MainParser.VariableDefinitionContext -> {
				val identifierWithType: MainParser.IdentifierWithTypeContext = input.identifierWithType()
				var name: String = identifierWithType.IDENTIFIER().text
				val typeInfo: TypeInfo = localScope.determineLLVMType(identifierWithType.type())
				fun value(): LLVMValueRef? = evaluateExpression(
					input.expression() ?: return null,
					localScope.withReturnType(typeInfo)
				)
				// I think I accidentally made inline variables lmao
				val variable: Variable
				if (input.MUTABLE() == null) variable = LocalVariable(name, typeInfo, value() ?: return, name.cstr(arena))
				else {
					name += ".addr"
					variable = LocalMutableVariable(
						name,
						typeInfo,
						LLVMBuildAlloca(builder, typeInfo.llvmType, name.cstr(arena))
					)
					variable.storeValue(builder, value() ?: return)
				}
				localScope = setScope(localScope.withVariables(variable))
				return
			}
			is MainParser.AssignmentExpressionContext -> {
				val variable: MutableVariable = localScope.lookupMutableVariable(input.IDENTIFIER().text)
				variable.storeValue(
					builder,
					evaluateExpression(
						input.expression(),
						localScope.withReturnType(variable.typeInfo)
					)
				)
				return
			}
			else -> {}
		}
	}

	fun evaluateExpression(expr: MainParser.ExpressionContext, scope: Scope): LLVMValueRef = evaluateExpression(
		expr.equalityExpression(),
		scope
	)

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

	fun evaluateOp(
		expr: ParserRuleContext,
		evaluate: (index: Int) -> LLVMValueRef,
		evaluateOp: (op: Char, lhs: LLVMValueRef, rhs: LLVMValueRef) -> LLVMValueRef
	): LLVMValueRef {
		var value: LLVMValueRef = evaluate(0)
		var index = 0
		while (index < expr.childCount) {
			value = evaluateOp(
				/*op =*/ expr.getChild<TerminalNode>(index + 1).text.trim().first(),
				/*lhs =*/ value,
				/*rhs =*/ evaluate(index + 2)
			)
			// cRHS op cLHS op nLHS
			if (index + 4 >= expr.childCount) break
			index += 2
		}
		return value
	}

	fun evaluateExpression(expr: MainParser.TermExpressionContext, scope: Scope): LLVMValueRef = when (expr.childCount) {
		0 -> error("No children for expression '$expr'!")
		1 -> evaluateExpression(expr.getChild<MainParser.FactorExpressionContext>(0), scope)
		else -> evaluateOp(
			expr = expr,
			evaluate = { index: Int ->
				evaluateExpression(expr.getChild<MainParser.FactorExpressionContext>(index), scope)
			},
			evaluateOp = { op: Char, lhs: LLVMValueRef, rhs: LLVMValueRef ->
				when (op) {
					'+' -> when (scope.returnType as NumberTypeInfo) {
						is IntTypeInfo -> LLVMBuildAdd(builder, lhs, rhs, EMPTY_STRING)
						is FloatTypeInfo -> LLVMBuildFAdd(builder, lhs, rhs, EMPTY_STRING)
					}
					'-' -> when (scope.returnType as NumberTypeInfo) {
						is IntTypeInfo -> LLVMBuildSub(builder, lhs, rhs, EMPTY_STRING)
						is FloatTypeInfo -> LLVMBuildFSub(builder, lhs, rhs, EMPTY_STRING)
					}
					else -> error("Illegal operator '$op', expected '+' or '-'!")
				}
			}
		)
	}

	fun evaluateExpression(expr: MainParser.FactorExpressionContext, scope: Scope): LLVMValueRef = when (expr.childCount) {
		0 -> error("No children for expression '$expr'!")
		1 -> return evaluateExpression(expr.getChild<MainParser.UnaryExpressionContext>(0), scope)
		else -> evaluateOp(
			expr = expr,
			evaluate = { index: Int ->
				evaluateExpression(expr.getChild<MainParser.UnaryExpressionContext>(index), scope)
			},
			evaluateOp = { op: Char, lhs: LLVMValueRef, rhs: LLVMValueRef ->
				when (op) {
					'/' -> when (scope.returnType as NumberTypeInfo) {
						is IntTypeInfo.Signed -> LLVMBuildSDiv(builder, lhs, rhs, EMPTY_STRING)
						is IntTypeInfo.Unsigned -> LLVMBuildUDiv(builder, lhs, rhs, EMPTY_STRING)
						is FloatTypeInfo -> LLVMBuildFDiv(builder, lhs, rhs, EMPTY_STRING)
					}
					'*' -> when (scope.returnType as NumberTypeInfo) {
						is IntTypeInfo -> LLVMBuildMul(builder, lhs, rhs, EMPTY_STRING)
						is FloatTypeInfo -> LLVMBuildFMul(builder, lhs, rhs, EMPTY_STRING)
					}
					else -> error("Illegal operator '$op', expected '/' or '*'!")
				}
			}
		)
	}

	fun evaluateExpression(expr: MainParser.UnaryExpressionContext, scope: Scope): LLVMValueRef = when (expr.childCount) {
		0 -> error("No children for expression '$expr'!")
		1 -> evaluateExpression(expr.getChild<MainParser.PrimaryExpressionContext>(0), scope)
		// I think you might be able to do '!!' and so on as a prefix... oops
		else -> when (scope.returnType as PrimitiveTypeInfo) {
			is BooleanTypeInfo -> LLVMBuildXor(
				builder,
				evaluateExpression(expr.getChild<MainParser.UnaryExpressionContext>(1), scope),
				bool(true, scope),
				EMPTY_STRING
			)
			is IntTypeInfo -> {
				val zero: LLVMValueRef = LLVMConstInt(scope.returnType.llvmType, 0L, 0)
				val value: LLVMValueRef = evaluateExpression(expr.getChild<MainParser.UnaryExpressionContext>(1), scope)
				if (expr.NOT() != null) {
					// https://llvm.org/doxygen/llvm-c_2Core_8h_source.html#l00294
					// %4 = icmp ne i32 %3, 0
					// %5 = xor i1 %4, true
					// %6 = zext i1 %5 to i32
					val icmp: LLVMValueRef = LLVMBuildICmp(builder, 33, value, zero, EMPTY_STRING)
					val xor: LLVMValueRef = LLVMBuildXor(builder, icmp, bool(true, scope), EMPTY_STRING)
					return LLVMBuildZExt(builder, xor, scope.returnType.llvmType, EMPTY_STRING)
				}
				// Clang generates this for unary minus:
				// %4 = sub nsw i32 0, %3
				LLVMBuildSub(
					builder,
					zero,
					value,
					EMPTY_STRING
				)
			}
			is FloatTypeInfo -> LLVMBuildFNeg(
				builder,
				evaluateExpression(expr.getChild<MainParser.UnaryExpressionContext>(1), scope),
				EMPTY_STRING
			)
		}
	}

	fun evaluateExpression(expr: MainParser.PrimaryExpressionContext, scope: Scope): LLVMValueRef {
		expr.functionCall()?.let {
			val calledFunct: FunctionInfo = scope.lookupFunct(it.IDENTIFIER().text)
			val llvmFunct: LLVMValueRef = calledFunct.llvmFunction
			var size = 0
			val args: MemorySegment = run {
				val args: List<LLVMValueRef>? = it.argList()?.children?.filterNot(TerminalNode::class::isInstance)?.map { child ->
					size++
					evaluateExpression(child as MainParser.ExpressionContext, scope)
				}
				args ?: return@run MemorySegment.NULL
				args.toNativeArray(arena, LLVMValueRef)
			}
			return LLVMBuildCall2(
				builder,
				LLVMGlobalGetValueType(llvmFunct),
				llvmFunct,
				args,
				size,
				EMPTY_STRING
			)
		}
		expr.expression()?.let {
			return evaluateExpression(it, scope)
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
		if (expr.TRUE() != null) return bool(true, scope)
		if (expr.FALSE() != null) return bool(false, scope)
		return scope.lookupVariable(expr.IDENTIFIER().text).loadValue(builder)
	}

	fun bool(boolean: Boolean, scope: Scope): LLVMValueRef = LLVMConstInt(
		/*IntTy =*/ scope.lookupType("bool").llvmType,
		/*N =*/ if (boolean) 1L else 0L,
		/*SignExtend =*/ 0
	)

	override fun visitTerminal(node: TerminalNode) = Unit

	override fun visitErrorNode(node: ErrorNode) = Unit

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

inline fun <reified T : ParseTree> ParserRuleContext.getChildOrNull(i: Int): T? = this.getChild(i) as? T
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