package io.github.epicvon2468.bunny

import org.llvm.Core_h.*

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SequenceLayout

fun test() {
	println("Java library path: ${System.getProperty("java.library.path")}")
	System.getProperty("java.library.path").let {
		System.setProperty("java.library.path", "$it:${System.getenv("LIB_LLVM_LOCATION")}/lib")
	}
	println("Java library path: ${System.getProperty("java.library.path")}")
	Arena.ofShared().use { arena: Arena ->
		val context: MemorySegment = LLVMContextCreate()!!
		val module: MemorySegment = LLVMModuleCreateWithNameInContext(arena.allocateFrom("test"), context)!!
		val builder: MemorySegment = LLVMCreateBuilderInContext(context)!!

		val ptrType: MemorySegment = LLVMPointerTypeInContext(context, 0)!!
		val int32Type: MemorySegment = LLVMInt32TypeInContext(context)!!

		val array: MemorySegment = arena.allocateArray(1, LLVMTypeRef, ptrType)
		LLVMAddFunction(
			module,
			arena.allocateFrom("printf"),
			LLVMFunctionType(
				int32Type,
				array,
				1,
				0
			)!!
		)!!

		LLVMDisposeBuilder(builder)
		LLVMPrintModuleToString(module).let {
			println("Gotcha")
			println("'''\n${it.getString(0)}'''")
		}
		LLVMDisposeModule(module)
		LLVMContextDispose(context)
	}
}

fun Arena.allocateArray(size: Long, elementLayout: MemoryLayout, vararg values: Any): MemorySegment {
	val layout: SequenceLayout = MemoryLayout.sequenceLayout(size, elementLayout)
	val array: MemorySegment = allocate(layout)
	var current = 0
	while (current < layout.elementCount()) {
		elementLayout.arrayElementVarHandle().set(array, 0L, current.toLong(), values[current])
		current++
	}
	return array
}