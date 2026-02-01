package io.github.epicvon2468.bunny.typeinfo

import io.github.epicvon2468.bunny.LLVMTypeRef

data class BooleanTypeInfo(override val llvmType: LLVMTypeRef) : PrimitiveTypeInfo {

	override val name: String = "bool"
	override val names: List<String> = listOf(this.name)
}