package io.github.epicvon2468.bunny.v3_5

import java.io.Reader

fun Reader.read(count: Int): String = when {
	count == 1 -> this.read().toChar().toString()
	count > 1 -> CharArray(count).apply(this::read).concatToString()
	else -> throw IllegalArgumentException("Bad read request, cannot read zero or negative number of characters: $count!")
}

fun Reader.readInstruction(): Byte {
	val result: Byte = this.read(9).binaryToByte()
	this.skip(1)
	return result
}

fun Reader.readQuoted(defaultCapacity: Int = 16): String {
	val output: StringBuilder = StringBuilder(defaultCapacity)
	require(this.read(1) == "\"") { "Quoted element did not start with '\"'!" }
	while (true) {
		val next: Char = this.read().toChar()
		if (next == '"') break
		output.append(next)
	}
	return output.toString()
}

fun Reader.readIdentifier(defaultCapacity: Int = 16): Identifier = this.readQuoted(defaultCapacity).toIdentifier()

// PrimaryLexer.g4 vaguely defines the spec, although keyword stuff isn't important here since none of them are relevant
fun String.toIdentifier(): Identifier {
	fun badInput(): Nothing = throw IllegalArgumentException("Noncompliant String passed for Identifier conversion: \"$this\"!")
	if (this.isEmpty()) badInput()
	if (this == "_") badInput()
	if (this.length == 1 && this.single().isDigit()) badInput()
	// no whitespace, no quotes, and no characters which are not one of: [letter, digit, '_']
	if (this.any { it.isWhitespace() || it == '"' || (!it.isLetterOrDigit() && it != '_') }) badInput()
	return this
}

fun Reader.readParameters(): Parameters {
	TODO()
}

fun String.binaryToByte(): Byte = this.replace("_", "").toByte(radix = 2)