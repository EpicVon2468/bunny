package io.github.epicvon2468.bunny

import io.github.epicvon2468.bunny.typeinfo.TypeInfo

data class LocalMutableVariable(
	override val name: String,
	override val typeInfo: TypeInfo,
	override val addressVariable: LLVMValueRef
) : MutableVariable