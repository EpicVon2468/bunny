package io.github.epicvon2468.bunny

data class Type(
	val llvmType: LLVMTypeRef,
	val names: List<String>
) {

	init {
		require(names.isNotEmpty()) { "No name(s) were provided for a Type!" }
	}

	/**
	 * The primary name of this type.
	 */
	val name: String = names.first()

	constructor(llvmType: LLVMTypeRef, vararg names: String) : this(llvmType, names.toList())
}