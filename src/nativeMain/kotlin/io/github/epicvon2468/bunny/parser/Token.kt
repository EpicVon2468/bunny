package io.github.epicvon2468.bunny.parser

sealed interface Token {

	value class Grouping(val body: List<Token>) : Token

	// '^'
	value class Exponent(val upper: Grouping) : Token

	// '/'
	data object Division : Token

	// '*'
	data object Multiplication : Token

	// '+'
	data object Addition : Token

	// '-'
	data object Subtraction : Token

	value class Identifier(val value: String) : Token

	sealed interface Value : Token {

		value class String(val value: kotlin.String) : Value

		value class Boolean(val value: kotlin.Boolean) : Value
	}

	data object Call : Token
}