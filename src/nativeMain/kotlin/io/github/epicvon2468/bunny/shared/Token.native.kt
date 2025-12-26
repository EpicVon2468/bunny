@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.shared

import kotlinx.serialization.Serializable as Serialisable

actual interface Token {

	actual fun getText(): String

	actual fun getType(): Int

	actual fun getLine(): Int

	actual fun getCharPositionInLine(): Int
}

@Serialisable
actual sealed interface SerialisableToken : Token {

	actual val text: String

	actual val type: Int

	actual val line: Int

	actual val linePos: Int

	actual override fun getText(): String = this.text

	actual override fun getType(): Int = this.type

	actual override fun getLine(): Int = this.line

	actual override fun getCharPositionInLine(): Int = this.linePos

	actual companion object {

		@Serialisable
		data class Variable(
			override val type: Int,
			override val line: Int,
			override val linePos: Int
		) : SerialisableToken {

			override val text: String = "variable"
		}

		@Serialisable
		data class Mutable(
			override val type: Int,
			override val line: Int,
			override val linePos: Int
		) : SerialisableToken {

			override val text: String = "mutable"
		}

		@Serialisable
		data class Identifier(
			override val text: String,
			override val type: Int,
			override val line: Int,
			override val linePos: Int
		): SerialisableToken
	}
}