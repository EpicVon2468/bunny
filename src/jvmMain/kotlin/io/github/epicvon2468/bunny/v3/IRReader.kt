package io.github.epicvon2468.bunny.v3

import java.io.BufferedInputStream
import java.io.ByteArrayInputStream

data class IRReader(val input: String) : AutoCloseable {

	val source: BufferedInputStream = BufferedInputStream(ByteArrayInputStream(input.toByteArray()))

	fun read(count: Int): String = ByteArray(count).apply(source::read).decodeToString()

	override fun close() = source.close()
}