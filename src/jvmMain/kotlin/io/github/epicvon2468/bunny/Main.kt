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
fun main(args: Array<String>) {
	println("Got args: ${args.contentToString()}")
	println("Java library path: ${System.getProperty("java.library.path")}")
	System.setProperty("java.library.path", "${System.getProperty("java.library.path")}:${System.getenv("LIB_LLVM_LOCATION")}/lib")
	println("Java library path: ${System.getProperty("java.library.path")}")
	test()
	println("Starting parser-based codegen")
	Arena.ofShared().use { arena: Arena ->
		val parser = MainParser(CommonTokenStream(MainLexer(CharStreams.fromFileName("minimal.bun"))))
		MainVisitor<Unit>(parser, arena, LLVMContextCreate(), "test").use(parser.top()::accept)
	}
}

@ConsistentCopyVisibility
data class Env private constructor(
	val typeLookup: Map<String, MemorySegment>,
	// TODO: variable map for local & global variables :o
	val returnType: MemorySegment = MemorySegment.NULL,
	val parent: Env? = null
) {

	fun newEnv(
		addedTypes: Map<String, MemorySegment>? = null,
		returnType: MemorySegment = this.returnType,
		parent: Env? = this.parent
	): Env = Env(
		this.typeLookup.let {
			if (addedTypes == null) return@let it
			val newMap: MutableMap<String, MemorySegment> = it.toMutableMap()
			newMap += addedTypes
			newMap
		},
		returnType,
		parent
	)

	fun lookupTypeOrNull(name: String): MemorySegment? = typeLookup[name] ?: parent?.lookupTypeOrNull(name)
	fun lookupType(name: String): MemorySegment = lookupTypeOrNull(name) ?: error("Couldn't find type with name '$name' in lookup!")

	companion object {

		@JvmStatic
		fun newEnv(context: MemorySegment) = Env(
			typeLookup = mutableMapOf<String, MemorySegment>().apply {
				fun <K, V> MutableMap<K, V>.put(vararg keys: K, value: V) {
					for (key in keys) this[key] = value
				}
				put("", "void", value = LLVMVoidTypeInContext(context))
				put("boolean", "bool", value = LLVMInt1TypeInContext(context))
				put("i8", "u8", value = LLVMInt8TypeInContext(context))
				put("i16", "u16", value = LLVMInt16TypeInContext(context))
				put("i32", "u32", value = LLVMInt32TypeInContext(context))
				put("i64", "u64", value = LLVMInt64TypeInContext(context))
				put("i128", "u128", value = LLVMInt128TypeInContext(context))
				put("f32", "float", value = LLVMFloatTypeInContext(context))
				put("f64", "double", value = LLVMDoubleTypeInContext(context))
				put("ptr", "pointer", value = LLVMPointerTypeInContext(context, /*AddressSpace =*/ 0))
			}
		)
	}
}

