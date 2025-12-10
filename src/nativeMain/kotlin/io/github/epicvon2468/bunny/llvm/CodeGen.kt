@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import kotlinx.cinterop.ExperimentalForeignApi

import llvm.LLVMContextCreate
import llvm.LLVMContextDispose
import llvm.LLVMContextRef
import llvm.LLVMDisposeModule
import llvm.LLVMModuleCreateWithNameInContext
import llvm.LLVMModuleRef
import llvm.LLVMPrintModuleToFile

data object CodeGen {

	val CONTEXT: LLVMContextRef = LLVMContextCreate()!!

	val modules: MutableList<String> = mutableListOf()

	fun getFreeModuleID(base: String): String = if (base !in this.modules) base else this.getFreeModuleID("_$base")

	fun dispose() {
		LLVMContextDispose(this.CONTEXT)
	}

	fun withModule(
		moduleID: String,
		context: LLVMContextRef = this.CONTEXT,
		block: LLVMModuleRef.(LLVMContextRef) -> Unit
	) = LLVMModuleCreateWithNameInContext(moduleID, context)!!.let { module: LLVMModuleRef ->
		module.block(context)
		val safeID: String = this.getFreeModuleID(moduleID)
		LLVMPrintModuleToFile(module, "output/$safeID.ll", null)
		this.modules += safeID
		LLVMDisposeModule(module)
	}
}