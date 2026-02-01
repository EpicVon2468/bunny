package io.github.epicvon2468.bunny

import io.github.epicvon2468.bunny.typeinfo.IntTypeInfo
import io.github.epicvon2468.bunny.typeinfo.SimpleTypeInfo
import io.github.epicvon2468.bunny.typeinfo.TypeInfo

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
	val variableLookup: Map<String, Variable> = emptyMap(),
	// May represent return type of function or expression
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
		addedVariables: Map<String, Variable>? = null,
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
		this.variableLookup.let { lookup: Map<String, Variable> ->
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

	fun lookupMutableVariable(name: String): MutableVariable = lookupMutableVariableOrNull(name) as MutableVariable
	fun lookupMutableVariableOrNull(name: String): MutableVariable? = lookupVariableOrNull(name) as? MutableVariable

	fun lookupVariable(name: String): Variable = lookupVariableOrNull(name) ?: error("No such key '$name'(.addr) in variable lookup!")
	fun lookupVariableOrNull(name: String): Variable? = variableLookup["$name.addr"] ?: variableLookup[name]

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

				put(IntTypeInfo.Unsigned(
					LLVMIntPtrTypeInContext(context, LLVMGetModuleDataLayout(module)),
					"size", "usize"
				))
				put(SimpleTypeInfo(LLVMVoidTypeInContext(context), "", "void"))
				put(IntTypeInfo.Unsigned(LLVMInt1TypeInContext(context), "bool"))

				put(IntTypeInfo.Signed(context, 2, "i2"))
				put(IntTypeInfo.Unsigned(context, 2, "u2"))

				put(IntTypeInfo.Signed(context, 4, "i4"))
				put(IntTypeInfo.Unsigned(context, 4, "u4"))

				val int8: LLVMTypeRef = LLVMInt8TypeInContext(context)
				put(IntTypeInfo.Signed(int8, "i8"))
				put(IntTypeInfo.Unsigned(int8, "u8"))

				val int16: LLVMTypeRef = LLVMInt16TypeInContext(context)
				put(IntTypeInfo.Signed(int16, "i16"))
				put(IntTypeInfo.Unsigned(int16, "u16"))

				val int32: LLVMTypeRef = LLVMInt32TypeInContext(context)
				put(IntTypeInfo.Signed(int32, "i32"))
				put(IntTypeInfo.Unsigned(int32, "u32"))

				val int64: LLVMTypeRef = LLVMInt64TypeInContext(context)
				put(IntTypeInfo.Signed(int64, "i64"))
				put(IntTypeInfo.Unsigned(int64, "u64"))

				val int128: LLVMTypeRef = LLVMInt128TypeInContext(context)
				put(IntTypeInfo.Signed(int128, "i128"))
				put(IntTypeInfo.Unsigned(int128, "u128"))

				put(IntTypeInfo.Signed(context, 256, "i256"))
				put(IntTypeInfo.Unsigned(context, 256, "u256"))

				put(IntTypeInfo.Signed(context, 512, "i512"))
				put(IntTypeInfo.Unsigned(context, 512, "u512"))

				put(IntTypeInfo.Signed(context, 1024, "i1024"))
				put(IntTypeInfo.Unsigned(context, 1024, "u1024"))

				put(SimpleTypeInfo(LLVMFloatTypeInContext(context), "f32"))
				put(SimpleTypeInfo(LLVMDoubleTypeInContext(context), "f64"))
				put(SimpleTypeInfo(LLVMPointerTypeInContext(context, 0), "ptr"))
			}
		)
	}
}