package io.github.epicvon2468.bunny.parser

sealed interface ASTNode

value class Literal<T>(val value: T) : ASTNode

value class Variable<T>(val value: T) : ASTNode

data class Function(val args: List<Type>, val returnType: Type) : ASTNode

data class Type(val underlyingClass: String) : ASTNode