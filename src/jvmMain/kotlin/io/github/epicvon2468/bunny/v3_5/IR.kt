package io.github.epicvon2468.bunny.v3_5

import java.io.Reader

fun main() {
	try {
		deserialisePrimary("""0000_0000 "main" "i32;P" "i32"""".reader())
	} catch (e: Throwable) {
		// System.err seems to get flushed manually, and then System.out only gets flushed from process exit, meaning errors show first
		System.out.flush()
		throw RuntimeException(e)
	}
}

sealed interface IR {

	data class Funct(
		val name: Identifier,
		val parameters: List<Identifier>,
		val returnType: Type,
		val body: List<Instruction>
	) : IR {

		companion object {

			@JvmStatic
			fun deserialise(mode: Byte, input: Reader): Funct {
				val fBegin: Instruction.FBegin = deserialiseInstruction(input = input, op = mode)
				println("Got fBegin: $fBegin")
				TODO()
			}
		}
	}
}

sealed interface Instruction {

	data class FBegin(val name: Identifier, val parameters: List<Identifier>, val returnType: Type) : Instruction {

		companion object {

			const val OP: Byte = 0b0000_0000

			@JvmStatic
			fun deserialise(input: Reader): FBegin {
				val name: Identifier = input.readIdentifier()
				// whitespace
				input.skip(1)
				val parameters: List<Identifier> = input.readParameters()
				// whitespace
				input.skip(1)
				val returnType: Type = input.readIdentifier(5)
				// newline
				input.skip(1)
				return FBegin(name, parameters, returnType)
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

typealias Identifier = String
typealias Type = String