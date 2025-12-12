@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.codegen

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString

import llvm.LLVMContextCreate
import llvm.LLVMContextDispose
import llvm.LLVMContextRef
import llvm.LLVMCreatePassBuilderOptions
import llvm.LLVMCreateTargetMachineOptions
import llvm.LLVMCreateTargetMachineWithOptions
import llvm.LLVMDisposeModule
import llvm.LLVMDisposePassBuilderOptions
import llvm.LLVMDisposeTargetMachine
import llvm.LLVMGetDefaultTargetTriple
import llvm.LLVMGetFirstTarget
import llvm.LLVMInitializeNativeTarget as LLVMInitialiseNativeTarget
import llvm.LLVMModuleCreateWithNameInContext
import llvm.LLVMModuleRef
import llvm.LLVMPassBuilderOptionsRef
import llvm.LLVMPrintModuleToFile
import llvm.LLVMRunPasses
import llvm.LLVMTargetMachineRef

data object CodeGen {

	val CONTEXT: LLVMContextRef = LLVMContextCreate()!!

	val modules: MutableList<String> = mutableListOf()

	fun getFreeModuleID(base: String): String = if (base !in this.modules) base else this.getFreeModuleID("_$base")

	val TARGET_MACHINE: LLVMTargetMachineRef = LLVMInitialiseNativeTarget().run {
		LLVMCreateTargetMachineWithOptions(
			LLVMGetFirstTarget(),
			LLVMGetDefaultTargetTriple()!!.toKString(),
			LLVMCreateTargetMachineOptions()
		)!!
	}
	val PASS_BUILDER_OPTIONS: LLVMPassBuilderOptionsRef = LLVMCreatePassBuilderOptions()!!

	fun dispose() {
		LLVMContextDispose(this.CONTEXT)
		LLVMDisposeTargetMachine(this.TARGET_MACHINE)
		LLVMDisposePassBuilderOptions(this.PASS_BUILDER_OPTIONS)
	}

	fun withModule(
		moduleID: String,
		context: LLVMContextRef = this.CONTEXT,
		block: LLVMModuleRef.(LLVMContextRef) -> Unit
	) = LLVMModuleCreateWithNameInContext(moduleID, context)!!.let { module: LLVMModuleRef ->
		module.block(context)
		val safeID: String = this.getFreeModuleID(moduleID)
		LLVMRunPasses(module, "default<O3>", this.TARGET_MACHINE, this.PASS_BUILDER_OPTIONS)
		LLVMPrintModuleToFile(module, "output/$safeID.ll", null)
		this.modules += safeID
		LLVMDisposeModule(module)
	}
}