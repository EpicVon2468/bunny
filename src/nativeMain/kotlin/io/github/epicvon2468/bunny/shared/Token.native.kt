@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.shared

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable as Serialisable

actual interface Token {

	actual fun getText(): String

	actual fun getType(): Int

	actual fun getLine(): Int

	actual fun getCharPositionInLine(): Int

	companion object {

		@Serialisable
		sealed interface NativeToken : Token {

			val text: String

			val type: Int

			val line: Int

			val linePos: Int

			override fun getText(): String = this.text

			override fun getType(): Int = this.type

			override fun getLine(): Int = this.line

			override fun getCharPositionInLine(): Int = this.linePos
		}

		@Serialisable
		data class Variable(
			override val type: Int,
			override val line: Int,
			override val linePos: Int
		) : NativeToken {

			override val text: String = "variable"
		}

		@Serialisable
		data class Mutable(
			override val type: Int,
			override val line: Int,
			override val linePos: Int
		) : NativeToken {

			override val text: String = "mutable"
		}

		@Serialisable
		data class Identifier(
			override val text: String,
			override val type: Int,
			override val line: Int,
			override val linePos: Int
		): NativeToken
	}
}