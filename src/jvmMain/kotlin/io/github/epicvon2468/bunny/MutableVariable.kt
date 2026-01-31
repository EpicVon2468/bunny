package io.github.epicvon2468.bunny

import org.llvm.Core_h.*

interface MutableVariable {
	// name of the address variable created with alloca
	val name: String
	val typeInfo: TypeInfo
	// the representation of the variable created with alloca
	val addressVariable: LLVMValueRef

	fun loadValue(builder: LLVMBuilderRef): LLVMValueRef = LLVMBuildLoad2(
		builder,
		typeInfo.llvmType,
		addressVariable,
		EMPTY_STRING
	)

	// I... don't actually know what the LLVMValueRef returned here is...
	fun storeValue(builder: LLVMBuilderRef, value: LLVMValueRef): LLVMValueRef = LLVMBuildStore(
		builder,
		value,
		addressVariable
	)
}