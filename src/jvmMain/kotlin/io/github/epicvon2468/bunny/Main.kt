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

// TODO: When a struct is parsed, update env to contain it as a type
data class MainVisitor<T>(
	val parser: MainParser,
	val arena: Arena,
	val context: LLVMContextRef,
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
		val returnType: LLVMTypeRef = determineLLVMType(funct.type(), env)
		// Retrieve or create if not found.
		val function: LLVMValueRef = LLVMGetNamedFunction(module, nativeName).jvmNull() ?: LLVMAddFunction(
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
		function: LLVMValueRef,
		returnType: LLVMTypeRef
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
		returnType: LLVMTypeRef
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

	fun evaluateExpression(expr: MainParser.ExpressionContext, env: Env = this.env): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.EqualityExpressionContext>(0), env)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.EqualityExpressionContext, env: Env = this.env): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.ComparisonExpressionContext>(0), env)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.ComparisonExpressionContext, env: Env = this.env): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.TermExpressionContext>(0), env)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.TermExpressionContext, env: Env = this.env): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.FactorExpressionContext>(0), env)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.FactorExpressionContext, env: Env = this.env): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.UnaryExpressionContext>(0), env)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.UnaryExpressionContext, env: Env = this.env): LLVMValueRef {
		when (expr.childCount) {
			0 -> error("No children for expression '$expr'!")
			1 -> return evaluateExpression(expr.getChild<MainParser.PrimaryExpressionContext>(0), env)
			else -> {
			}
		}
		TODO()
	}

	fun evaluateExpression(expr: MainParser.PrimaryExpressionContext, env: Env = this.env): LLVMValueRef {
		if (expr.expression() != null) {
			TODO("Grouped expression")
		}
		expr.NUM_INT()?.let {
			return LLVMConstInt(env.lookupType("i64").llvmType, it.text.toLong(), 0)
		}
		expr.NUM_FLOAT()?.let {
			return LLVMConstReal(env.lookupType("f64").llvmType, it.text.toDouble())
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
			return LLVMConstInt(env.lookupType("bool").llvmType, 1L, 0)
		}
		expr.FALSE()?.let {
			return LLVMConstInt(env.lookupType("bool").llvmType, 0L, 0)
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

inline fun <reified T : ParseTree> ParserRuleContext.getChildOrNull(i: Int): T? = this.getChild(T::class.java, i)
inline fun <reified T : ParseTree> ParserRuleContext.getChild(i: Int): T = this.getChildOrNull<T>(i)!!

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

fun determineLLVMType(type: MainParser.TypeContext?, env: Env): LLVMTypeRef {
	if (type == null) return env.lookupType("").llvmType
	if (type.pointerType() != null) return env.lookupType("ptr").llvmType
	return env.lookupType(type.IDENTIFIER()!!.text).llvmType
}