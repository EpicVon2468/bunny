package io.github.epicvon2468.bunny.v3

import java.io.BufferedReader

data class IRReader(val source: BufferedReader) : AutoCloseable {

	fun read(count: Int): String {
		val out = CharArray(count)
		this.source.read(out)
		return out.joinToString()
	}

	override fun close() = this.source.close()
}