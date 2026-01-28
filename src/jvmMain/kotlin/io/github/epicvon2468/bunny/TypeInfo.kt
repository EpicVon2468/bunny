package io.github.epicvon2468.bunny

data class TypeInfo(
	val llvmType: LLVMTypeRef,
	val names: List<String>
) {

	init {
		require(this.names.isNotEmpty()) { "No name(s) were provided for TypeInfo@${this.hashCode()}!" }
	}

	/**
	 * The primary name of this type.
	 */
	val name: String = this.names.first()

	constructor(llvmType: LLVMTypeRef, vararg names: String) : this(llvmType, names.toList())
}