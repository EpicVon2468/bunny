@file:Suppress("FunctionName", "NOTHING_TO_INLINE")
package io.github.epicvon2468.bunny.util

import io.github.epicvon2468.bunny.util.option.*
import io.github.epicvon2468.bunny.util.option.Option.Companion.None

import kotlinx.io.EOFException
import kotlinx.io.IOException

data class StringSource(val underlying: String) {

	val lastIndex: Int = underlying.lastIndex

	val size: Int = underlying.length

	var index: Int = -1
		private set

	fun hasNext(): Boolean = index in -1..<lastIndex

	operator fun get(index: Int): Option<Char> = underlying.getOrNull(index).toOption()

	fun readChar(): Option<Char> = this[++index]
	fun peekChar(): Option<Char> = this[index + 1]

	inline fun readCodePoint(): Option<Int> = readChar().map(Char::code)
	inline fun peekCodePoint(): Option<Int> = peekChar().map(Char::code)

	fun skip(length: Int) {
		if (length == 0) return
		index += length
	}

	fun readLine(baseOutputCapacity: Int = 16): String {
		val output = StringBuilder(baseOutputCapacity)
		while (this.hasNext()) {
			val next: Char = (peekChar() or '\u0000'.toSome()).unwrap()
			if (
				when (next) {
					'\n', '\r' -> true
					'\u0000' -> break
					else -> false
				}
			) {
				skip(
					length = if (
						next == '\r' &&
						this[index + 2].isSomeAnd { it == '\n' || error("Expected \\r to be followed by \\n!") }
					) 2 else 1
				)
				break
			}
			output.append(next)
			skip(1)
		}
		return output.toString()
	}

	fun require(length: Int): Option<IOException> {
		val actualIndex: Int = index + length
		if (actualIndex == 0) return None()
		if (actualIndex !in 1..size) EOFException("Requested $length more chars, but only ${lastIndex - (index + length)}!").toSome()
		this[actualIndex].expect("TODO good log message")
		return None() // no need to actually check
	}

	fun reset() {
		this.index = -1
	}

	operator fun plus(other: StringSource): StringSource = StringSource(this.underlying + other.underlying)
	operator fun plus(other: String): StringSource = StringSource(this.underlying + other)
}