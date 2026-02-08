package io.github.epicvon2468.bunny

import org.llvm.Core_h.*

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

fun test() {
	Arena.ofShared().use { arena: Arena ->
		val context: MemorySegment = LLVMContextCreate()
		val module: MemorySegment = LLVMModuleCreateWithNameInContext("test".cstr(arena), context)
		val builder: MemorySegment = LLVMCreateBuilderInContext(context)

		val ptrType: MemorySegment = LLVMPointerTypeInContext(context, 0)
		val int32Type: MemorySegment = LLVMInt32TypeInContext(context)

		LLVMAddFunction(
			module,
			"printf".cstr(arena),
			LLVMFunctionType(
				/*ReturnType =*/ int32Type,
				/*ParamTypes =*/ arena.allocateArray(LLVMTypeRef, ptrType),
				/*ParamCount =*/ 1,
				/*IsVarArg =*/ 1
			)
		)

		val printIntFunction: MemorySegment /*= LLVMValueRef*/ = LLVMAddFunction(
			module,
			"print_i32".cstr(arena),
			LLVMFunctionType(
				/*ReturnType =*/ LLVMVoidTypeInContext(context),
				/*ParamTypes =*/ arena.allocateArray(LLVMTypeRef, int32Type),
				/*ParamCount =*/ 1,
				/*IsVarArg =*/ 0
			)
		)

		val entry: MemorySegment /* = LLVMBasicBlockRef*/ = LLVMAppendBasicBlockInContext(
			context,
			printIntFunction,
			"entry".cstr(arena)
		)
		LLVMPositionBuilderAtEnd(builder, entry)
		val (printfFunction: MemorySegment, printfFunctionType: MemorySegment) = with(arena) {
			module.getFunctionAndType("printf")
		}
		LLVMBuildCall2(
			builder,
			printfFunctionType,
			printfFunction,
			arena.allocateArray(
				LLVMValueRef,
				LLVMBuildPointerCast(
					builder,
					LLVMBuildGlobalString(builder, "%d\n".cstr(arena), "print_int_str".cstr(arena)),
					ptrType,
					EMPTY_STRING
				),
				LLVMGetParam(printIntFunction, 0)
			),
			2,
			"call".cstr(arena)
		)
		LLVMBuildRetVoid(builder)

		LLVMDisposeBuilder(builder)
		LLVMPrintModuleToString(module).let {
			println("Gotcha")
			println("'''\n${it.getString(0)}'''")
		}
		LLVMDisposeModule(module)
		LLVMContextDispose(context)
	}
}