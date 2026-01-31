package io.github.epicvon2468.bunny

import org.llvm.Core_h.*
import org.llvm.Target_h.LLVMGetModuleDataLayout
import org.llvm.Target_h.LLVMIntPtrTypeInContext

/**
 * A class to represent the values, types, and other info in a scope.
 *
 * Parsed functions and structs should be added to the type lookup with [childScope], storing the result into a global scope variable.
 *
 * By default, [Scope] only contains the built-in number types, size types, and pointer types.  See [globalScope] for the defaults.
 *
 * @author Mavity The Madity
 */
@ConsistentCopyVisibility
data class Scope private constructor(
	val typeLookup: Map<String, TypeInfo>,
	val functionLookup: Map<String, FunctionInfo> = emptyMap(),
	val variableLookup: Map<String, MutableVariable> = emptyMap(),
	val returnType: TypeInfo? = null
) {

	/**
	 * Creates a new [Scope] with (potentially) updated values.
	 *
	 * @param addedTypes the new types to append to [typeLookup].
	 * @param addedFunctions the new functions to append to [functionLookup].
	 * @param returnType the new [TypeInfo] to represent the "return" type of the [Scope].  Use `null` to clear.
	 * @return a new [Scope] with (potentially) update values.
	 */
	fun childScope(
		addedTypes: Map<String, TypeInfo>? = null,
		addedFunctions: Map<String, FunctionInfo>? = null,
		addedVariables: Map<String, MutableVariable>? = null,
		returnType: TypeInfo? = this.returnType
	): Scope = Scope(
		// TODO: this can overwrite builtin types.
		this.typeLookup.let { lookup: Map<String, TypeInfo> ->
			return@let if (addedTypes.isNullOrEmpty()) lookup
			else lookup.toMutableMap().apply { putAll(addedTypes) }
		},
		this.functionLookup.let { lookup: Map<String, FunctionInfo> ->
			return@let if (addedFunctions.isNullOrEmpty()) lookup
			else lookup.toMutableMap().apply { putAll(addedFunctions) }
		},
		this.variableLookup.let { lookup: Map<String, MutableVariable> ->
			return@let if (addedVariables.isNullOrEmpty()) lookup
			else lookup.toMutableMap().apply { putAll(addedVariables) }
		},
		returnType
	)

	/**
	 * Merges the type and function lookups of [other] with this [Scope]'s lookups.
	 *
	 * @param other the [Scope] to append lookup entries from.
	 * @return a new [Scope] with combined lookups between this and [other].
	 */
	fun mergeLookups(other: Scope): Scope = childScope(
		other.typeLookup,
		other.functionLookup
	)

	/**
	 * Searches for a [type][TypeInfo] in the [type lookup][typeLookup], throwing [IllegalStateException] if the type cannot be found.
	 *
	 * @param name the name of the [type][TypeInfo] to search for.
	 * @return a [type][TypeInfo] with the given [name].
	 * @throws IllegalStateException if a [type][TypeInfo] of the given [name] cannot be found.
	 */
	fun lookupType(name: String): TypeInfo = lookupTypeOrNull(name) ?: error("No such key '$name' in type lookup!")
	fun lookupTypeOrNull(name: String): TypeInfo? = typeLookup[name]

	/**
	 * Searches for a [function][FunctionInfo] in the [function lookup][functionLookup], throwing [IllegalStateException] if the function cannot be found.
	 *
	 * @param name the name of the [function][FunctionInfo] to search for.
	 * @return a [function][FunctionInfo] with the given [name].
	 * @throws IllegalStateException if a [function][FunctionInfo] of the given [name] cannot be found.
	 */
	fun lookupFunct(name: String): FunctionInfo = lookupFunctOrNull(name) ?: error("No such key '$name' in function lookup!")
	fun lookupFunctOrNull(name: String): FunctionInfo? = functionLookup[name]

	fun lookupVariable(name: String): MutableVariable = lookupVariableOrNull(name) ?: error("No such key '$name'(.addr) in variable lookup!")
	fun lookupVariableOrNull(name: String): MutableVariable? = variableLookup["$name.addr"] ?: variableLookup[name]

	companion object {

		/**
		 * Creates a new defaulted 'global' [Scope], using the [context][LLVMContextRef] and [module][LLVMModuleRef] provided.
		 *
		 * @return a new [Scope].
		 */
		// ONLY FOR TOP-LEVEL/ROOT ENV CREATION!!!
		@JvmStatic
		fun globalScope(context: LLVMContextRef, module: LLVMModuleRef) = Scope(
			typeLookup = mutableMapOf<String, TypeInfo>().apply {
				fun <K, V> MutableMap<K, V>.put(vararg keys: K, value: V) {
					for (key: K in keys) this[key] = value
				}
				fun MutableMap<String, TypeInfo>.put(value: TypeInfo) = put(*value.names.toTypedArray(), value = value)

				// TODO: Type system needs a rework to handle signed vs unsigned...
				put(TypeInfo(LLVMIntPtrTypeInContext(context, LLVMGetModuleDataLayout(module)), "size", "usize"))
				put(TypeInfo(LLVMVoidTypeInContext(context), "", "void"))
				put(TypeInfo(LLVMInt1TypeInContext(context), "bool"))
				put(TypeInfo(LLVMIntTypeInContext(context, 2), "i2", "u2"))
				put(TypeInfo(LLVMIntTypeInContext(context, 4), "i4", "u4"))
				put(TypeInfo(LLVMInt8TypeInContext(context), "i8", "u8"))
				put(TypeInfo(LLVMInt16TypeInContext(context), "i16", "u16"))
				put(TypeInfo(LLVMInt32TypeInContext(context), "i32", "u32"))
				put(TypeInfo(LLVMInt64TypeInContext(context), "i64", "u64"))
				put(TypeInfo(LLVMInt128TypeInContext(context), "i128", "u128"))
				put(TypeInfo(LLVMIntTypeInContext(context, 256), "i256", "u256"))
				put(TypeInfo(LLVMIntTypeInContext(context, 512), "i512", "u512"))
				put(TypeInfo(LLVMIntTypeInContext(context, 1024), "i1024", "u1024"))
				put(TypeInfo(LLVMFloatTypeInContext(context), "f32"))
				put(TypeInfo(LLVMDoubleTypeInContext(context), "f64"))
				put(TypeInfo(LLVMPointerTypeInContext(context, 0), "ptr"))
			}
		)
	}
}