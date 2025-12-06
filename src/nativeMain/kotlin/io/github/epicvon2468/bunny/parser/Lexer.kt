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

data class Lexer(val input: Source) {

	val output: MutableList<KeywordInstance> = mutableListOf()

	// https://man.openbsd.org/sysexits.3
	fun start(): Int {
		try {
			checkNotEOF()

			checkVersion()
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

	fun skipSpaces(uncertain: Boolean = false) {
		if (uncertain) checkNotEOF()

		var amount: Long = 0
		input.peek { peekSource: Source ->
			var char: Char = peekSource.readChar()
			while (char.isWhitespace() && !peekSource.exhausted()) {
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
			"cal" -> {
				require(input.readChar() == 'l')
				println("call")
				parseIdentifier(uncertain = true)
			}
			Keywords.GET -> {
				println("get")
				parseIdentifier(uncertain = true)
			}
			Keywords.SET -> {
				println("set")
				parseIdentifier(uncertain = true)
				parseIdentifier(uncertain = true)
			}
		}
	}

	fun parseIdentifier(uncertain: Boolean = false, skipSpaces: Boolean = true): String {
		if (skipSpaces) skipSpaces(uncertain)
		else if (uncertain) checkNotEOF()

		var identifier: String = input.readChar().toString()
		while (hasNext()) {
			val updatedIdentifier = identifier + input.readChar().also { next: Char ->
				if (next.isWhitespace()) return identifier.also(::println)
			}
			if (IDENTIFIER matches updatedIdentifier) identifier = updatedIdentifier
			else break
		}
		// Short-circuit evaluation _should_ save me here (in theory).
		if (hasNext() && !input.peekChar().isWhitespace()) error("Invalid identifier attempt.  Identifier was valid with: \"$identifier\".")
		return identifier.also(::println)
	}

	fun hasNext(): Boolean = !input.exhausted()

	fun checkNotEOF() {
		if (!hasNext()) throw EOFException("Reached end of source, was expecting more!")
	}
}