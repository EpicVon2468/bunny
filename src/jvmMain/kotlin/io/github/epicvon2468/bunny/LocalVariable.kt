package io.github.epicvon2468.bunny

import io.github.epicvon2468.bunny.typeinfo.TypeInfo

data class LocalVariable(
	override val name: String,
	override val typeInfo: TypeInfo,
	override val value: LLVMValueRef
) : Variable