package io.github.epicvon2468.bunny.typeinfo

import io.github.epicvon2468.bunny.LLVMTypeRef

data class SimpleTypeInfo(
	override val llvmType: LLVMTypeRef,
	override val names: List<String>
) : TypeInfo {

	init {
		require(this.names.isNotEmpty()) { "No name(s) were provided for TypeInfo '$this'!" }
	}

	override val name: String = this.names.first()

	constructor(llvmType: LLVMTypeRef, vararg names: String) : this(llvmType, names.toList())
}