@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.codegen

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.convert

import llvm.LLVMBool
import llvm.LLVMBuildRet
import llvm.LLVMBuilderRef
import llvm.LLVMConstInt
import llvm.LLVMDisposeBuilder
import llvm.LLVMGetNamedFunction
import llvm.LLVMGlobalGetValueType
import llvm.LLVMModuleRef
import llvm.LLVMTypeRef
import llvm.LLVMValueRef

inline val TRUE: LLVMBool get() = 1
inline val FALSE: LLVMBool get() = 0

fun <T> LLVMBuilderRef.use(block: (LLVMBuilderRef) -> T): T = block(this).let { returnValue: T ->
	LLVMDisposeBuilder(this)
	returnValue
}

fun LLVMModuleRef.getFunctionAndType(name: String): Pair<LLVMValueRef, LLVMTypeRef> =
	LLVMGetNamedFunction(this, name)!!.let {
		it to LLVMGlobalGetValueType(it)!!
	}

fun LLVMBuilderRef.buildIntReturn0(intType: LLVMTypeRef) = this.buildIntReturn(intType, 0)

fun LLVMBuilderRef.buildIntReturn(intType: LLVMTypeRef, value: Int) =
	LLVMBuildRet(this, LLVMConstInt(intType, value.convert(), FALSE))