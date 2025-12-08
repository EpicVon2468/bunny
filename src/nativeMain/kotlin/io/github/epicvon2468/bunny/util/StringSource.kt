@file:Suppress("FunctionName")
package io.github.epicvon2468.bunny.util

import io.github.epicvon2468.bunny.util.option.*

data class StringSource(val underlying: String) {

	var index: Int = -1
		private set

	fun hasNext(): Boolean = index < underlying.lastIndex

	fun __readChar(index: Int): Option<Char> = underlying.getOrNull(index).toOption()

	fun readChar(): Option<Char> = __readChar(++index)

	fun peekChar(): Option<Char> = __readChar(index + 1)
}