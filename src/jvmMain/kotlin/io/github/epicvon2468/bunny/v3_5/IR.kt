package io.github.epicvon2468.bunny.v3_5

import io.github.epicvon2468.bunny.v3_5.builder.funct

import java.io.CharArrayWriter
import java.io.Reader
import java.io.Writer

fun main() {
	try {
		main2()
		main1()
	} catch (e: Throwable) {
		// System.err seems to get flushed manually, and then System.out only gets flushed from process exit, meaning errors show first
		System.out.flush()
		throw RuntimeException(e)
	}
}

private fun main2() {
	val funct: IR.Funct = funct {
		name = "main"
		parameters("i32", "P")
		returnType = "i32"
		body {
			def {
				name = "a"
				type = "i32"
			}
		}
	}
	val serialise: String = funct.serialise()
	println(serialise)
}

private fun main1() {
	val input: String = """
			0000_0000 "main" "i32;P" "i32"
			0000_0010 "a" "i32"
			0000_0001
		""".trimIndent()
	val function: IR.Funct = input.reader().use(Reader::deserialisePrimary) as IR.Funct
	println()
	val serialised: String = function.serialise(initSize = 40).dropLast(1)
	println("'''")
	println(input)
	println("'''")
	println(serialised)
	println("'''")
	println(serialised == input)
}

interface Serialisable {

	fun serialise(output: Writer)

	fun serialise(initSize: Int = 100): String = CharArrayWriter(initSize).apply(this::serialise).toString()
}

sealed interface IR : Serialisable {

	data class Funct(
		val name: Identifier,
		val parameters: List<Identifier>,
		val returnType: Type,
		val body: List<Instruction>
	) : IR {

		override fun serialise(output: Writer) {
			Instruction.FBegin(this.name, this.parameters, this.returnType).serialise(output)
			for (entry: Instruction in this.body) entry.serialise(output)
			Instruction.FEnd.serialise(output)
		}

		companion object {

			@JvmStatic
			fun deserialise(mode: Byte, input: Reader): Funct {
				val fBegin: Instruction.FBegin = input.deserialiseInstruction(op = mode)
				val body: MutableList<Instruction> = mutableListOf()
				while (true) {
					val next: Instruction = input.deserialiseInstruction()
					if (next is Instruction.FEnd) break
					body.add(next)
				}
				println("Got fBegin: $fBegin")
				println("Got body: $body")
				return Funct(
					name = fBegin.name,
					parameters = fBegin.parameters,
					returnType = fBegin.returnType,
					body = body
				)
			}
		}
	}
}

sealed interface Instruction : Serialisable {

	data class FBegin(
		val name: Identifier,
		val parameters: List<Identifier>,
		val returnType: Type
	) : Instruction {

		override fun serialise(output: Writer) {
			output.write(OP_C)
			output.write(' ')
			output.write(name.quoted())
			output.write(' ')
			output.write(parameters.joinToString(separator = ";", prefix = "\"", postfix = "\""))
			output.write(' ')
			output.write(returnType.quoted())
			output.write('\n')
		}

		companion object {

			const val OP: Byte = 0b0000_0000
			const val OP_C: String = "0000_0000"

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

	data object FEnd : Instruction {

		const val OP: Byte = 0b0000_0001
		const val OP_C: String = "0000_0001"

		// Can't @JvmStatic an override fun
		override fun serialise(output: Writer): Unit = output.write("$OP_C\n")

		@JvmStatic
		fun deserialise(input: Reader): FEnd = this.apply { input.skip(1) }
	}

	data class Def(
		val name: Identifier,
		val type: Type
	) : Instruction {

		override fun serialise(output: Writer) {
			output.write(OP_C)
			output.write(' ')
			output.write(name.quoted())
			output.write(' ')
			output.write(type.quoted())
			output.write('\n')
		}

		companion object {

			const val OP: Byte = 0b0000_0010
			const val OP_C: String = "0000_0010"

			@JvmStatic
			fun deserialise(input: Reader): Def {
				val name: Identifier = input.readIdentifier()
				input.skip(1)
				val type: Type = input.readIdentifier()
				input.skip(1)
				return Def(name, type)
			}
		}
	}
}

fun Reader.deserialisePrimary(): IR = when (val binary: Byte = this.readInstruction()) {
	Instruction.FBegin.OP -> IR.Funct.deserialise(binary, this)
	else -> TODO()
}

fun <T : Instruction> Reader.deserialiseInstruction(op: Byte? = null): T {
	val op: Byte = op ?: this.readInstruction()
	@Suppress("UNCHECKED_CAST")
	return when (op) {
		Instruction.FBegin.OP -> Instruction.FBegin.deserialise(this)
		Instruction.FEnd.OP -> Instruction.FEnd.deserialise(this)
		Instruction.Def.OP -> Instruction.Def.deserialise(this)
		else -> TODO()
	} as T
}

typealias Identifier = String
typealias Type = Identifier