@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import kotlinx.cinterop.*

import llvm.LLVMAddFunction
import llvm.LLVMAppendBasicBlockInContext
import llvm.LLVMBasicBlockRef
import llvm.LLVMBool
import llvm.LLVMBuildCall2
import llvm.LLVMBuildGlobalString
import llvm.LLVMBuildPointerCast
import llvm.LLVMBuildRet
import llvm.LLVMBuilderRef
import llvm.LLVMConstInt
import llvm.LLVMContextRef
import llvm.LLVMCreateBuilderInContext
import llvm.LLVMDisposeBuilder
import llvm.LLVMDisposeModule
import llvm.LLVMFunctionType
import llvm.LLVMInt32TypeInContext
import llvm.LLVMInt8TypeInContext
import llvm.LLVMModuleCreateWithNameInContext
import llvm.LLVMModuleRef
import llvm.LLVMPointerType
import llvm.LLVMPositionBuilderAtEnd
import llvm.LLVMPrintModuleToFile
import llvm.LLVMTypeRef
import llvm.LLVMValueRef

inline val TRUE: LLVMBool get() = 1
inline val FALSE: LLVMBool get() = 0

fun hello(): Unit = memScoped {
	val context: LLVMContextRef = BunnyCodeGen.CONTEXT
	val module: LLVMModuleRef = LLVMModuleCreateWithNameInContext(/*ModuleID =*/ "bunny", context)!!
	val builder: LLVMBuilderRef = LLVMCreateBuilderInContext(context)!!

	val int8Type: LLVMTypeRef = LLVMInt8TypeInContext(context)!!
	val int8TypePtr: LLVMTypeRef = LLVMPointerType(int8Type, 0u)!! // String is 'char*'
	val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!

	// Puts function
	val putsFunctionArgsType: CArrayPointer<CPointerVarOf<LLVMTypeRef>> = allocArrayOf(
		int8TypePtr
	)

	val putsFunctionType: LLVMTypeRef = LLVMFunctionType(
		/*ReturnType =*/ int32Type,
		/*ParamTypes =*/ putsFunctionArgsType,
		/*ParamCount =*/ 1u,
		/*IsVarArg =*/ FALSE
	)!!
	val putsFunction: LLVMValueRef = LLVMAddFunction(module, "puts", putsFunctionType)!!
	// end

	// Main function
	val mainFunctionType: LLVMTypeRef = LLVMFunctionType(
		/*ReturnType =*/ int32Type,
		/*ParamTypes =*/ null,
		/*ParamCount =*/ 0u,
		/*IsVarArg =*/ FALSE
	)!!
	val mainFunction: LLVMValueRef = LLVMAddFunction(module, "main", mainFunctionType)!!

	val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, mainFunction, "entry")!!
	LLVMPositionBuilderAtEnd(builder, entry)

	val putsFunctionArgs: CArrayPointer<CPointerVarOf<LLVMValueRef>> = allocArrayOf(
		LLVMBuildPointerCast(
			/*arg0 =*/ builder,
			/*Val =*/ LLVMBuildGlobalString(builder, "Hello, world!", "hello"),
			/*DestTy =*/ int8TypePtr,
			/*Name =*/ "0",
		)
	)

	LLVMBuildCall2(
		/*arg0 =*/ builder,
		/*arg1 =*/ putsFunctionType,
		/*Fn =*/ putsFunction,
		/*Args =*/ putsFunctionArgs,
		/*NumArgs =*/ 1u,
		/*Name =*/ "i"
	)
	LLVMBuildRet(builder, LLVMConstInt(/*IntTy =*/ int32Type, /*N =*/ 0u, /*SignExtend =*/ FALSE))
	// end

	LLVMPrintModuleToFile(module, "bunny2.ll", null)

	LLVMDisposeBuilder(builder)
	LLVMDisposeModule(module)
	BunnyCodeGen.dispose()
}