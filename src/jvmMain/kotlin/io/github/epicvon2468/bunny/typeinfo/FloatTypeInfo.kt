package io.github.epicvon2468.bunny.typeinfo

import io.github.epicvon2468.bunny.LLVMTypeRef

data class FloatTypeInfo(
	override val llvmType: LLVMTypeRef,
	override val name: String
) : NumberTypeInfo {

	override val names: List<String> = listOf(this.name)

	init {
		require(this.names.size == 1) { "FloatTypeInfo was passed more than one name! Names: '$names'" }
	}
}