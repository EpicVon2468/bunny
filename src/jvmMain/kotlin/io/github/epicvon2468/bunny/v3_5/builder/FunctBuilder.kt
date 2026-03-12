package io.github.epicvon2468.bunny.v3_5.builder

import io.github.epicvon2468.bunny.v3_5.IR
import io.github.epicvon2468.bunny.v3_5.Identifier
import io.github.epicvon2468.bunny.v3_5.Instruction
import io.github.epicvon2468.bunny.v3_5.Type
import io.github.epicvon2468.bunny.v3_5.toIdentifier
import io.github.epicvon2468.bunny.v3_5.builder.def as _def

@Builder
interface FunctBuilder {

	var name: Identifier

	val parameters: MutableList<Identifier>

	fun parameters(vararg params: String, noValidate: Boolean = false, replace: Boolean = false) {
		if (replace) parameters.clear()
		if (noValidate) {
			parameters.addAll(params)
			return
		}
		parameters.addAll(params.map(String::toIdentifier))
	}

	var returnType: Type

	val body: MutableList<Instruction>

	@Builder
	interface BodyBuilder {

		val elements: MutableList<Instruction>

		fun def(block: DefBuilder.() -> Unit) {
			elements += _def(block)
		}
	}

	fun body(block: BodyBuilder.() -> Unit) {
		val impl: BodyBuilder = object : BodyBuilder {

			override val elements: MutableList<Instruction>
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

		override val parameters: MutableList<Identifier> = mutableListOf()

		override var returnType: Type = "void"
			set(value) {
				field = value.toIdentifier()
			}

		override val body: MutableList<Instruction> = mutableListOf()
	}
	impl.block()
	return IR.Funct(
		name = impl.name,
		parameters = impl.parameters,
		returnType = impl.returnType,
		body = impl.body
	)
}