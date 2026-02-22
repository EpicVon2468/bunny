package io.github.epicvon2468.bunny.v3

import java.io.BufferedReader
import java.io.StringReader

data class IRReader(val input: String) : AutoCloseable {

	val output: MutableList<Instruction> = mutableListOf()

	val source: BufferedReader = BufferedReader(StringReader(input))

	fun read(): Char = source.read().toChar()
	fun read(count: Int): String = CharArray(count).apply(source::read).concatToString()
	fun skip(n: Long = 1): Long = source.skip(n)

	fun start() {
		matchInstruction()
	}

	tailrec fun matchInstruction() {
		val first: Char = read()
		if (first == INVALID) return
		if (first == '#') {
			source.readLine()
			return matchInstruction()
		}
		val instFunct: () -> Unit
		when (val out: String = first + read(2)) {
			// fBegin
			"fBe" -> {
				skip(3)
			}
			// fEnd
			"fEn" -> {
				skip()
			}
			// def
			"def" -> {
			}
			// store
			"sto" -> {
				skip(2)
			}
			// load
			"loa" -> {
				skip()
			}
			// lit
			"lit" -> {
			}
			// expr
			"exp" -> {
				skip()
			}
			// eBegin
			"eBe" -> {
				skip(3)
			}
			// eEnd
			"eEn" -> {
				skip()
			}
			// gBegin
			"gBe" -> {
				skip(3)
			}
			// gEnd
			"gEn" -> {
				skip()
			}
			// _op
			"_op" -> {
			}
			// ret
			"ret" -> {
			}
			else -> return println(out)
		}
		// ' '
		skip(1)
		return matchInstruction()
	}

	override fun close() = source.close()

	companion object {

		const val INVALID: Char = 1.unaryMinus().toChar()
	}
}