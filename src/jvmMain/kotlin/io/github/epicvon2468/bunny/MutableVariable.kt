package io.github.epicvon2468.bunny

data class MutableVariable(
	// name of the address variable created with alloca
	val name: String,
	val type: Type,
	// the representation of the variable created with alloca
	val addressVariable: LLVMValueRef
)