package io.github.epicvon2468.bunny.v3_5.builder

import io.github.epicvon2468.bunny.v3_5.IR
import io.github.epicvon2468.bunny.v3_5.Identifier
import io.github.epicvon2468.bunny.v3_5.Instruction
import io.github.epicvon2468.bunny.v3_5.Type
import io.github.epicvon2468.bunny.v3_5.toIdentifier
import io.github.epicvon2468.bunny.v3_5.builder.def as _def

@Builder
interface FunctBuilder {

	/**
	 * The name of this element.
	 *
	 * Note: Setting this property does not require use of [toIdentifier], as the implementation validates mutations using [toIdentifier] already.
	 */
	var name: Identifier

	var parameters: MutableList<Identifier>

	fun parameters(vararg params: String, noValidate: Boolean = false, replace: Boolean = false) {
		val params: List<String> = if (noValidate) params.toList() else params.map(String::toIdentifier)
		if (replace) parameters = params.toMutableList()
		else parameters += params
	}

	/**
	 * The return type of this element.
	 *
	 * Note: Setting this property does not require use of [toIdentifier], as the implementation validates mutations using [toIdentifier] already.
	 */
	var returnType: Type

	val body: MutableList<IR.Label>

	@Builder
	interface BodyBuilder {

		/**
		 * Mutable access to the parent [FunctBuilder]'s [FunctBuilder.body].
		 */
		val elements: MutableList<IR.Label>

//		fun def(block: DefBuilder.() -> Unit) {
//			elements += _def(block)
//		}
	}

	fun body(block: BodyBuilder.() -> Unit) {
		val impl: BodyBuilder = object : BodyBuilder {

			override val elements: MutableList<IR.Label>
				get() = this@FunctBuilder.body
		}
		impl.block()
	}
}

fun funct(block: FunctBuilder.() -> Unit): IR.Funct {
	val impl: FunctBuilder = object : FunctBuilder {

		override var name: Identifier = "anonymous"
			set(value) {
				field = value.toIdentifier()
			}

		override var parameters: MutableList<Identifier> = mutableListOf()
			set(value) {
				field.clear()
				field.addAll(value)
			}

		override var returnType: Type = "void"
			set(value) {
				field = value.toIdentifier()
			}

		override val body: MutableList<IR.Label> = mutableListOf()
	}
	impl.block()
	return IR.Funct(
		name = impl.name,
		parameters = impl.parameters,
		returnType = impl.returnType,
		body = impl.body
	)
}