package io.github.epicvon2468.bunny

import PrimaryLexer

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Token

const val INPUT: String =
	"""VERSION 0 0 0

//		define constant BLEH: Boolean = true
//
//		type String {
//
//			fun abc() {}
//		}
//
//		singleton type Blah {
//
//			fun abc(str: String) {}
//		}

		funct main(arg_count: i32, args: **u8): i32 {
			define a: i32 = 5;
			define mutable b: i32 = 10;
			b = a + b
			return b;
		}

		/*
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
		*/

//		funct abc(d: String, e: String, f: String) {}
	"""

// https://tomassetti.me/antlr-mega-tutorial/#chapter23
// https://github.com/antlr/antlr4/blob/dev/doc/wildcard.md
fun main(args: Array<String>) {
	println("Hello, world!")
	val lexer = PrimaryLexer(CharStreams.fromString(INPUT, "<anonymous>"))
	if (lexer.nextToken().type == PrimaryLexer.VERSION_DECLARATION) {
		val version: Version = lexer.token.text.substringAfter("VERSION").trim().let(Version::invoke)
		if (version > Version.CURRENT) error("Unsupported newer version $version was provided; Maximum supported version was ${Version.CURRENT}!")
		println("Compiling valid version $version with compiler ${Version.CURRENT}!")
	} else error("Expected version declaration, instead got ${lexer.token.type.getName()}")
	while (true) {
		val token: Token = lexer.nextToken()
		when (token.type) {
			Token.EOF -> break
			PrimaryLexer.COMMENT, PrimaryLexer.DOCUMENTATION_COMMENT, PrimaryLexer.SECTION_COMMENT, PrimaryLexer.WHITESPACE, PrimaryLexer.NEWLINE -> continue
		}
		println("token: '${token.text.replace("\n", "\\n").replace("\t", "\\t")}', ${token.type.getName()}")
	}
	println("Got out of loop!")
}

fun Int.getName(): String = PrimaryLexer.VOCABULARY.getSymbolicName(this)