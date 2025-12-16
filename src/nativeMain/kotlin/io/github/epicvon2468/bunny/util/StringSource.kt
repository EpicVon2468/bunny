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

	fun hasNext(): Boolean = index in -1..lastIndex

	operator fun get(index: Int): Option<Char> = underlying.getOrNull(index).toOption()

	fun readChar(): Option<Char> = this[++index]
	fun peekChar(): Option<Char> = this[index + 1]

	inline fun readCodePoint(): Option<Int> = readChar().map(Char::code)
	inline fun peekCodePoint(): Option<Int> = peekChar().map(Char::code)

	fun require(length: Int): Option<IOException> {
		val actualIndex: Int = index + length
		if (actualIndex == 0) return None()
		if (actualIndex !in 1..size) Option.Some(EOFException("Requested $length more chars, but only ${lastIndex - (index + length)}!"))
		this[actualIndex].expect("TODO good log message")
		return None() // no need to actually check
	}

	fun reset() {
		this.index = -1
	}
}