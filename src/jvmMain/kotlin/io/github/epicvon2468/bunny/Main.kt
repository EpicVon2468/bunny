package io.github.epicvon2468.bunny

import generated.antlr.MainBaseListener
import generated.antlr.MainLexer
import generated.antlr.MainParser

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode

import org.llvm.Core_h.*

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

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
			parser.addParseListener(main)
			parser.top()//.accept(main)
		}
	}
}

data class Main(
	val parser: MainParser,
	val arena: Arena,
	val context: MemorySegment,
	val name: String
) : MainBaseListener(), ParseTreeVisitor<Unit>, AutoCloseable {

	val module: MemorySegment = LLVMModuleCreateWithNameInContext(arena.allocateFrom(name), context)
	val builder: MemorySegment = LLVMCreateBuilderInContext(context)

	override fun enterTop(ctx: MainParser.TopContext) {
		println("Entered top: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun exitTop(ctx: MainParser.TopContext) {
		println("Exited top: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun enterTopLevel(ctx: MainParser.TopLevelContext) {
		println("Entered topLevel: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun exitTopLevel(ctx: MainParser.TopLevelContext) {
		println("Exited topLevel: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun enterFunctionDefinition(ctx: MainParser.FunctionDefinitionContext) {
		println("Entered funct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
		println(ctx.IDENTIFIER())
	}

	override fun exitFunctionDefinition(ctx: MainParser.FunctionDefinitionContext) {
		println("Exited funct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
		println(ctx.IDENTIFIER())
	}

	override fun enterStructDefinition(ctx: MainParser.StructDefinitionContext) {
		println("Entered struct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun exitStructDefinition(ctx: MainParser.StructDefinitionContext) {
		println("Exited struct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun close() {
		LLVMDisposeBuilder(builder)
		println("'''\n${LLVMPrintModuleToString(module).getString(0)}'''")
		LLVMDisposeModule(module)
		LLVMContextDispose(context)
	}

	// uncalled...
	override fun visit(tree: ParseTree) {
		println("Got tree: '${tree.text}' :: ${tree.childCount}")
	}

	override fun visitChildren(node: RuleNode) {
		//println("Got node: '${node.text}', ${node::class.simpleName} :: ${node.childCount}")
		if (node.childCount <= 0) visit(node)
		var current = 0
		while (current < node.childCount) {
			node.getChild(current).accept(this)
			current++
		}
	}

	override fun visitTerminal(node: TerminalNode) {
		println("Got terminal: '${node.text}' :: ${node.javaClass.simpleName}")
	}

	override fun visitErrorNode(node: ErrorNode) {
		println("Got error: '${node.text}' :: ${node.childCount}")
	}
}