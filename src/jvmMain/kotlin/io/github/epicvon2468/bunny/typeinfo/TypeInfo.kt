package io.github.epicvon2468.bunny.typeinfo

import io.github.epicvon2468.bunny.LLVMTypeRef

interface TypeInfo {

	// Underlying LLVM type
	val llvmType: LLVMTypeRef

	val names: List<String>

	/**
	 * The primary name of this type.
	 */
	val name: String get() = this.names.first()
}