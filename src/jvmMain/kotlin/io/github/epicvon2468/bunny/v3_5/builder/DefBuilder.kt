package io.github.epicvon2468.bunny.v3_5.builder

import io.github.epicvon2468.bunny.v3_5.Identifier
import io.github.epicvon2468.bunny.v3_5.Instruction
import io.github.epicvon2468.bunny.v3_5.Type
import io.github.epicvon2468.bunny.v3_5.toIdentifier

@Builder
interface DefBuilder {

	var name: Identifier

	var type: Type
}

fun def(block: DefBuilder.() -> Unit): Instruction.Def {
	val impl: DefBuilder = object : DefBuilder {

		override var name: Identifier = "anonymous"
			set(value) {
				field = value.toIdentifier()
			}

		// TODO: make this specifically throw if unset?
		override var type: Type = "void"
			set(value) {
				field = value.toIdentifier()
			}
	}
	impl.block()
	return Instruction.Def(
		name = impl.name,
		type = impl.type
	)
}