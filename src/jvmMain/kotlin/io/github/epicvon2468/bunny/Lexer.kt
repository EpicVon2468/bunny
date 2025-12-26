package io.github.epicvon2468.bunny

import PrimaryLexer

import io.github.epicvon2468.bunny.token.Function
import io.github.epicvon2468.bunny.token.Identifier
import io.github.epicvon2468.bunny.token.Mutable
import io.github.epicvon2468.bunny.token.SerialisableToken
import io.github.epicvon2468.bunny.token.Token
import io.github.epicvon2468.bunny.token.TypeSpecifier
import io.github.epicvon2468.bunny.token.Variable

import org.antlr.v4.runtime.CharStreams

import kotlinx.serialization.json.Json

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

		funct main(/*arg_count: i32, args: **u8*/): i32 {
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
	val version: Version = lexer.nextAsVersion()
	if (version > Version.CURRENT) error("Unsupported newer version $version was provided; Maximum supported version was ${Version.CURRENT}!")
	println("Compiling valid version $version with compiler ${Version.CURRENT}!")
	val output: MutableList<SerialisableToken> = mutableListOf()
	while (true) {
		val token: Token = lexer.nextToken()
		when (token.type) {
			Token.EOF -> break
			PrimaryLexer.COMMENT, PrimaryLexer.DOCUMENTATION_COMMENT, PrimaryLexer.SECTION_COMMENT, PrimaryLexer.WHITESPACE, PrimaryLexer.NEWLINE -> continue
		}
		println("token: '${token.text.replace("\n", "\\n").replace("\t", "\\t")}', ${token.type.getName()}")
		val func: (Int, Int) -> SerialisableToken = when (token.type) {
			PrimaryLexer.FUNCTION -> ::Function
			PrimaryLexer.VARIABLE -> ::Variable
			PrimaryLexer.MUTABLE -> ::Mutable
			PrimaryLexer.TYPE_SPECIFIER -> ::TypeSpecifier
			PrimaryLexer.IDENTIFIER -> { line: Int, linePos: Int ->
				Identifier(token.text, line, linePos)
			}
			else -> continue
		}
		output += func(token.line, token.charPositionInLine)
	}
	println("Got out of loop!")
	val result: String = Json.encodeToString(output)
	println(result)
	val restored: List<SerialisableToken> = Json.decodeFromString(result)
	println(restored)
	println(output == restored)
}

fun PrimaryLexer.nextAsVersion(): Version = if (nextToken().type == PrimaryLexer.VERSION_DECLARATION) Version(
	token.text.substringAfter("VERSION").trim()
) else error("Expected version declaration, instead got ${token.type.getName()}")

fun Int.getName(): String = PrimaryLexer.VOCABULARY.getSymbolicName(this)