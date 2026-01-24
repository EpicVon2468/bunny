package io.github.epicvon2468.bunny

import org.llvm.Core_h.*

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SequenceLayout

fun test() {
	Arena.ofShared().use { arena: Arena ->
		val context: MemorySegment = LLVMContextCreate()
		val module: MemorySegment = LLVMModuleCreateWithNameInContext(arena.allocateFrom("test"), context)
		val builder: MemorySegment = LLVMCreateBuilderInContext(context)

		val ptrType: MemorySegment = LLVMPointerTypeInContext(context, 0)
		val int32Type: MemorySegment = LLVMInt32TypeInContext(context)

		LLVMAddFunction(
			module,
			arena.allocateFrom("printf"),
			LLVMFunctionType(
				int32Type,
				arena.allocateArray(LLVMTypeRef, ptrType),
				1,
				0
			)
		)

		val printIntFunction: MemorySegment /*= LLVMValueRef*/ = LLVMAddFunction(
			module,
			arena.allocateFrom("print_i32"),
			LLVMFunctionType(
				LLVMVoidTypeInContext(context),
				arena.allocateArray(LLVMTypeRef, int32Type),
				1,
				0
			)
		)

		val entry: MemorySegment /* = LLVMBasicBlockRef*/ = LLVMAppendBasicBlockInContext(
			context,
			printIntFunction,
			arena.allocateFrom("entry")
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
				LLVMTypeRef,
				LLVMBuildPointerCast(
					builder,
					LLVMBuildGlobalString(builder, arena.allocateFrom("%d\n"), arena.allocateFrom("print_int_str")),
					ptrType,
					arena.allocateFrom("")
				),
				LLVMGetParam(printIntFunction, 0)
			),
			2,
			arena.allocateFrom("call")
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

context(arena: Arena) fun MemorySegment /*= LLVMModuleRef*/.getFunctionAndType(
	name: String
): Pair<MemorySegment /*= LLVMValueRef*/, MemorySegment /*= LLVMTypeRef*/> =
	LLVMGetNamedFunction(this, arena.allocateFrom(name)).let {
		it to LLVMGlobalGetValueType(it)
	}

fun List<Any?>.toNativeArray(arena: Arena, elementLayout: MemoryLayout): MemorySegment = arena.allocateArray(elementLayout, toTypedArray())

fun Arena.allocateArray(elementLayout: MemoryLayout, vararg values: Any?): MemorySegment {
	val layout: SequenceLayout = MemoryLayout.sequenceLayout(values.size.toLong(), elementLayout)
	val array: MemorySegment = allocate(layout)
	var current = 0
	while (current < layout.elementCount()) {
		elementLayout.arrayElementVarHandle().set(array, 0L, current.toLong(), values[current])
		current++
	}
	return array
}