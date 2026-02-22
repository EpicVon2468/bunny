package io.github.epicvon2468.bunny.v3

import io.github.epicvon2468.bunny.v3.Instruction.Expression
import io.github.epicvon2468.bunny.v3.Instruction.Literal

sealed interface Instruction {

	data class FunctionBegin(val name: Identifier, val parameters: List<Type>) : Instruction
	data class FunctionEnd(val name: Identifier) : Instruction

	data class Define(val name: Identifier, val type: Type) : Instruction
	data class Store(val name: Identifier, val value: Instruction /*= Literal | Expression*/) : Instruction {

		init {
			checkLitOrExpr(value)
		}
	}
	data class Load(val name: Identifier, val type: Type) : Instruction

	data class Literal(val value: String, val type: Type) : Instruction
	data class Expression(val name: Identifier, val returnType: Type) : Instruction

	data class ExpressionBegin(val name: Identifier, val returnType: Type) : Instruction
	data class ExpressionEnd(val name: Identifier) : Instruction

	data class GroupBegin(val returnType: Type) : Instruction
	data class GroupEnd(val returnType: Type) : Instruction

	data class Return(val value: Instruction /*= Literal | Expression*/) : Instruction {

		init {
			checkLitOrExpr(value)
		}
	}
}

fun checkLitOrExpr(value: Instruction) {
	require(value is Literal || value is Expression) { "Value was not a Literal or an Expression!  Value: $value" }
}

typealias Type = String
typealias Identifier = String