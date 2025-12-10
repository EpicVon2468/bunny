@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import kotlinx.cinterop.ExperimentalForeignApi

import llvm.LLVMBuilderRef
import llvm.LLVMDisposeBuilder

fun <T : Any?> LLVMBuilderRef.use(block: (LLVMBuilderRef) -> T): T = block(this).let { returnValue: T ->
	LLVMDisposeBuilder(this)
	returnValue
}