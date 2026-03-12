package io.github.epicvon2468.bunny.test

import io.github.epicvon2468.bunny.v3_5.IR
import io.github.epicvon2468.bunny.v3_5.builder.funct
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
			0000_0010 "a" "i32"
			0000_0001
		""".trimIndent() + '\n'

		@Suppress("NOTHING_TO_INLINE")
		private inline fun input1(): IR.Funct = INPUT_1.reader().use(Reader::deserialisePrimary) as IR.Funct
	}

	@BeforeTest
	@AfterTest
	internal fun append() {
		println()
	}

	@Test
	fun serialiseFunctionTest1() {
		val function: IR.Funct = input1()
		val serialised: String = function.serialise(initSize = INPUT_1.length)
		assertEquals(
			expected = INPUT_1,
			actual = serialised
		)
		val reconstructed: IR.Funct = serialised.reader().use(Reader::deserialisePrimary) as IR.Funct
		assertEquals(
			expected = function,
			actual = reconstructed
		)
	}

	@Test
	fun builderTest1() {
		val function: IR.Funct = funct {
			name = "main"
			parameters = mutableListOf("i32", "P")
			returnType = "i32"
			body {
				def {
					name = "a"
					type = "i32"
				}
			}
		}
		assertEquals(
			expected = input1(),
			actual = function
		)
		assertEquals(
			expected = INPUT_1,
			actual = function.serialise()
		)
	}
}