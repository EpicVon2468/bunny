package io.github.epicvon2468.bunny

@ConsistentCopyVisibility
data class NamedParameter private constructor(
	override val name: String,
	override val typeInfo: TypeInfo,
	val index: Int
) : MutableVariable {

	private lateinit var _addressVariable: () -> LLVMValueRef

	fun runInit() {
		this.addressVariable = _addressVariable()
	}

	constructor(
		name: String,
		typeInfo: TypeInfo,
		addressSupplier: () -> LLVMValueRef,
		index: Int
	) : this(name, typeInfo, index) {
		_addressVariable = addressSupplier
	}

	override lateinit var addressVariable: LLVMValueRef private set
}