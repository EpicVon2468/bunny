package io.github.epicvon2468.bunny.v3

sealed interface Instruction {

	data class FunctionBegin(val name: Identifier, val parameters: List<Type>) : Instruction
	data class FunctionEnd(val name: Identifier) : Instruction

	data class Define(val name: Identifier, val type: Type) : Instruction
	data class Store(val name: Identifier, val value: Value) : Instruction
	data class Load(val name: Identifier, val type: Type) : Instruction

	sealed interface Value : Instruction
	data class Literal(val value: String, val type: Type) : Value
	data class Expression(val name: Identifier, val returnType: Type) : Value

	data class ExpressionBegin(val name: Identifier, val returnType: Type) : Instruction
	data class ExpressionEnd(val name: Identifier) : Instruction

	data class GroupBegin(val returnType: Type) : Instruction
	data class GroupEnd(val returnType: Type) : Instruction

	data class Return(val value: Value) : Instruction
}

typealias Type = String
typealias Identifier = String