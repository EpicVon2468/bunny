@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import kotlinx.cinterop.*

import llvm.LLVMAddFunction
import llvm.LLVMAppendBasicBlockInContext
import llvm.LLVMBasicBlockRef
import llvm.LLVMBool
import llvm.LLVMBuildAdd
import llvm.LLVMBuildAlloca
import llvm.LLVMBuildCall2
import llvm.LLVMBuildGlobalString
import llvm.LLVMBuildPointerCast
import llvm.LLVMBuildRet
import llvm.LLVMBuilderRef
import llvm.LLVMConstInt
import llvm.LLVMContextRef
import llvm.LLVMCreateBuilderInContext
import llvm.LLVMFunctionType
import llvm.LLVMGetParam
import llvm.LLVMInt32TypeInContext
import llvm.LLVMInt8TypeInContext
import llvm.LLVMPointerType
import llvm.LLVMPositionBuilderAtEnd
import llvm.LLVMStructCreateNamed
import llvm.LLVMStructSetBody
import llvm.LLVMTypeRef
import llvm.LLVMValueRef

// FIXME: It was `.toKString()`. Report this to JetBrains via YouTrack / Slack.
// TODO: Using `Name = "i"` is causing variables to be named `7` and breaking references to them. `%i` is valid, so this shouldn't be happening.
//		It gets worse.  To be concise for future me, I'll map it out.
//		"a" = "0x0.07ffc7d0d0948p-1022"
//		"b" = "111"
//		"c" = ""
//		"d" = "7"
//		"i" = "7"
//		"m" = "Success"
//		"n" = wipes the entire file
//		"o" = "7"
//		"p" = "0x7"
//		"q" = either "" or "%", not sure which.
//		"r" = "r"
//		"s" = non-zero exit value 139, blank file
//		"t" = see "q"
//		"u" = "7"
//		"v" = "v"

inline val TRUE: LLVMBool get() = 1
inline val FALSE: LLVMBool get() = 0

fun MemScope.struct() = CodeGen.withModule("testThree") { context: LLVMContextRef ->
	LLVMCreateBuilderInContext(context)!!.use { builder: LLVMBuilderRef ->
		val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!
		val int8Type: LLVMTypeRef = LLVMInt8TypeInContext(context)!!
		val structType: LLVMTypeRef = LLVMStructCreateNamed(
			context,
			"myStruct"
		)!!
		// LLVMStructTypeInContext(
		//			/*c =*/ context,
		//			/*elementTypes =*/ allocArrayOf(
		//				int8Type,
		//				int8Type
		//			),
		//			/*elementCount =*/ 2u,
		//			/*packed =*/ FALSE
		//		)!!
		LLVMStructSetBody(
			structType,
			allocArrayOf(
				int8Type,
				int8Type
			),
			2u,
			FALSE
		)

		val mainFunctionType: LLVMTypeRef = LLVMFunctionType(
			/*ReturnType =*/ int32Type,
			/*ParamTypes =*/ null,
			/*ParamCount =*/ 0u,
			/*IsVarArg =*/ FALSE
		)!!
		val mainFunction: LLVMValueRef = LLVMAddFunction(this, "main", mainFunctionType)!!

		val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, mainFunction, "entry")!!
		LLVMPositionBuilderAtEnd(builder, entry)

		fun makeChar(code: Int): LLVMValueRef = LLVMConstInt(int8Type, code.convert(), FALSE)!!
		LLVMBuildAlloca(builder, structType, "i")
		LLVMBuildRet(builder, LLVMConstInt(int32Type, 0u, FALSE))
	}
}

fun MemScope.another() = CodeGen.withModule("testTwo") { context: LLVMContextRef ->
	LLVMCreateBuilderInContext(context)!!.use { builder: LLVMBuilderRef ->
		val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!

		val functionArgsType: CArrayPointer<CPointerVarOf<LLVMTypeRef>> = allocArrayOf(
			int32Type
		)
		val functionType: LLVMTypeRef = LLVMFunctionType(
			/*returnType =*/ int32Type,
			/*paramTypes =*/ functionArgsType,
			/*paramCount =*/ 1u,
			/*isVarArg = */ FALSE
		)!!
		val function: LLVMValueRef = LLVMAddFunction(this, "test", functionType)!!

		val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, function, "entry")!!
		LLVMPositionBuilderAtEnd(builder, entry)

		val value: LLVMValueRef = LLVMBuildAdd(
			builder,
			LLVMGetParam(function, 0u)!!,
			LLVMConstInt(int32Type, 1u, FALSE),
			"i"
		)!!
		LLVMBuildRet(builder, value)
	}
}

fun MemScope.hello() = CodeGen.withModule("bunny") { context: LLVMContextRef ->
	LLVMCreateBuilderInContext(context)!!.use { builder: LLVMBuilderRef ->
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
		val putsFunction: LLVMValueRef = LLVMAddFunction(this, "puts", putsFunctionType)!!
		// end

		// Main function
		val mainFunctionType: LLVMTypeRef = LLVMFunctionType(
			/*ReturnType =*/ int32Type,
			/*ParamTypes =*/ null,
			/*ParamCount =*/ 0u,
			/*IsVarArg =*/ FALSE
		)!!
		val mainFunction: LLVMValueRef = LLVMAddFunction(this, "main", mainFunctionType)!!

		val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, mainFunction, "entry")!!
		LLVMPositionBuilderAtEnd(builder, entry)

		val putsFunctionArgs: CArrayPointer<CPointerVarOf<LLVMValueRef>> = allocArrayOf(
			LLVMBuildPointerCast(
				/*arg0 =*/ builder,
				/*Val =*/ LLVMBuildGlobalString(builder, "Hello, world!", "hello"),
				/*DestTy =*/ int8TypePtr,
				/*Name =*/ "0"
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
	}
}