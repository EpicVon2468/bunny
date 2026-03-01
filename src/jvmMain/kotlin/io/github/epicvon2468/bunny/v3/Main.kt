package io.github.epicvon2468.bunny.v3

import java.io.File

fun main(): Unit //= IRReader(File("./sampleIR").readText()).use(IRReader::start)
{
	val serialised = Serial.deserialise("0000_0010").serialise()
	println(serialised)
}