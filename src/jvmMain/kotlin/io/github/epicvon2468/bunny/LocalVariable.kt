package io.github.epicvon2468.bunny

data class LocalVariable(
	override val name: String,
	override val typeInfo: TypeInfo,
	override val addressVariable: LLVMValueRef
) : MutableVariable