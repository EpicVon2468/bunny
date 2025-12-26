@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.token

import PrimaryLexer

import org.antlr.v4.runtime.Token as Antlr4Token

actual typealias Token = Antlr4Token

actual fun getVariableType(): Int = PrimaryLexer.VARIABLE
actual fun getMutableType(): Int = PrimaryLexer.MUTABLE
actual fun getIdentifierType(): Int = PrimaryLexer.IDENTIFIER