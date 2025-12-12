@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("FunctionName")
package io.github.epicvon2468.bunny.codegen.standard

import io.github.epicvon2468.bunny.codegen.FALSE
import io.github.epicvon2468.bunny.codegen.TRUE

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
import llvm.LLVMInt8TypeInContext
import llvm.LLVMModuleRef
import llvm.LLVMPointerType
import llvm.LLVMPositionBuilderAtEnd
import llvm.LLVMTypeRef
import llvm.LLVMValueRef
import llvm.LLVMVoidTypeInContext

typealias DeclaredFunctionsAndTypes = Pair<MutableMap<String, LLVMTypeRef>, MutableMap<String, LLVMValueRef>>

fun MemScope.generateStandardIO(
	context: LLVMContextRef,
	module: LLVMModuleRef,
	builder: LLVMBuilderRef,
	headersOnly: Boolean = true
): DeclaredFunctionsAndTypes {
	val int8Type: LLVMTypeRef = LLVMInt8TypeInContext(context)!!
	val int8PtrType: LLVMTypeRef = LLVMPointerType(int8Type, 0u)!! // String is 'char*'
	val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!
	val int64Type: LLVMTypeRef = LLVMInt64TypeInContext(context)!!

	val functionsAndTypes: DeclaredFunctionsAndTypes = mutableMapOf<String, LLVMTypeRef>() to mutableMapOf()

	val printfFunctionType: LLVMTypeRef = LLVMFunctionType(
		/*returnType =*/ int32Type,
		/*paramTypes =*/ allocArrayOf(int8PtrType),
		/*paramCount =*/ 1u,
		/*isVarArg =*/ TRUE
	)!!
	val printfFunction: LLVMValueRef = LLVMAddFunction(module, "printf", printfFunctionType)!!
	functionsAndTypes.first["printf"] = printfFunctionType
	functionsAndTypes.second["printf"] = printfFunction

	this.meta__generatePrintInt(
		context,
		module,
		builder,
		int8PtrType,
		int32Type,
		int64Type,
		functionsAndTypes,
		headersOnly,
	)

	return functionsAndTypes
}

fun MemScope.meta__generatePrintInt(
	context: LLVMContextRef,
	module: LLVMModuleRef,
	builder: LLVMBuilderRef,
	int8PtrType: LLVMTypeRef,
	int32Type: LLVMTypeRef,
	int64Type: LLVMTypeRef,
	functionsAndTypes: DeclaredFunctionsAndTypes,
	headersOnly: Boolean
) {
	this.generatePrintInt(
		context = context,
		module = module,
		builder = builder,
		int8PtrType = int8PtrType,
		intType = int32Type,
		functionsAndTypes = functionsAndTypes,
		num = "32",
		headersOnly = headersOnly
	)
	this.generatePrintInt(
		context = context,
		module = module,
		builder = builder,
		int8PtrType = int8PtrType,
		intType = int64Type,
		functionsAndTypes = functionsAndTypes,
		num = "64",
		headersOnly = headersOnly
	)
}

fun MemScope.generatePrintInt(
	context: LLVMContextRef,
	module: LLVMModuleRef,
	builder: LLVMBuilderRef,
	int8PtrType: LLVMTypeRef,
	intType: LLVMTypeRef,
	functionsAndTypes: DeclaredFunctionsAndTypes,
	num: String,
	headersOnly: Boolean,
) {
	val printIntFunctionType: LLVMTypeRef = LLVMFunctionType(
		/*returnType =*/ LLVMVoidTypeInContext(context),
		/*paramType =*/ allocArrayOf(intType),
		/*paramCount =*/ 1u,
		/*isVarArg =*/ FALSE
	)!!
	val printIntFunction: LLVMValueRef = LLVMAddFunction(module, "printI$num", printIntFunctionType)!!
	functionsAndTypes.first["printI$num"] = printIntFunctionType
	functionsAndTypes.second["printI$num"] = printIntFunction

	if (headersOnly) return

	val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, printIntFunction, "entry")!!
	LLVMPositionBuilderAtEnd(builder, entry)
	LLVMBuildCall2(
		builder,
		functionsAndTypes.first["printf"]!!,
		functionsAndTypes.second["printf"]!!,
		allocArrayOf(
			LLVMBuildPointerCast(
				builder,
				LLVMBuildGlobalString(builder, "%d\n", "printIntStr"),
				int8PtrType,
				""
			),
			LLVMGetParam(printIntFunction, 0u)
		),
		2u,
		"call"
	)
	LLVMBuildRetVoid(builder)
}