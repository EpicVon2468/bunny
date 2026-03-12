package io.github.epicvon2468.bunny.v3_5.builder

import io.github.epicvon2468.bunny.v3_5.Identifier
import io.github.epicvon2468.bunny.v3_5.Instruction
import io.github.epicvon2468.bunny.v3_5.Type
import io.github.epicvon2468.bunny.v3_5.toIdentifier

@Builder
interface DefBuilder {

	/**
	 * The name of this element.
	 *
	 * Note: Setting this property does not require use of [toIdentifier], as the implementation validates mutations using [toIdentifier] already.
	 */
	var name: Identifier

	/**
	 * The type of this element.
	 *
	 * Note: Setting this property does not require use of [toIdentifier], as the implementation validates mutations using [toIdentifier] already.
	 *
	 * @throws IllegalStateException if the type is unset.  This behaviour is specific to [DefBuilder.type], as variables cannot simply default to `void`.
	 */
	var type: Type
}

fun def(block: DefBuilder.() -> Unit): Instruction.Def {
	val impl: DefBuilder = object : DefBuilder {

		override var name: Identifier = "anonymous"
			set(value) {
				field = value.toIdentifier()
			}

		private var _type: Type? = null
		override var type: Type
			get() = _type ?: error("DefBuilder.type was not set!")
			set(value) {
				_type = value.toIdentifier()
			}
	}
	impl.block()
	return Instruction.Def(
		name = impl.name,
		type = impl.type
	)
}