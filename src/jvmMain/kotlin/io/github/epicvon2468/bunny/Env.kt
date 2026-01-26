package io.github.epicvon2468.bunny

import org.llvm.Core_h.*

import java.lang.foreign.MemorySegment

@ConsistentCopyVisibility
data class Env private constructor(
	val typeLookup: Map<String, Type>,
	// TODO: variable map for local & global variables :o
	val returnType: LLVMTypeRef = MemorySegment.NULL,
	val parent: Env? = null
) {

	// TODO: copy parameters of a function (via LLVM) into new copies w/ alloca, then store in a map here (see also: MutableVariable, Type)

	fun newEnv(
		addedTypes: Map<String, Type>? = null,
		returnType: LLVMTypeRef = this.returnType,
		parent: Env? = this.parent
	): Env = Env(
		this.typeLookup.let { lookup: Map<String, Type> ->
			return@let if (addedTypes == null) lookup
			else lookup.toMutableMap().apply { putAll(addedTypes) }
		},
		returnType,
		parent
	)

	fun lookupType(name: String): Type = lookupTypeOrNull(name) ?: error("No such key '$name' in lookup!")
	fun lookupTypeOrNull(name: String): Type? = typeLookup[name] ?: parent?.lookupTypeOrNull(name)

	companion object {

		// ONLY FOR TOP-LEVEL/ROOT ENV CREATION!!!
		@JvmStatic
		fun newEnv(context: LLVMContextRef) = Env(
			typeLookup = mutableMapOf<String, Type>().apply {
				fun <K, V> MutableMap<K, V>.put(vararg keys: K, value: V) {
					for (key in keys) this[key] = value
				}
				fun MutableMap<String, Type>.put(value: Type) = put(*value.names.toTypedArray(), value = value)

				put(Type(
					LLVMVoidTypeInContext(context),
					"", "void"
				))
				put(Type(
					LLVMInt1TypeInContext(context),
					"bool", "boolean"
				))
				put(Type(
					LLVMIntTypeInContext(context, 2),
					"i2", "u2"
				))
				put(Type(
					LLVMIntTypeInContext(context, 4),
					"i4", "u4"
				))
				put(Type(
					LLVMInt8TypeInContext(context),
					"i8", "u8"
				))
				put(Type(
					LLVMInt16TypeInContext(context),
					"i16", "u16"
				))
				put(Type(
					LLVMInt32TypeInContext(context),
					"i32", "u32"
				))
				put(Type(
					LLVMInt64TypeInContext(context),
					"i64", "u64"
				))
				put(Type(
					LLVMInt128TypeInContext(context),
					"i128", "u128"
				))
				put(Type(
					LLVMIntTypeInContext(context, 256),
					"i256", "u256"
				))
				put(Type(
					LLVMIntTypeInContext(context, 512),
					"i512", "u512"
				))
				put(Type(
					LLVMFloatTypeInContext(context),
					"f32", "float"
				))
				put(Type(
					LLVMDoubleTypeInContext(context),
					"f64", "double"
				))
				put(Type(
					LLVMPointerTypeInContext(context, /*AddressSpace =*/ 0),
					"ptr", "pointer"
				))
			}
		)
	}
}