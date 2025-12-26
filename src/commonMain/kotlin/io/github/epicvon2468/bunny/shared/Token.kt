@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.shared

import kotlinx.serialization.Serializable as Serialisable

expect interface Token {

	fun getText(): String

	fun getType(): Int

	fun getLine(): Int

	fun getCharPositionInLine(): Int
}

@Serialisable
expect sealed interface SerialisableToken : Token {

	val text: String

	val type: Int

	val line: Int

	val linePos: Int

	open override fun getText(): String

	open override fun getType(): Int

	open override fun getLine(): Int

	open override fun getCharPositionInLine(): Int
}