package io.github.epicvon2468.bunny.v3

import java.io.BufferedReader
import java.io.FileReader

fun main() = IRReader(BufferedReader(FileReader("./sampleIR"))).use {
	println(it.source.readAllAsString())
}