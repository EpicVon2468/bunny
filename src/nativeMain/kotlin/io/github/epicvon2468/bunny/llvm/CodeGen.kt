@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import io.github.epicvon2468.bunny.util.plus
import io.github.epicvon2468.bunny.util.printErrorNo

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

import llvm.LLVMContextCreate
import llvm.LLVMContextDispose
import llvm.LLVMContextRef
import llvm.LLVMDisposeModule
import llvm.LLVMModuleCreateWithNameInContext
import llvm.LLVMModuleRef
import llvm.LLVMPrintModuleToString

import platform.posix.FILE
import platform.posix.PATH_MAX
import platform.posix.fclose
import platform.posix.fflush
import platform.posix.fopen
import platform.posix.fprintf
import platform.posix.getcwd
import platform.posix.stderr

data object CodeGen {

	val CONTEXT: LLVMContextRef = LLVMContextCreate()!!

	private val dumpedStrings: MutableMap<String, String> = mutableMapOf()

	fun dumpAll(): Unit = with(SystemFileSystem) {
		val outputFolder = Path(
			(getcwd(null, PATH_MAX.convert()) ?: printErrorNo()).toKString() + "/output"
		)
		this.createDirectories(outputFolder)
		for ((name: String, content: String) in this@CodeGen.dumpedStrings) memScoped {
			val file: CPointer<FILE>? = fopen(outputFolder + name + ".ll", "w")
			if (file == null) {
				fprintf(stderr, "ERROR!  Couldn't open file '$name' under folder '$outputFolder'!")
				fflush(stderr)
				continue
			}
			fprintf(file, content)
			fflush(file)
			fclose(file)
		}
	}

	fun getDumpName(base: String): String = if (base !in this.dumpedStrings) base else this.getDumpName("_$base")

	fun dispose() {
		LLVMContextDispose(this.CONTEXT)
	}

	fun withModule(
		moduleID: String,
		context: LLVMContextRef = this.CONTEXT,
		block: LLVMModuleRef.(LLVMContextRef) -> Unit
	) = LLVMModuleCreateWithNameInContext(moduleID, context)!!.let { module: LLVMModuleRef ->
		module.block(context)
		this.dumpedStrings[this.getDumpName(moduleID)] = LLVMPrintModuleToString(module)!!.toKString()
		LLVMDisposeModule(module)
	}
}