package io.github.epicvon2468.bunny

data class NamedParameter(
	override val name: String,
	override val typeInfo: TypeInfo,
	override val addressVariable: LLVMValueRef,
	val index: Int
) : MutableVariable