package io.github.epicvon2468.bunny

data class LocalVariable(
	override val name: String,
	override val typeInfo: TypeInfo,
	val value: LLVMValueRef
) : Variable {

	override fun loadValue(builder: LLVMBuilderRef): LLVMValueRef = value
}