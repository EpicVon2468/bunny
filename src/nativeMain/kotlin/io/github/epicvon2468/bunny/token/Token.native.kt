@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.token

actual interface Token {

	actual fun getText(): String

	actual fun getType(): Int

	actual fun getLine(): Int

	actual fun getCharPositionInLine(): Int

	actual fun getChannel(): Int
	actual fun getTokenIndex(): Int
	actual fun getStartIndex(): Int
	actual fun getStopIndex(): Int
	actual fun getTokenSource(): TokenSource
	actual fun getInputStream(): CharStream
}

actual interface TokenSource
actual interface CharStream

actual fun getFunctionType(): Int = -1
actual fun getVariableType(): Int = -1
actual fun getMutableType(): Int = -1
actual fun getIdentifierType(): Int = -1
actual fun getTypeSpecifierType(): Int = -1