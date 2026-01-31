package io.github.epicvon2468.bunny

interface Variable {

	val name: String
	val typeInfo: TypeInfo

	fun loadValue(builder: LLVMBuilderRef): LLVMValueRef
}