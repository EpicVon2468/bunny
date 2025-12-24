package io.github.epicvon2468.bunny

import PrimaryLexer

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Token

const val INPUT: String =
	"""
		fun main() {
			thismightﬀbreakit;
			Type type = new Type();
			1 == 2;
			Type type=new Type();
			1==2;
			"foobar";
		}
		fun abc(d: String, e: String, f: String) {}
	"""

// https://tomassetti.me/antlr-mega-tutorial/#chapter23
// https://github.com/antlr/antlr4/blob/dev/doc/wildcard.md
fun main(args: Array<String>) {
	println("Hello, world!")
	val lexer = PrimaryLexer(CharStreams.fromString(INPUT, "<anonymous>"))
	while (true) {
		val token: Token = lexer.nextToken()
		if (token.type == Token.EOF) break
		println("token: '${token.text}', ${token.type.getName()}")
	}
	println("Got out of loop!")
}

fun Int.getName(): String = PrimaryLexer.VOCABULARY.getSymbolicName(this)