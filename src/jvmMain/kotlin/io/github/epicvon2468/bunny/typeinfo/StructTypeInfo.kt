package io.github.epicvon2468.bunny.typeinfo

import io.github.epicvon2468.bunny.LLVMTypeRef

data class StructTypeInfo(
	override val llvmType: LLVMTypeRef,
	override val name: String,
	val entries: List<TypeInfo>,
	val nameAssociation: Map<String, Int>
) : TypeInfo {

	operator fun get(index: Int): TypeInfo = entries[index]
	fun getOrNull(index: Int): TypeInfo? = entries.getOrNull(index)

	operator fun get(name: String): TypeInfo = entries[indexOf(name)]
	fun getOrNull(name: String): TypeInfo? = entries.getOrNull(indexOf(name))

	fun indexOf(index: String): Int = nameAssociation[index] ?: -1

	override val names: List<String> = listOf(name)
}