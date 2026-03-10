package io.github.epicvon2468.bunny.v3_5

fun Int.toBinaryString(): String = Integer.toBinaryString(this).takeLast(8).padStart(8, '0')
fun Byte.toBinaryString(): String = toInt().toBinaryString()
fun UByte.toBinaryString(): String = toInt().toBinaryString()