@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "RedundantModalityModifier")
package io.github.epicvon2468.bunny.token

import kotlinx.serialization.Serializable as Serialisable

expect interface Token {

	fun getText(): String

	fun getType(): Int

	fun getLine(): Int

	fun getCharPositionInLine(): Int
}

@Serialisable
sealed interface SerialisableToken : Token {

	val text: String

	val line: Int

	val linePos: Int

	val type: Int

	override fun getText(): String = this.text

	override fun getLine(): Int = this.line

	override fun getCharPositionInLine(): Int = this.linePos

	override fun getType(): Int = this.type
}

@Serialisable
@ConsistentCopyVisibility
data class Variable private constructor(
	override val line: Int,
	override val linePos: Int,
	override val type: Int
) : SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getVariableType())

	override val text: String = "define"
}

expect fun getVariableType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Mutable private constructor(
	override val line: Int,
	override val linePos: Int,
	override val type: Int
) : SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getMutableType())

	override val text: String = "mutable"
}

expect fun getMutableType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Identifier private constructor(
	override val text: String,
	override val line: Int,
	override val linePos: Int,
	override val type: Int
): SerialisableToken {

	constructor(text: String, line: Int, linePos: Int) : this(text, line, linePos, getIdentifierType())
}

expect fun getIdentifierType(): Int