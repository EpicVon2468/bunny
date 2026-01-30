package io.github.epicvon2468.bunny

import org.llvm.Core_h.*
import org.llvm.Target_h.LLVMGetModuleDataLayout
import org.llvm.Target_h.LLVMIntPtrTypeInContext

// TODO: Rename to "Scope"
@ConsistentCopyVisibility
data class Scope private constructor(
	val typeLookup: Map<String, TypeInfo>,
	// TODO: variable map for local & global variables :o
	val functionLookup: Map<String, FunctionInfo> = emptyMap(),
	val returnType: TypeInfo? = null,
	val parent: Scope? = null
) {

	// TODO: copy parameters of a function (via LLVM) into new copies w/ alloca, then store in a map here (see also: MutableVariable, TypeInfo)

	fun childScope(
		addedTypes: Map<String, TypeInfo>? = null,
		addedFunctions: Map<String, FunctionInfo>? = null,
		returnType: TypeInfo? = this.returnType,
		parent: Scope? = this
	): Scope = Scope(
		this.typeLookup.let { lookup: Map<String, TypeInfo> ->
			return@let if (addedTypes.isNullOrEmpty()) lookup
			else lookup.toMutableMap().apply { putAll(addedTypes) }
		},
		this.functionLookup.let { lookup: Map<String, FunctionInfo> ->
			return@let if (addedFunctions.isNullOrEmpty()) lookup
			else lookup.toMutableMap().apply { putAll(addedFunctions) }
		},
		returnType,
		parent
	)

	fun mergeLookups(other: Scope): Scope = childScope(
		other.typeLookup,
		other.functionLookup
	)

	fun lookupType(name: String): TypeInfo = lookupTypeOrNull(name) ?: error("No such key '$name' in type lookup!")
	fun lookupTypeOrNull(name: String): TypeInfo? = typeLookup[name] ?: parent?.lookupTypeOrNull(name)

	fun lookupFunct(name: String): FunctionInfo = lookupFunctOrNull(name) ?: error("No such key '$name' in function lookup!")
	fun lookupFunctOrNull(name: String): FunctionInfo? = functionLookup[name] ?: parent?.lookupFunctOrNull(name)

	companion object {

		// ONLY FOR TOP-LEVEL/ROOT ENV CREATION!!!
		@JvmStatic
		fun globalScope(context: LLVMContextRef, module: LLVMModuleRef) = Scope(
			typeLookup = mutableMapOf<String, TypeInfo>().apply {
				fun <K, V> MutableMap<K, V>.put(vararg keys: K, value: V) {
					for (key: K in keys) this[key] = value
				}
				fun MutableMap<String, TypeInfo>.put(value: TypeInfo) = put(*value.names.toTypedArray(), value = value)

				put(TypeInfo(
					LLVMIntPtrTypeInContext(context, LLVMGetModuleDataLayout(module)),
					"isize", "usize",
					"size_t",
					"intptr_t", "uintptr_t"
				))
				put(TypeInfo(
					LLVMVoidTypeInContext(context),
					"", "void"
				))
				put(TypeInfo(
					LLVMInt1TypeInContext(context),
					"bool", "boolean",
					"i1", "u8"
				))
				put(TypeInfo(
					LLVMIntTypeInContext(context, 2),
					"i2", "u2"
				))
				put(TypeInfo(
					LLVMIntTypeInContext(context, 4),
					"i4", "u4"
				))
				put(TypeInfo(
					LLVMInt8TypeInContext(context),
					"i8", "u8"
				))
				put(TypeInfo(
					LLVMInt16TypeInContext(context),
					"i16", "u16"
				))
				put(TypeInfo(
					LLVMInt32TypeInContext(context),
					"i32", "u32"
				))
				put(TypeInfo(
					LLVMInt64TypeInContext(context),
					"i64", "u64"
				))
				put(TypeInfo(
					LLVMInt128TypeInContext(context),
					"i128", "u128"
				))
				put(TypeInfo(
					LLVMIntTypeInContext(context, 256),
					"i256", "u256"
				))
				put(TypeInfo(
					LLVMIntTypeInContext(context, 512),
					"i512", "u512"
				))
				put(TypeInfo(
					LLVMIntTypeInContext(context, 1024),
					"i1024", "u1024"
				))
				put(TypeInfo(
					LLVMFloatTypeInContext(context),
					"f32", "float"
				))
				put(TypeInfo(
					LLVMDoubleTypeInContext(context),
					"f64", "double"
				))
				put(TypeInfo(
					LLVMPointerTypeInContext(context, /*AddressSpace =*/ 0),
					"ptr", "pointer"
				))
			}
		)
	}
}