package io.github.epicvon2468.bunny

import generated.antlr.MainBaseListener
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
		Main(parser, arena, LLVMContextCreate(), "test").use { main: Main ->
			//parser.addParseListener(main)
			parser.top().accept(MainVisitor<Unit>(main))
		}
	}
}

data class Main(
	val parser: MainParser,
	val arena: Arena,
	val context: MemorySegment,
	val name: String
) : MainBaseListener(), AutoCloseable {

	val module: MemorySegment = LLVMModuleCreateWithNameInContext(arena.allocateFrom(name), context)
	val builder: MemorySegment = LLVMCreateBuilderInContext(context)

	var topLevel: TopLevel = TopLevel.NONE

	override fun enterVersion(ctx: MainParser.VersionContext) {
		topLevel = TopLevel.VERSION
	}

	override fun exitVersion(ctx: MainParser.VersionContext) {
		topLevel = TopLevel.NONE
	}

	override fun enterFunctionDefinition(ctx: MainParser.FunctionDefinitionContext) {
		println("Entered funct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
		topLevel = TopLevel.FUNCTION
	}

	override fun exitFunctionDefinition(ctx: MainParser.FunctionDefinitionContext) {
		println("Exited funct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
		topLevel = TopLevel.NONE
	}

	override fun enterFunctionBody(ctx: MainParser.FunctionBodyContext) {
		println("Entered funct body: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun exitFunctionBody(ctx: MainParser.FunctionBodyContext) {
		println("Exited funct body: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun enterStructDefinition(ctx: MainParser.StructDefinitionContext) {
		println("Entered struct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
		topLevel = TopLevel.STRUCT
	}

	override fun exitStructDefinition(ctx: MainParser.StructDefinitionContext) {
		println("Exited struct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
		topLevel = TopLevel.NONE
	}

	override fun close() {
		LLVMDisposeBuilder(builder)
		println("'''\n${LLVMPrintModuleToString(module).getString(0)}'''")
		LLVMDisposeModule(module)
		LLVMContextDispose(context)
	}

	override fun visitTerminal(node: TerminalNode) {
		println("Got terminal: '${node.text}'  ::  ${node.javaClass.simpleName}")
	}

	override fun visitErrorNode(node: ErrorNode) {
		println("Got error: '${node.text}'")
	}
}

data class MainVisitor<T>(
	val main: Main,
	val parser: MainParser = main.parser,
	val arena: Arena = main.arena,
	val context: MemorySegment = main.context,
	val name: String = main.name
) : ParseTreeVisitor<T> {

	val module: MemorySegment = main.module
	val builder: MemorySegment = main.builder

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
		return null
	}

	override fun visitTerminal(node: TerminalNode): T? {
		return null
	}

	override fun visitErrorNode(node: ErrorNode): T? {
		return null
	}
}

enum class TopLevel {
	VERSION,
	FUNCTION,
	STRUCT,
	NONE
}