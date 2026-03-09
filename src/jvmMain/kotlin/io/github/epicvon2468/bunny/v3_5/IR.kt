package io.github.epicvon2468.bunny.v3_5

import java.io.Reader

sealed interface IR {

	data class Funct(
		val name: String,
		val parameters: Parameters,
		val returnType: Type
	) : IR {

		companion object {

			@JvmStatic
			fun deserialise(mode: Byte, input: Reader): Funct {
				val fBegin: Instruction.FBegin = deserialiseInstruction(input = input, op = mode) as Instruction.FBegin
				TODO()
			}
		}
	}
}

sealed interface Instruction {

	data class FBegin(val name: String, val parameters: Parameters, val returnType: Type) : Instruction {

		companion object {

			const val OP: Byte = 0b0000_0000

			@JvmStatic
			fun deserialise(input: Reader): Instruction {
				TODO()
			}
		}
	}
}

fun deserialisePrimary(input: Reader): IR = when (val binary: Byte = input.readInstruction()) {
	Instruction.FBegin.OP -> IR.Funct.deserialise(binary, input)
	else -> TODO()
}

fun <T : Instruction> deserialiseInstruction(input: Reader, op: Byte? = null): T {
	val op: Byte = op ?: input.readInstruction()
	@Suppress("UNCHECKED_CAST")
	return when (op) {
		Instruction.FBegin.OP -> Instruction.FBegin.deserialise(input)
		else -> TODO()
	} as T
}

typealias Parameters = String

typealias Type = String