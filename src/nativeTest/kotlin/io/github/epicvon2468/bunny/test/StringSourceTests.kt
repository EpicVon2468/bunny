package io.github.epicvon2468.bunny.test

import io.github.epicvon2468.bunny.util.StringSource

import kotlin.test.BeforeTest
import kotlin.test.Test

// TODO: Implement
class StringSourceTests {

	val source: StringSource = StringSource("the quick brown fox jumps over the lazy dog")

	@BeforeTest
	fun beforeEachTest() {
		this.source.reset()
	}

	@Test
	fun read() {

	}

	@Test
	fun require() {

	}
}