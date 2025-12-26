package io.github.epicvon2468.bunny.ast

import io.github.epicvon2468.bunny.util.option.Option

sealed interface ASTNode {

	data class Function(
		val name: String,
		val returnType: String, // LLVMGetTypeByName2
		val argTypes: Option<List<String>>
	)
}