data class MainVisitor<T>(
	val parser: MainParser,
	val arena: Arena,
	val context: MemorySegment,
	val name: String
) : ParseTreeVisitor<T>, AutoCloseable {

	val module: MemorySegment = LLVMModuleCreateWithNameInContext(arena.allocateFrom(name), context)
	val builder: MemorySegment = LLVMCreateBuilderInContext(context)

	val env: Env = Env.newEnv(context)

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
				is MainParser.StructDefinitionContext -> TODO()
			}
		}
		return null
	}

	fun visitFunctionDefinition(funct: MainParser.FunctionDefinitionContext) {
		val paramList: MainParser.ParameterListContext? = funct.parameterList()
		val params: List<MainParser.IdentifierWithTypeContext>? = paramList?.identifierWithType()
		val nativeName: MemorySegment = arena.allocateFrom(funct.IDENTIFIER().text)
		val returnType: MemorySegment /*= LLVMTypeRef*/ = determineLLVMType(funct.type(), env)
		// Retrieve or create if not found.
		val function: MemorySegment /*= LLVMValueRef*/ = LLVMGetNamedFunction(module, nativeName).jvmNull() ?: LLVMAddFunction(
			/*M =*/ module,
			/*Name =*/ nativeName,
			/*FunctionTy =*/ LLVMFunctionType(
				/*ReturnType =*/ returnType,
				/*ParamTypes =*/ determineLLVMParamTypes(
					arena,
					paramList,
					params,
					env
				),
				/*ParamCount =*/ params?.size ?: 0,
				/*IsVarArg =*/ paramList?.VARARG()?.let { 1 } ?: 0
			)
		)
		visitFunctionBody(
			funct.functionBody() ?: return,
			function,
			returnType
		)
	}

	fun visitFunctionBody(
		body: MainParser.FunctionBodyContext,
		function: MemorySegment /*= LLVMValueRef*/,
		returnType: MemorySegment /*= LLVMTypeRef*/
	) {
		LLVMPositionBuilderAtEnd(
			builder,
			LLVMAppendBasicBlockInContext(
				context,
				function,
				arena.allocateFrom("entry")
			)
		)
		body.children.forEach { bodyImpl(it as ParserRuleContext, returnType) }
	}

	fun bodyImpl(
		input: ParserRuleContext,
		returnType: MemorySegment /*= LLVMTypeRef*/
	): Unit = when (input) {
		is MainParser.ReturnExpressionContext -> {
			val expression: MainParser.ExpressionContext? = input.expression()
			if (expression == null) LLVMBuildRetVoid(builder)
			else LLVMBuildRet(
				builder,
				evaluateExpression(expression)
			)
			return
		}
		is MainParser.VariableDefinitionContext -> {
			return
		}
		else -> {}
	}

	fun evaluateExpression(expr: MainParser.ExpressionContext): MemorySegment /*= LLVMValueRef*/ {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild(MainParser.EqualityExpressionContext::class.java, 0))
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.EqualityExpressionContext): MemorySegment /*= LLVMValueRef*/ {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild(MainParser.ComparisonExpressionContext::class.java, 0))
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.ComparisonExpressionContext): MemorySegment /*= LLVMValueRef*/ {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild(MainParser.TermExpressionContext::class.java, 0))
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.TermExpressionContext): MemorySegment /*= LLVMValueRef*/ {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild(MainParser.FactorExpressionContext::class.java, 0))
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.FactorExpressionContext): MemorySegment /*= LLVMValueRef*/ {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild(MainParser.UnaryExpressionContext::class.java, 0))
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.UnaryExpressionContext): MemorySegment /*= LLVMValueRef*/ {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild(MainParser.PrimaryExpressionContext::class.java, 0))
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.PrimaryExpressionContext): MemorySegment /*= LLVMValueRef*/ {
		if (expr.expression() != null) {
			TODO("Grouped expression")
		}
		expr.NUM_INT()?.let {
			return LLVMConstInt(LLVMInt64TypeInContext(context), it.text.toLong(), 0)
		}
		expr.NUM_FLOAT()?.let {
			return LLVMConstReal(LLVMDoubleTypeInContext(context), it.text.toDouble())
		}
		expr.STRING_LITERAL()?.let {
			return LLVMBuildGlobalString(
				builder,
				arena.allocateFrom(
					it.text
						.drop(1) // Drop first '"'
						.dropLast(1) // Drop last '"'
				),
				arena.allocateFrom("")
			)
		}
		expr.TRUE()?.let {
			return LLVMConstInt(LLVMInt1TypeInContext(context), 1L, 0)
		}
		expr.FALSE()?.let {
			return LLVMConstInt(LLVMInt1TypeInContext(context), 0L, 0)
		}
		TODO("Identifier for variable.")
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

fun MemorySegment.jvmNull(): MemorySegment? = if (this == MemorySegment.NULL) null else this
fun MemorySegment?.nativeNull(): MemorySegment = this ?: MemorySegment.NULL
infix fun MemorySegment.elvis(other: MemorySegment): MemorySegment = this.jvmNull() ?: other

fun determineLLVMParamTypes(
	arena: Arena,
	paramList: MainParser.ParameterListContext?,
	params: List<MainParser.IdentifierWithTypeContext>?,
	env: Env
): MemorySegment /*= Pointer<LLVMTypeRef>*/ {
	if (paramList == null) return MemorySegment.NULL
	return params!!.map { determineLLVMType(it.type(), env) }.toNativeArray(arena, LLVMTypeRef)
}

fun determineLLVMType(type: MainParser.TypeContext?, env: Env): MemorySegment /*= LLVMTypeRef*/ {
	if (type == null) return env.lookupType("void")
	if (type.pointerType() != null) return env.lookupType("ptr")
	return env.lookupType(type.IDENTIFIER()!!.text)
}