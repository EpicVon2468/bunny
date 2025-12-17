@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.test

import io.github.epicvon2468.bunny.util.StringSource
import io.github.epicvon2468.bunny.util.option.*

import kotlinx.cinterop.ExperimentalForeignApi

import platform.posix.fflush
import platform.posix.stdout

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

// TODO: Implement
class StringSourceTests {

	val source: StringSource = StringSource(SENTENCE)

	@BeforeTest
	fun beforeEachTest() {
		this.source.reset()
	}

	@AfterTest
	fun afterEachTest() {
		fflush(stdout)
	}

	@Test
	fun read__0() {
		val output = StringBuilder(source.size)
		while (source.hasNext()) output.append(source.readChar().unwrap())
		println("read__0: '$output'")
		assertEquals(source.underlying, output.toString())
	}

	@Test
	fun readLine__0() {
		val output: String = source.readLine(source.size).unwrap()
		println("readLine__0: '$output'")
		assertEquals(source.underlying, output)
	}

	@Test
	fun readLine__1() {
		val source: StringSource = source + "\r\n" + source
		val output: String = source.readLine(SENTENCE.length).unwrap()
		println("readLine__1: '$output'")
		assertEquals(SENTENCE, output)
		val output2 = source.readLine().expect("Expected another sentence!")
		println("readLine__1: '$output2'")
		assertEquals(SENTENCE, output2)
	}

	@Test
	fun require__0() {

	}

	companion object {

		const val SENTENCE: String = "the quick brown fox jumps over the lazy dog"
	}
}