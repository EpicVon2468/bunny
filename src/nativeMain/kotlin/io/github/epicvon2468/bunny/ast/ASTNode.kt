package io.github.epicvon2468.bunny.ast

sealed interface ASTNode {

	data class Function(
		val name: String,
		val returnType: String, // LLVMGetTypeByName2
		val argTypes: List<String>? = null
	)
}