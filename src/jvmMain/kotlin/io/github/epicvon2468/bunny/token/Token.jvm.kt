@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
package io.github.epicvon2468.bunny.token

import PrimaryLexer

import org.antlr.v4.runtime.Token as Antlr4Token
import org.antlr.v4.runtime.TokenSource as Antlr4TokenSource
import org.antlr.v4.runtime.CharStream as Antlr4CharStream

actual typealias Token = Antlr4Token
actual typealias TokenSource = Antlr4TokenSource
actual typealias CharStream = Antlr4CharStream

actual fun getTerminationType(): Int = PrimaryLexer.TERMINATION
actual fun getFunctionType(): Int = PrimaryLexer.FUNCTION
actual fun getVariableType(): Int = PrimaryLexer.VARIABLE
actual fun getMutableType(): Int = PrimaryLexer.MUTABLE
actual fun getTypeSpecifierType(): Int = PrimaryLexer.TYPE_SPECIFIER
actual fun getIdentifierType(): Int = PrimaryLexer.IDENTIFIER