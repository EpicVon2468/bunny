package io.github.epicvon2468.bunny

import TestLexer

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Token

@JvmField
val INPUT: String =
	"""
		fun main() {
		}
	""".trimIndent()

fun main(args: Array<String>) {
	println("Hello, world!")
	val lexer = TestLexer(CharStreams.fromString(INPUT, "<anonymous>"))
	while (true) {
		val token: Token = lexer.nextToken()
		if (token.type == Token.EOF) break
		println("token: '${token.text}', ${lexer.vocabulary.getSymbolicName(token.type)}")
	}
	println("Got out of loop!")
}