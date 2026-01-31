package io.github.epicvon2468.bunny

interface Variable {

	val name: String
	val typeInfo: TypeInfo
	val value: LLVMValueRef

	fun loadValue(builder: LLVMBuilderRef): LLVMValueRef = value
}