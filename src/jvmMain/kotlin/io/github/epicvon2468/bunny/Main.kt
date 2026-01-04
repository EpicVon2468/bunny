package io.github.epicvon2468.bunny

import generated.antlr.MainBaseListener
import generated.antlr.MainLexer
import generated.antlr.MainParser

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main() {
	println("Hello, world!")
	val parser = MainParser(CommonTokenStream(MainLexer(CharStreams.fromFileName("input.bun"))))
	parser.addParseListener(Main(parser))
	parser.top()
}

class Main(val parser: MainParser) : MainBaseListener() {

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
	}

	override fun exitFunctionDefinition(ctx: MainParser.FunctionDefinitionContext) {
		println("Exited funct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun enterStructDefinition(ctx: MainParser.StructDefinitionContext) {
		println("Entered struct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}

	override fun exitStructDefinition(ctx: MainParser.StructDefinitionContext) {
		println("Exited struct: ${ctx.toInfoString(parser)}  ::  [${ctx.childCount}]")
	}
}