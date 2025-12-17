@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.test

import io.github.epicvon2468.bunny.util.StringSource
import io.github.epicvon2468.bunny.util.option.unwrap

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
	fun read() {
		val output = StringBuilder(SENTENCE.length)
		while (this.source.hasNext()) output.append(this.source.readChar().unwrap())
		assertEquals(output.toString(), SENTENCE)
		println("output: $output")
	}

	@Test
	fun readLine__1() {
		println(this.source.readLine(SENTENCE.length))
	}

	@Test
	fun require() {

	}

	companion object {

		const val SENTENCE: String = "the quick brown fox jumps over the lazy dog"
	}
}