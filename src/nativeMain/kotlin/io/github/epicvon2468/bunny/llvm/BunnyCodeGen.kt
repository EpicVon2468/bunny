@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString

import llvm.LLVMContextCreate
import llvm.LLVMContextDispose
import llvm.LLVMContextRef
import llvm.LLVMDisposeModule
import llvm.LLVMModuleCreateWithNameInContext
import llvm.LLVMModuleRef
import llvm.LLVMPrintModuleToString

data object BunnyCodeGen {

	val CONTEXT: LLVMContextRef = LLVMContextCreate()!!

	val dumpedStrings: MutableMap<String, String> = mutableMapOf()

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