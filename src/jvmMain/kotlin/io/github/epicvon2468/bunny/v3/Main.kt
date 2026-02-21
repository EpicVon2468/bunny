package io.github.epicvon2468.bunny.v3

import java.io.File

fun main(): Unit = IRReader(File("./sampleIR").readText()).use {
	println(it.source.readAllBytes().decodeToString())
}