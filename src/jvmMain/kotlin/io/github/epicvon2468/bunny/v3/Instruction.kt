package io.github.epicvon2468.bunny.v3

import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

import kotlin.reflect.KClass

sealed interface Instruction : Serial {

	override fun serialise(): String = Serial.INST_TO_BINARY[this::class].toString()

	data class FunctionBegin(val name: Identifier, val parameters: List<Type>) : Instruction
	data class FunctionEnd(val name: Identifier) : Instruction

	data class Define(val name: Identifier, val type: Type) : Instruction
	data class Store(val name: Identifier, val value: Value) : Instruction
	data class Load(val name: Identifier, val type: Type) : OpcodeValue

	sealed interface Value : OpcodeValue
	data class Literal(val value: String, val type: Type) : Value
	data class Expression(val name: Identifier, val returnType: Type) : Value

	data class ExpressionBegin(val name: Identifier, val returnType: Type) : Instruction
	data class ExpressionEnd(val name: Identifier) : Instruction

	data class GroupBegin(val returnType: Type) : Instruction
	data class GroupEnd(val returnType: Type) : Instruction

	sealed interface OpcodeValue : Instruction
	data class InvokeOpcode(val value: Opcode, val lhs: OpcodeValue, val rhs: OpcodeValue) : Instruction

	data class Return(val value: Value) : Instruction
}

interface Serial {

	fun serialise(): String = TODO()
	fun deserialise(input: String): Instruction {
		val translated = input.substring(0..3) + input.substring(5..8)
		println("input: $translated")
		val klass = BINARY_TO_INST[translated.toByte(radix = 2)]!!.java
		println("class: $klass")
		val lookup: MethodHandles.Lookup = MethodHandles.privateLookupIn(klass, MethodHandles.lookup())
		val handle = lookup.findStatic(klass, "deserialise", MethodType.methodType(Instruction::class.java, String::class.java))
		TODO()
	}

	companion object : Serial {

		val INST_TO_BINARY: Map<KClass<out Instruction>, Byte> = mapOf(
			Instruction.FunctionBegin::class to 0b0000_0000,
			Instruction.FunctionEnd::class to 0b0000_0001,
			Instruction.Define::class to 0b0000_0010,
			Instruction.Store::class to 0b0000_0011,
			Instruction.Load::class to 0b0000_0100,
			Instruction.Literal::class to 0b0000_0101,
			Instruction.Expression::class to 0b0000_0110,
			Instruction.ExpressionBegin::class to 0b0000_0111,
			Instruction.ExpressionEnd::class to 0b0000_1000,
			Instruction.GroupBegin::class to 0b0000_1001,
			Instruction.GroupEnd::class to 0b0000_1010,
			Instruction.InvokeOpcode::class to 0b0000_1011,
			Instruction.Return::class to 0b0000_1100
		)

		val BINARY_TO_INST: Map<Byte, KClass<out Instruction>> = INST_TO_BINARY.map(Map.Entry<KClass<out Instruction>, Byte>::toPair).associate { it.second to it.first }
	}
}

enum class Opcode {

	/**
	 * Signed Integer Division
	 */
	SIDIV,

	/**
	 * Unsigned Integer Division
	 */
	UIDIV,

	/**
	 * Floating-Point Division
	 */
	FDIV,

	/**
	 * Signed Integer Multiplication
	 */
	SIMUL,

	/**
	 * Unsigned Integer Multiplication
	 */
	UIMUL,

	/**
	 * Floating-Point Multiplication
	 */
	FMUL,

	/**
	 * Signed Integer Addition
	 */
	SIADD,

	/**
	 * Unsigned Integer Addition
	 */
	UIADD,

	/**
	 * Floating-Point Addition
	 */
	FADD,

	/**
	 * Singed Integer Subtraction
	 */
	SISUB,

	/**
	 * Unsigned Integer Subtraction
	 */
	UISUB,

	/**
	 * Floating-Point Subtraction
	 */
	FSUB
}

typealias Type = String
typealias Identifier = String