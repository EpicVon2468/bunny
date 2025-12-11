@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.convert

import llvm.LLVMBuildRet
import llvm.LLVMBuilderRef
import llvm.LLVMConstInt
import llvm.LLVMDisposeBuilder
import llvm.LLVMTypeRef

fun <T : Any?> LLVMBuilderRef.use(block: (LLVMBuilderRef) -> T): T = block(this).let { returnValue: T ->
	LLVMDisposeBuilder(this)
	returnValue
}

fun LLVMBuilderRef.buildIntReturn0(intType: LLVMTypeRef) = this.buildIntReturn(intType, 0)

fun LLVMBuilderRef.buildIntReturn(intType: LLVMTypeRef, value: Int) = LLVMBuildRet(this, LLVMConstInt(intType, value.convert(), FALSE))