package io.github.epicvon2468.bunny

data class FunctionInfo(
	val name: String,
	val parameters: List<NamedParameter>,
	val returnType: TypeInfo,
	val llvmFunction: LLVMValueRef
)