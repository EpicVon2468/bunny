package io.github.epicvon2468.bunny.parser

import io.github.epicvon2468.bunny.Version
import io.github.epicvon2468.bunny.util.IDENTIFIER
import io.github.epicvon2468.bunny.util.readChar
import io.github.epicvon2468.bunny.util.peek
import io.github.epicvon2468.bunny.util.peekChar

import kotlinx.io.EOFException
import kotlinx.io.IOException
import kotlinx.io.Source
import kotlinx.io.files.FileNotFoundException
import kotlinx.io.readLine
import kotlinx.io.readString

// TODO: Lexer should return Token (sealed class).
data class Lexer(val input: Source) {

	val output: MutableList<ASTNode> = mutableListOf()

	// https://man.openbsd.org/sysexits.3
	fun start(): Int {
		try {
			checkVersion(uncertain = true)
			parse(uncertain = true)
		} catch (e: EOFException) {
			e.printStackTrace()
			return 65 // EX_DATAERR
		} catch (e: FileNotFoundException) {
			e.printStackTrace()
			return 66 // EX_NOINPUT
		} catch (e: IOException) {
			e.printStackTrace()
			return 74 // EX_IOERR
		} catch (e: Exception) {
			e.printStackTrace()
			return -1
		}
		return 0
	}

	fun checkVersion(uncertain: Boolean = false) {
		if (uncertain) checkNotEOF()

		input.require(13) // "VERSION M M R".  Bare minimum amount of bytes needed.  Could be more due to multi-digit numbers
		val version: Version = Version.parse(input.readLine()!!.substringAfter("VERSION "))
		if (version > Version.CURRENT)
			error("Cannot use newer version: $version!  Current supported version is: ${Version.CURRENT}")
	}

	fun parse(uncertain: Boolean = false) {
		if (uncertain) checkNotEOF()

		do parseExpression() while (hasNext())
	}

	fun skipSpaces(uncertain: Boolean = false, stopAtNewline: Boolean = false) {
		if (uncertain) checkNotEOF()

		var amount: Long = 0
		input.peek { peekSource: Source ->
			var char: Char = peekSource.readChar()
			while (char.isWhitespace() && !peekSource.exhausted()) {
				if (char == '\n' && stopAtNewline) break
				amount++
				char = peekSource.readChar()
			}
		}
		input.skip(amount)
	}

	fun parseExpression(uncertain: Boolean = false) {
		skipSpaces(uncertain)

		input.require(3) // All keywords are at minimum three characters long.  "call", "get", "set", "itr", so on.
		when (input.readString(3)) {
			// require skip \n or ;
			"cal" -> {
				require(input.readChar() == 'l')
				println("call")
				parseIdentifier(uncertain = true)
				if (hasNext()) skipSpaces(stopAtNewline = true)
			}
			Keywords.GET -> {
				println("get")
				parseIdentifier(uncertain = true)
				if (hasNext()) skipSpaces(stopAtNewline = true)
			}
			Keywords.SET -> {
				println("set")
				parseIdentifier(uncertain = true)
				skipSpaces(stopAtNewline = true)
				parseIdentifier(uncertain = true, skipSpaces = false)
				if (hasNext()) skipSpaces(stopAtNewline = true)
			}
		}
	}

	fun parseIdentifier(uncertain: Boolean = false, skipSpaces: Boolean = true): String {
		if (skipSpaces) skipSpaces(uncertain)
		else if (uncertain) checkNotEOF()

		var identifier: String = input.readChar().toString()
		if (!(IDENTIFIER matches identifier)) error("Invalid identifier! Got: \"$identifier\".")
		while (hasNext()) {
			if (input.peekChar().isWhitespace()) break
			val updatedIdentifier = identifier + input.readChar()
			if (IDENTIFIER matches updatedIdentifier) identifier = updatedIdentifier
			else error("Invalid identifier attempt.  Identifier was valid with: \"$identifier\", invalid with: \"$updatedIdentifier\".")
		}
		return identifier.also(::println)
	}

	fun hasNext(): Boolean = !input.exhausted()

	fun checkNotEOF() {
		if (!hasNext()) throw EOFException("Reached end of source, was expecting more!")
	}
}