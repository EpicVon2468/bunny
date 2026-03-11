package io.github.epicvon2468.bunny.v3_5

@DslMarker
annotation class IRBuilder

@IRBuilder
interface FunctBuilder {

	var name: String

	var parameters: MutableList<Identifier>

	var returnType: Type

	var body: MutableList<Instruction>

	@IRBuilder
	interface BodyBuilder {

		var elements: MutableList<Instruction>
	}

	fun body(block: BodyBuilder.() -> Unit) {
		val impl: BodyBuilder = object : BodyBuilder {

			override var elements: MutableList<Instruction> = mutableListOf()
		}
		impl.block()
		body = impl.elements
	}
}

fun funct(block: FunctBuilder.() -> Unit): IR.Funct {
	val impl: FunctBuilder = object : FunctBuilder {

		override var name: String = "_anonymous"

		override var parameters: MutableList<Identifier> = mutableListOf()

		override var returnType: Type = "void"

		override var body: MutableList<Instruction> = mutableListOf()
	}
	impl.block()
	return IR.Funct(
		name = impl.name,
		parameters = impl.parameters,
		returnType = impl.returnType,
		body = impl.body
	)
}