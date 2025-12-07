package io.github.epicvon2468.bunny

import io.github.epicvon2468.bunny.parser.Lexer

import kotlinx.io.Source
import kotlinx.io.buffered
import kotlinx.io.files.FileNotFoundException
import kotlinx.io.files.FileSystem
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

import platform.posix.exit as _exit

// TODO: https://github.com/AlexPl292/Kaleidoscope-Kotlin-Llvm/
// 	https://www.pauladamsmith.com/blog/2015/01/how-to-get-started-with-llvm-c-api.html
// 	https://www.reddit.com/r/Compilers/comments/mrxyiz/looking_for_guidance_on_understandingusing_llvm_c/
// 	https://github.com/farzonl/expr-ir
fun main() {
	println("Hello, world!")
	val source: Source = try {
		with(SystemFileSystem) { source("./in.todoFileExtensionHere") }
	} catch (e: FileNotFoundException) {
		e.printStackTrace()
		exit(66) // EX_NOINPUT
	}
	val lexer = Lexer(source)
	val status: Int = lexer.start()
	source.close()
	exit(status)
}

fun FileSystem.source(src: String): Source = this.source(Path(src)).buffered()

fun exit(status: Int): Nothing {
	_exit(status)
	error("Impossible to reach this point!  exit() should not have returned normally!")
}