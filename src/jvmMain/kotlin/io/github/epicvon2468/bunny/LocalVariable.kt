package io.github.epicvon2468.bunny

import io.github.epicvon2468.bunny.typeinfo.TypeInfo

import org.llvm.Core_h.LLVMSetValueName2

import java.lang.foreign.MemorySegment

data class LocalVariable(
	override val name: String,
	override val typeInfo: TypeInfo,
	override val value: LLVMValueRef
) : Variable {

	constructor(
		name: String,
		typeInfo: TypeInfo,
		value: LLVMValueRef,
		cname: MemorySegment
	) : this(name, typeInfo, value) {
		LLVMSetValueName2(value, cname, name.length.toLong())
	}
}