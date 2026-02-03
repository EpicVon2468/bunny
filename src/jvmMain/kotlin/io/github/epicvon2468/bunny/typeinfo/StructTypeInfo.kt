package io.github.epicvon2468.bunny.typeinfo

import io.github.epicvon2468.bunny.LLVMTypeRef

data class StructTypeInfo(
	override val llvmType: LLVMTypeRef,
	override val name: String,
	val entries: List<TypeInfo>
) : TypeInfo {

	override val names: List<String> = listOf(name)
}