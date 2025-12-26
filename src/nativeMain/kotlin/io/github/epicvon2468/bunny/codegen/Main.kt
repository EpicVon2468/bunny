@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.codegen

import io.github.epicvon2468.bunny.token.SerialisableToken

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.MemScope
import kotlinx.cinterop.memScoped
import kotlinx.serialization.json.Json

import llvm.LLVMBuilderRef
import llvm.LLVMContextRef
import llvm.LLVMCreateBuilderInContext
import llvm.LLVMFunctionType
import llvm.LLVMGetTypeByName
import llvm.LLVMGetTypeByName2

fun main(args: Array<String>) = memScoped {
	val input: List<SerialisableToken> = Json.decodeFromString(args[0].also(::println))
	this.generateRecurse(input)
}

fun MemScope.generateRecurse(input: List<SerialisableToken>) = CodeGen.withModule("anonymous") { context: LLVMContextRef ->
	LLVMCreateBuilderInContext(context)!!.use { builder: LLVMBuilderRef ->
		LLVMGetTypeByName2(context, "i32")
	}
}