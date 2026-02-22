package io.github.epicvon2468.bunny.v3

import java.io.BufferedReader
import java.io.StringReader

data class IRReader(val input: String) : AutoCloseable {

	val output: MutableList<Instruction> = mutableListOf()

	val source: BufferedReader = BufferedReader(StringReader(input))

	fun read(count: Int): String = CharArray(count).apply(source::read).concatToString()

	fun start() {
		matchInstruction()
	}

	tailrec fun matchInstruction() {
		val first: Char = source.read().toChar()
		if (first == INVALID) return
		if (first == '#') {
			source.readLine()
			return matchInstruction()
		}
		when (first + read(2)) {
			// fBegin
			"fBe" -> {}
			// fEnd
			"fEn" -> {}
			// def
			"def" -> {}
			// store
			"sto" -> {}
			// load
			"loa" -> {}
			// lit
			"lit" -> {}
			// expr
			"exp" -> {}
			// eBegin
			"eBe" -> {}
			// eEnd
			"eEn" -> {}
			// gBegin
			"gBe" -> {}
			// gEnd
			"gEn" -> {}
			// ret
			"ret" -> {}
		}
		return matchInstruction()
	}

	override fun close() = source.close()

	companion object {

		const val INVALID: Char = (-1).toChar()
	}
}