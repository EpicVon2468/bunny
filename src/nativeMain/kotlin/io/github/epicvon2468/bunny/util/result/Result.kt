@file:OptIn(ExperimentalContracts::class)
package io.github.epicvon2468.bunny.util.result

import io.github.epicvon2468.bunny.util.option.Option
import io.github.epicvon2468.bunny.util.option.Option.Companion.None
import io.github.epicvon2468.bunny.util.option.toSome
import io.github.epicvon2468.bunny.util.result.Result.*

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed interface Result<T : Any, E : Any> {

	value class Ok<T : Any, E : Any>(val value: T) : Result<T, E>

	value class Err<T : Any, E : Any>(val value: E) : Result<T, E>
}

fun <T : Any, E : Any> Result<T, E>.isOk(): Boolean {
	contract {
		returns(true) implies (this@isOk is Ok)
		returns(false) implies (this@isOk is Err)
	}
	return this is Ok
}

fun <T : Any, E : Any> Result<T, E>.isOkAnd(f: (T) -> Boolean): Boolean = isOk() && f(value)

fun <T : Any, E : Any> Result<T, E>.isErr(): Boolean {
	contract {
		returns(true) implies (this@isErr is Err)
		returns(false) implies (this@isErr is Ok)
	}
	return this is Err
}

fun <T : Any, E : Any> Result<T, E>.isErrAnd(f: (E) -> Boolean): Boolean = isErr() && f(value)

fun <T : Any, E : Any> Result<T, E>.ok(): Option<T> = if (isOk()) value.toSome() else None()

fun <T : Any, E : Any> Result<T, E>.err(): Option<E> = if (isErr()) value.toSome() else None()

fun <T : Any, E : Any, U : Any> Result<T, E>.map(f: (T) -> U): Result<U, E> = if (isOk()) Ok(f(value)) else Err<U, E>(value)

fun <T : Any, E : Any, U : Any> Result<T, E>.mapOr(default: U, f: (T) -> U): U = if (isOk()) f(value) else default

fun <T : Any, E : Any, U : Any> Result<T, E>.mapOrElse(default: (E) -> U, f: (T) -> U): U = if (isOk()) f(value) else default(value)