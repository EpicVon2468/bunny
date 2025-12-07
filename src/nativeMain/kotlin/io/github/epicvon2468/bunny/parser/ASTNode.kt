package io.github.epicvon2468.bunny.parser

import io.github.epicvon2468.bunny.util.IDENTIFIER

sealed interface ASTNode

value class Literal<T>(val value: T) : ASTNode

value class Variable<T>(val value: T) : ASTNode

data class Function(
	val args: List<Type>,
	val returnType: Type,
	val name: String,
	val module: String = "standard",
	//val body: ASTNode
) : ASTNode {

	init {
		require(IDENTIFIER matches this.name) { "Invalid name: \"${this.name}\"!" }
		require(IDENTIFIER matches this.module) { "Invalid module: \"${this.module}\"!" }
	}
}

data class Type(val underlyingClass: String) : ASTNode