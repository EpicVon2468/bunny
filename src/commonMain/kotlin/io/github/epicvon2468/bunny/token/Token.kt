@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.token

import kotlinx.serialization.Serializable as Serialisable

expect interface Token {

	fun getText(): String

	fun getType(): Int

	fun getLine(): Int

	fun getCharPositionInLine(): Int

	// stuff I can't get rid of:
	fun getChannel(): Int
	fun getTokenIndex(): Int
	fun getStartIndex(): Int
	fun getStopIndex(): Int
	fun getTokenSource(): TokenSource
	fun getInputStream(): CharStream
}

@Serialisable
@Suppress("PropertyName") // Had conflicts to deal with.
sealed interface SerialisableToken : Token {

	val _text: String

	val _line: Int

	val linePos: Int

	val _type: Int

	override fun getText(): String = this._text

	override fun getLine(): Int = this._line

	override fun getCharPositionInLine(): Int = this.linePos

	override fun getType(): Int = this._type

	// stuff I can't get rid of:
	override fun getChannel(): Int = error("")
	override fun getTokenIndex(): Int = error("")
	override fun getStartIndex(): Int = error("")
	override fun getStopIndex(): Int = error("")
	override fun getTokenSource(): TokenSource = error("")
	override fun getInputStream(): CharStream = error("")
}

expect interface TokenSource
expect interface CharStream

@Serialisable
@ConsistentCopyVisibility
data class Addition private constructor(
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
): SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getAdditionType())

	override val _text: String = "+"
}

expect fun getAdditionType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Assignment private constructor(
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
): SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getAssignmentType())

	override val _text: String = "="
}

expect fun getAssignmentType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Termination private constructor(
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
): SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getTerminationType())

	override val _text: String = ";"
}

expect fun getTerminationType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Function private constructor(
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
): SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getFunctionType())

	override val _text: String = "funct"
}

expect fun getFunctionType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Variable private constructor(
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
) : SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getVariableType())

	override val _text: String = "define"
}

expect fun getVariableType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Mutable private constructor(
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
) : SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getMutableType())

	override val _text: String = "mutable"
}

expect fun getMutableType(): Int

@Serialisable
@ConsistentCopyVisibility
data class TypeSpecifier private constructor(
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
) : SerialisableToken {

	constructor(line: Int, linePos: Int) : this(line, linePos, getTypeSpecifierType())

	override val _text: String = ":"
}

expect fun getTypeSpecifierType(): Int

@Serialisable
@ConsistentCopyVisibility
data class Identifier private constructor(
	override val _text: String,
	override val _line: Int,
	override val linePos: Int,
	override val _type: Int
): SerialisableToken {

	constructor(text: String, line: Int, linePos: Int) : this(text, line, linePos, getIdentifierType())
}

expect fun getIdentifierType(): Int