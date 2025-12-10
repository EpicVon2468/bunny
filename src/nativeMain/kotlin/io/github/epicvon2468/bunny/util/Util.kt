@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.util

import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativeFreeablePlacement
import kotlinx.cinterop.free
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.toKString
import kotlinx.io.Source
import kotlinx.io.files.Path
import kotlinx.io.readCodePointValue

import platform.posix.errno
import platform.posix.strerror

fun Source.readChar(): Char = this.readCodePointValue().toChar()

fun <R> Source.peek(block: (Source) -> R): R = this.peek().use(block)

/**
 * Might be too resource-expensive?  Consider refactoring?
 */
fun Source.peekChar(): Char = this.peek(Source::readChar)

operator fun Path.plus(other: String): String = this.toString() + (if (other.startsWith('/')) "" else '/') + other

fun <T : CPointed, R> CPointer<T>.use(
	placement: NativeFreeablePlacement = nativeHeap,
	block: (CPointer<T>) -> R
) = try { block(this) } finally { placement.free(this) }

fun printErrorNo(): Nothing = memScoped { error("Got error: ${strerror(errno)?.toKString()}") }

val IDENTIFIER: Regex = Regex("(^[a-zA-Z0-9_\\-$]+$)")