package io.github.epicvon2468.bunny.test

import io.github.epicvon2468.bunny.v3_5.IR
import io.github.epicvon2468.bunny.v3_5.deserialisePrimary

import java.io.Reader

import kotlin.test.Test
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class IRTest {

	companion object {

		@JvmField
		val INPUT_1: String = """
			0000_0000 "main" "i32;P" "i32"
			0000_0001
		""".trimIndent() + '\n'
	}

	@BeforeTest
	@AfterTest
	internal fun append() {
		println()
	}

	@Test
	fun serialiseFunctionTest1() {
		val function: IR.Funct = INPUT_1.reader().use(Reader::deserialisePrimary) as IR.Funct
		val serialised: String = function.serialise(initSize = INPUT_1.length)
		assertEquals(INPUT_1, serialised)
		val reconstructed: IR.Funct = serialised.reader().use(Reader::deserialisePrimary) as IR.Funct
		assertEquals(function, reconstructed)
	}
}