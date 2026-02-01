package io.github.epicvon2468.bunny

import io.github.epicvon2468.bunny.typeinfo.TypeInfo

interface Variable {

	val name: String
	val typeInfo: TypeInfo
	val value: LLVMValueRef

	fun loadValue(builder: LLVMBuilderRef): LLVMValueRef = value
}