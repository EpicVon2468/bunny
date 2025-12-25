package io.github.epicvon2468.bunny

import PrimaryLexer

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Token

const val INPUT: String =
	"""
		VERSION 0 0 0

		type String {

			fun abc() {}
		}

		singleton type Blah {

			fun abc(str: String) {}
		}

		funct main(): i32 {
			//thismightﬀbreakit
			define str: String = String::new();
			1 == 2;
			define str2:String=String::new();
			1==2;
			"foobar";
			define blah: Blah = Blah::instance();
			blah.abc(str2);
			return 0;
		}

		funct abc(d: String, e: String, f: String) {}
	"""

// https://tomassetti.me/antlr-mega-tutorial/#chapter23
// https://github.com/antlr/antlr4/blob/dev/doc/wildcard.md
fun main(args: Array<String>) {
	println("Hello, world!")
	val lexer = PrimaryLexer(CharStreams.fromString(INPUT, "<anonymous>"))
	while (true) {
		val token: Token = lexer.nextToken()
		if (token.type == Token.EOF) break
		println("token: '${token.text.replace("\n", "\\n")}', ${token.type.getName()}")
	}
	println("Got out of loop!")
}

fun Int.getName(): String = PrimaryLexer.VOCABULARY.getSymbolicName(this)