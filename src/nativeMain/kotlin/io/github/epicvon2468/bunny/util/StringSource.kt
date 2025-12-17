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

	fun skip(length: Int = 1) {
		if (length == 0) return
		index += length
	}

	fun readLine(baseOutputCapacity: Int = 16): Option<String> {
		if (!hasNext()) return None()
		if (peekChar().isSomeAnd('\n'::equals)) {
			skip()
			return None()
		}
		val output = StringBuilder(baseOutputCapacity)
		while (hasNext()) when (val next: Char = readChar().unwrap()) {
			'\n' -> break
			'\r' -> continue
			else -> output.append(next)
		}
		return output.toString().toSome()
	}

	fun readRemaining(): Option<String> {
		if (!hasNext()) return None()
		val output = StringBuilder(lastIndex - index)
		while (hasNext()) output.append(readChar().unwrap())
		return output.toString().toSome()
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

	inline operator fun plus(other: StringSource): StringSource = StringSource(this.underlying + other.underlying)
	inline operator fun plus(other: String): StringSource = StringSource(this.underlying + other)

	override fun toString(): String =
		"StringSource { underlying = \"$underlying\", index = $index, hasNext = ${hasNext()} }"
}