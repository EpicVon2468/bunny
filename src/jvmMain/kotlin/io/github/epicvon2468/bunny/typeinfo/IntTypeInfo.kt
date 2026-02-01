package io.github.epicvon2468.bunny.typeinfo

import io.github.epicvon2468.bunny.LLVMContextRef
import io.github.epicvon2468.bunny.LLVMTypeRef

import org.llvm.Core_h.LLVMIntTypeInContext

sealed class IntTypeInfo : NumberTypeInfo {

	protected fun validate() = require(this.names.isNotEmpty()) { "No name(s) were provided for TypeInfo '$this'!" }

	data class Signed(
		override val llvmType: LLVMTypeRef,
		override val names: List<String>,
	) : IntTypeInfo() {

		init {
			validate()
		}

		constructor(llvmType: LLVMTypeRef, vararg names: String) : this(llvmType, names.toList())

		// I wanted to add default args '= arrayOf("i$numBits")', and then compilation failed until running `./gradlew --stop' and rebuilding / running without the statement.
		// The compiler doesn't diagnose the problem to be in this statement, instead it says: "Extending sealed classes or interfaces from a different module is prohibited."
		constructor(context: LLVMContextRef, numBits: Int, vararg names: String) : this(LLVMIntTypeInContext(context, numBits), names.toList())
	}

	data class Unsigned(
		override val llvmType: LLVMTypeRef,
		override val names: List<String>,
	) : IntTypeInfo() {

		init {
			validate()
		}

		constructor(llvmType: LLVMTypeRef, vararg names: String) : this(llvmType, names.toList())

		constructor(context: LLVMContextRef, numBits: Int, vararg names: String) : this(LLVMIntTypeInContext(context, numBits), names.toList())
	}
}