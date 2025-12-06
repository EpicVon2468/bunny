package io.github.epicvon2468.bunny.util

import kotlinx.io.Source

fun Source.readChar(): Char = this.readByte().toInt().toChar()

fun <R> Source.peek(block: (Source) -> R): R = this.peek().use(block)

fun Source.peekChar(): Char = this.peek(Source::readChar)

val IDENTIFIER: Regex = Regex("(^[a-zA-Z0-9_\\-$]+$)")