package io.github.epicvon2468.bunny.v3_5

@DslMarker
annotation class IRBuilder

@IRBuilder
interface FunctBuilder {

	var name: String

	val parameters: MutableList<Identifier>

	var returnType: Type

	val body: MutableList<Instruction>

	@IRBuilder
	interface BodyBuilder {

		val elements: MutableList<Instruction>
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

		override var name: String = "anonymous"

		override val parameters: MutableList<Identifier> = mutableListOf()

		override var returnType: Type = "void"

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