@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("FunctionName")
package io.github.epicvon2468.bunny.codegen.standard

import io.github.epicvon2468.bunny.codegen.FALSE
import io.github.epicvon2468.bunny.codegen.TRUE
import io.github.epicvon2468.bunny.codegen.getFunctionAndType

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.MemScope
import kotlinx.cinterop.allocArrayOf

import llvm.LLVMAddFunction
import llvm.LLVMAppendBasicBlockInContext
import llvm.LLVMBasicBlockRef
import llvm.LLVMBuildCall2
import llvm.LLVMBuildGlobalString
import llvm.LLVMBuildPointerCast
import llvm.LLVMBuildRetVoid
import llvm.LLVMBuilderRef
import llvm.LLVMContextRef
import llvm.LLVMFunctionType
import llvm.LLVMGetParam
import llvm.LLVMInt32TypeInContext
import llvm.LLVMInt64TypeInContext
import llvm.LLVMModuleRef
import llvm.LLVMPointerTypeInContext
import llvm.LLVMPositionBuilderAtEnd
import llvm.LLVMTypeRef
import llvm.LLVMValueRef
import llvm.LLVMVoidTypeInContext

fun MemScope.generateStandardIO(
	context: LLVMContextRef,
	module: LLVMModuleRef,
	builder: LLVMBuilderRef,
	headersOnly: Boolean = true
) {
	val ptrType: LLVMTypeRef = LLVMPointerTypeInContext(context, 0u)!! // String is 'char*'
	val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!
	val int64Type: LLVMTypeRef = LLVMInt64TypeInContext(context)!!

	LLVMAddFunction(
		module,
		"printf",
		LLVMFunctionType(
			/*returnType =*/ int32Type,
			/*paramTypes =*/ allocArrayOf(ptrType),
			/*paramCount =*/ 1u,
			/*isVarArg =*/ TRUE
		)!!
	)!!

	this.meta__generatePrintInt(
		context,
		module,
		builder,
		ptrType,
		int32Type,
		int64Type,
		headersOnly
	)
}

fun MemScope.meta__generatePrintInt(
	context: LLVMContextRef,
	module: LLVMModuleRef,
	builder: LLVMBuilderRef,
	ptrType: LLVMTypeRef,
	int32Type: LLVMTypeRef,
	int64Type: LLVMTypeRef,
	headersOnly: Boolean
) {
	this.generatePrintInt(
		context = context,
		module = module,
		builder = builder,
		ptrType = ptrType,
		intType = int32Type,
		num = "32",
		headersOnly = headersOnly
	)
	this.generatePrintInt(
		context = context,
		module = module,
		builder = builder,
		ptrType = ptrType,
		intType = int64Type,
		num = "64",
		headersOnly = headersOnly
	)
}

fun MemScope.generatePrintInt(
	context: LLVMContextRef,
	module: LLVMModuleRef,
	builder: LLVMBuilderRef,
	ptrType: LLVMTypeRef,
	intType: LLVMTypeRef,
	num: String,
	headersOnly: Boolean
) {
	val printIntFunction: LLVMValueRef = LLVMAddFunction(
		module,
		"print_i$num",
		LLVMFunctionType(
			/*returnType =*/ LLVMVoidTypeInContext(context),
			/*paramType =*/ allocArrayOf(intType),
			/*paramCount =*/ 1u,
			/*isVarArg =*/ FALSE
		)!!
	)!!

	if (headersOnly) return

	val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, printIntFunction, "entry")!!
	LLVMPositionBuilderAtEnd(builder, entry)
	val (printfFunction: LLVMValueRef, printfFunctionType: LLVMTypeRef) = module.getFunctionAndType("printf")
	LLVMBuildCall2(
		builder,
		printfFunctionType,
		printfFunction,
		allocArrayOf(
			LLVMBuildPointerCast(
				builder,
				LLVMBuildGlobalString(builder, "%d\n", "print_int_str"),
				ptrType,
				""
			),
			LLVMGetParam(printIntFunction, 0u)
		),
		2u,
		"call"
	)
	LLVMBuildRetVoid(builder)
}