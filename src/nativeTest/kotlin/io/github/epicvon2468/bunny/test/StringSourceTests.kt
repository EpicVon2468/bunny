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
		assertEquals(source.underlying, output.toString())
		println("read__0: $output")
	}

	@Test
	fun readLine__0() {
		val output: String = source.readLine(source.size).unwrap()
		assertEquals(source.underlying, output)
		println("readLine__0: $output")
	}

	@Test
	fun readLine__1() {
		val source: StringSource = source + "\r\n" + source
		val output: String = source.readLine(SENTENCE.length).unwrap()
		assertEquals(SENTENCE, output)
		println("readLine__1: $output")
		val output2 = source.readRemaining().expect("Expected another sentence still!")
		assertEquals(SENTENCE, output2)
		println("readLine__1: $output2")
	}

	@Test
	fun require__0() {

	}

	companion object {

		const val SENTENCE: String = "the quick brown fox jumps over the lazy dog"
	}
}