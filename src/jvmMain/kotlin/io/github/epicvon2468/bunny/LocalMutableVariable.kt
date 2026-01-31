package io.github.epicvon2468.bunny

data class LocalMutableVariable(
	override val name: String,
	override val typeInfo: TypeInfo,
	override val addressVariable: LLVMValueRef
) : MutableVariable