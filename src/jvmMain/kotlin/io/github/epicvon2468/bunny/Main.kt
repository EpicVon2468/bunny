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

data class MainVisitor<T>(
	val parser: MainParser,
	val arena: Arena,
	val context: MemorySegment,
	val name: String
) : ParseTreeVisitor<T>, AutoCloseable {

	val module: MemorySegment = LLVMModuleCreateWithNameInContext(arena.allocateFrom(name), context)
	val builder: MemorySegment = LLVMCreateBuilderInContext(context)

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
		val topLevelEntries: List<MainParser.TopLevelContext> = node.topLevel()
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
		// Retrieve or create if not found.
		val function: MemorySegment /*= LLVMValueRef*/ = LLVMGetNamedFunction(module, nativeName).jvmNull() ?: LLVMAddFunction(
			/*M =*/ module,
			/*Name =*/ nativeName,
			/*FunctionTy =*/ LLVMFunctionType(
				/*ReturnType =*/ determineLLVMType(funct.type(), context),
				/*ParamTypes =*/ determineLLVMParamTypes(
					arena,
					paramList,
					params,
					context
				).nativeNull(),
				/*ParamCount =*/ params?.size ?: 0,
				/*IsVarArg =*/ paramList?.VARARG()?.let { 1 } ?: 0
			)
		)
		val body: MainParser.FunctionBodyContext = funct.functionBody() ?: return
		visitFunctionBody(body, function)
	}

	fun visitFunctionBody(
		body: MainParser.FunctionBodyContext,
		function: MemorySegment /*= LLVMValueRef*/
	) {
		LLVMPositionBuilderAtEnd(
			builder,
			LLVMAppendBasicBlockInContext(
				context,
				function,
				arena.allocateFrom("entry")
			)
		)
		body.children.map { it as ParserRuleContext }.forEach(::bodyImpl)
	}

	fun bodyImpl(input: ParserRuleContext): Unit = when (input) {
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

fun determineLLVMParamTypes(
	arena: Arena,
	paramList: MainParser.ParameterListContext?,
	params: List<MainParser.IdentifierWithTypeContext>?,
	context: MemorySegment /*= LLVMContextRef*/
): MemorySegment? /*= Pointer<LLVMTypeRef>*/ {
	if (paramList == null) return null
	return params!!.map { determineLLVMType(it.type(), context) }.toNativeArray(arena, LLVMTypeRef)
}

fun determineLLVMType(
	type: MainParser.TypeContext?,
	context: MemorySegment /*= LLVMContextRef*/
): MemorySegment /*= LLVMTypeRef*/ {
	if (type == null) return LLVMVoidTypeInContext(context)
	if (type.pointerType() != null) return LLVMPointerTypeInContext(context, 0)
	// TODO: Cache the number types into fields?
	return when (val identifier: String = type.IDENTIFIER()!!.text) {
		"" -> error("Empty identifier!")
		"boolean", "bool" -> LLVMInt1TypeInContext(context)
		"i8", "u8" -> LLVMInt8TypeInContext(context)
		"i16", "u16" -> LLVMInt16TypeInContext(context)
		"i32", "u32" -> LLVMInt32TypeInContext(context)
		"i64", "u64" -> LLVMInt64TypeInContext(context)
		"i128", "u128" -> LLVMInt128TypeInContext(context)
		"f32", "float" -> LLVMFloatTypeInContext(context)
		"f64", "double" -> LLVMDoubleTypeInContext(context)
		"void" -> LLVMVoidTypeInContext(context)
		else -> {
			TODO("Get type from a cache of known types? '$identifier'")
		}
	}
}