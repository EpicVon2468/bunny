package io.github.epicvon2468.bunny.v3_5

import java.io.Reader

fun Reader.read(count: Int): String = when {
	count == 1 -> this.read().toChar().toString()
	count > 1 -> CharArray(count).apply(this::read).concatToString()
	else -> throw IllegalArgumentException("Bad read request, cannot read zero or negative number of characters: $count!")
}

fun Reader.readInstruction(): Byte {
	val result: Byte = this.read(9).binaryToByte()
	this.skip(1)
	return result
}

fun String.binaryToByte(): Byte = this.replace("_", "").toByte(radix = 2)