@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.shared

expect interface Token {

	fun getText(): String

	fun getType(): Int

	fun getLine(): Int

	fun getCharPositionInLine(): Int
}