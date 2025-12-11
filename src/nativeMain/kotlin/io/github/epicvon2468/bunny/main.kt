package io.github.epicvon2468.bunny

import io.github.epicvon2468.bunny.llvm.*
import io.github.epicvon2468.bunny.parser.Lexer

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CArrayPointer
import kotlinx.cinterop.ExperimentalForeignApi as ShutUpAndLetMeUseCCode
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.set
import kotlinx.cinterop.toKString
import kotlinx.io.Source
import kotlinx.io.buffered
import kotlinx.io.files.FileNotFoundException
import kotlinx.io.files.FileSystem
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

import platform.posix.PATH_MAX
import platform.posix.fflush
import platform.posix.fprintf
import platform.posix.getenv
import platform.posix.readlink
import platform.posix.ssize_t
import platform.posix.stderr
import platform.posix.exit as _exit

// TODO: https://github.com/AlexPl292/Kaleidoscope-Kotlin-Llvm/
// 	https://www.pauladamsmith.com/blog/2015/01/how-to-get-started-with-llvm-c-api.html
// 	https://www.reddit.com/r/Compilers/comments/mrxyiz/looking_for_guidance_on_understandingusing_llvm_c/
// 	https://github.com/farzonl/expr-ir
// 	https://github.com/MWGuy/llvm-hello/blob/master/main.cpp
// 	https://mapping-high-level-constructs-to-llvm-ir.readthedocs.io/en/latest/index.html
@OptIn(ShutUpAndLetMeUseCCode::class)
fun main() {
	println("Hello, world!")
	val isDebug: Boolean = memScoped {
		val str: CArrayPointer<ByteVar> = allocArray<ByteVar>(PATH_MAX + 1)
		val length: ssize_t = readlink("/proc/self/exe", str, PATH_MAX.convert())
		str[length.toInt()] = '\u0000'.code.toByte()
		println("Got self path: ${str.toKString()}")

		"debugExecutable" in str.toKString()
	}
	if ((getenv("DEV_LLVM_LOCATION")?.toKString() == null || getenv("LIB_LLVM_LOCATION")?.toKString() == null) && isDebug) {
		fprintf(
			stderr,
			"""
				Warning!!!
				The provided LLVM installations were from the system, instead of from Nix!
				Continue to use system installations at own risk!
				Please include the fact that you aren't using Nix in any bug reports, alongside the location of your LLVM installations, and how they were installed.
				Support may potentially not be provided for user-installation-specific bugs.
			""".trimIndent() + '\n'
		)
		fflush(stderr)
	}
	CodeGen.TARGET_MACHINE
	memScoped {
		standardIO2()
		standardIO()
		struct()
		another()
		hello()
	}
	CodeGen.dispose()
	return
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