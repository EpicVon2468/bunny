package io.github.epicvon2468.bunny.v3_5

@DslMarker
annotation class IRBuilderDSL

@IRBuilderDSL
interface FunctBuilder {

	var name: String

	var parameters: List<Identifier>

	var returnType: Type

	var body: List<Instruction>
}

fun funct(block: FunctBuilder.() -> Unit): IR.Funct {
	val impl: FunctBuilder = object : FunctBuilder {

		private fun unset(name: String): Nothing = error("Cannot retrieve unset property '$name'!")

		private var _name: String? = null
		override var name: String
			get() = _name ?: unset("name")
			set(value) {
				_name = value
			}

		private var _parameters: List<Identifier>? = null
		override var parameters: List<Identifier>
			get() = _parameters ?: unset("parameters")
			set(value) {
				_parameters = value
			}

		private var _returnType: Type? = null
		override var returnType: Type
			get() = _returnType ?: unset("returnType")
			set(value) {
				_returnType = value
			}

		private var _body: List<Instruction>? = null
		override var body: List<Instruction>
			get() = _body ?: unset("body")
			set(value) {
				value.also { _body = it }
			}
	}
	impl.block()
	return IR.Funct(
		name = impl.name,
		parameters = impl.parameters,
		returnType = impl.returnType,
		body = impl.body
	)
}