@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.codegen

import io.github.epicvon2468.bunny.codegen.standard.generateStandardIO

import kotlinx.cinterop.*

import llvm.LLVMAddFunction
import llvm.LLVMAppendBasicBlockInContext
import llvm.LLVMBasicBlockRef
import llvm.LLVMBuildAdd
import llvm.LLVMBuildAlloca
import llvm.LLVMBuildCall2
import llvm.LLVMBuildGlobalString
import llvm.LLVMBuildPointerCast
import llvm.LLVMBuildRet
import llvm.LLVMBuildStore
import llvm.LLVMBuildStructGEP2
import llvm.LLVMBuilderRef
import llvm.LLVMConstInt
import llvm.LLVMContextRef
import llvm.LLVMCreateBuilderInContext
import llvm.LLVMFunctionType
import llvm.LLVMGetParam
import llvm.LLVMInt32TypeInContext
import llvm.LLVMInt64TypeInContext
import llvm.LLVMInt8TypeInContext
import llvm.LLVMModuleRef
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

// Hold please:
//		val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, printIntFunction, "entry")!!
//		LLVMPositionBuilderAtEnd(builder, entry)
//
//		val ptr: LLVMValueRef = LLVMBuildAlloca(builder, int32Type, "a.addr")!!
//		LLVMBuildStore(builder, LLVMGetParam(printIntFunction, 0u), ptr)
//		val value: LLVMValueRef = LLVMBuildLoad2(builder, int32Type, ptr, "0")!!
//		LLVMBuildCall2(
//			builder,
//			printfFunctionType,
//			printfFunction,
//			allocArrayOf(
//				LLVMBuildPointerCast(
//					builder,
//					LLVMBuildGlobalString(builder, "%d\n", "printIntStr"),
//					int8TypePtr,
//					""
//				),
//				value
//			),
//			2u,
//			"call"
//		)
//
//		LLVMBuildRetVoid(builder)

fun MemScope.standardIO() = CodeGen.withModule("standard__IO") { context: LLVMContextRef ->
	LLVMCreateBuilderInContext(context)!!.use { builder: LLVMBuilderRef ->
		this@standardIO.generateStandardIO(
			context = context,
			module = this,
			builder = builder,
			headersOnly = false
		)
	}
}

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

		generateMainFunction(int32Type, context, builder)

		val struct: LLVMValueRef = LLVMBuildAlloca(builder, structType, "instance")!!
		val structField1Ptr: LLVMValueRef = LLVMBuildStructGEP2(builder, structType, struct, 0u, "instance_0")!!
		LLVMBuildStore(builder, LLVMConstInt(int8Type, 5u, FALSE), structField1Ptr)
		builder.buildIntReturn0(int32Type)
	}
}

fun MemScope.another() = CodeGen.withModule("testTwo") { context: LLVMContextRef ->
	LLVMCreateBuilderInContext(context)!!.use { builder: LLVMBuilderRef ->
		val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!

		val functionType: LLVMTypeRef = LLVMFunctionType(
			/*returnType =*/ int32Type,
			/*paramTypes =*/ allocArrayOf(int32Type),
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
		val (
			functionTypes: Map<String, LLVMTypeRef>,
			functions: Map<String, LLVMValueRef>
		) = this@hello.generateStandardIO(
			context = context,
			module = this,
			builder = builder
		)

		val int8Type: LLVMTypeRef = LLVMInt8TypeInContext(context)!!
		val int8TypePtr: LLVMTypeRef = LLVMPointerType(int8Type, 0u)!! // String is 'char*'
		val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!
		val int64Type: LLVMTypeRef = LLVMInt64TypeInContext(context)!!

		// Puts function
		val putsFunctionType: LLVMTypeRef = LLVMFunctionType(
			/*ReturnType =*/ int32Type,
			/*ParamTypes =*/ allocArrayOf(int8TypePtr),
			/*ParamCount =*/ 1u,
			/*IsVarArg =*/ FALSE
		)!!
		val putsFunction: LLVMValueRef = LLVMAddFunction(this, "puts", putsFunctionType)!!
		// end

		generateMainFunction(int32Type, context, builder)

		LLVMBuildCall2(
			/*arg0 =*/ builder,
			/*arg1 =*/ putsFunctionType,
			/*Fn =*/ putsFunction,
			/*Args =*/ allocArrayOf(
				LLVMBuildPointerCast(
					/*arg0 =*/ builder,
					/*Val =*/ LLVMBuildGlobalString(builder, "Hello, world!", "hello"),
					/*DestTy =*/ int8TypePtr,
					/*Name =*/ ""
				)
			),
			/*NumArgs =*/ 1u,
			/*Name =*/ "i"
		)
		LLVMBuildCall2(
			builder,
			functionTypes["printI32"]!!,
			functions["printI32"]!!,
			allocArrayOf(LLVMConstInt(int32Type, 42u, FALSE)),
			1u,
			""
		)
		LLVMBuildCall2(
			builder,
			functionTypes["printI64"]!!,
			functions["printI64"]!!,
			allocArrayOf(LLVMConstInt(int64Type, 42u, FALSE)),
			1u,
			""
		)

		builder.buildIntReturn0(int32Type)
		// end
	}
}

private fun LLVMModuleRef.generateMainFunction(
	int32Type: LLVMTypeRef,
	context: LLVMContextRef,
	builder: LLVMBuilderRef
) {
	val mainFunctionType: LLVMTypeRef = LLVMFunctionType(
		/*ReturnType =*/ int32Type,
		/*ParamTypes =*/ null,
		/*ParamCount =*/ 0u,
		/*IsVarArg =*/ FALSE
	)!!
	val mainFunction: LLVMValueRef = LLVMAddFunction(this, "main", mainFunctionType)!!

	val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, mainFunction, "entry")!!
	LLVMPositionBuilderAtEnd(builder, entry)
}