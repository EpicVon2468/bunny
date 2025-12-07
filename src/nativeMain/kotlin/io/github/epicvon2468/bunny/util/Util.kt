package io.github.epicvon2468.bunny.util

import kotlinx.io.Source
import kotlinx.io.readCodePointValue

fun Source.readChar(): Char = this.readCodePointValue().toChar()

fun <R> Source.peek(block: (Source) -> R): R = this.peek().use(block)

/**
 * Might be too resource-expensive?  Consider refactoring?
 */
fun Source.peekChar(): Char = this.peek(Source::readChar)

val IDENTIFIER: Regex = Regex("(^[a-zA-Z0-9_\\-$]+$)")