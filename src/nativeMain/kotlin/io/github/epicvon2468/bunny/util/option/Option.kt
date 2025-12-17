@file:OptIn(ExperimentalContracts::class)
package io.github.epicvon2468.bunny.util.option

import io.github.epicvon2468.bunny.util.option.Option.*
import io.github.epicvon2468.bunny.util.option.Option.Companion.None

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed interface Option<T : Any> {

	data object None : Option<Any>

	value class Some<T : Any>(val value: T) : Option<T>

	companion object {

		@Suppress("UNCHECKED_CAST", "FunctionName", "NOTHING_TO_INLINE")
		inline fun <T : Any> None(): Option<T> = None as Option<T>
	}
}

fun <T : Any> T?.toOption(): Option<T> = this?.toSome() ?: None()

fun <T : Any> T.toSome(): Some<T> = Some(this)

fun <T : Any> Option<T>.isSome(): Boolean {
	contract {
		returns(true) implies (this@isSome is Some<T>)
		returns(false) implies (this@isSome is None)
	}
	return this is Some
}

inline fun <T : Any> Option<T>.isSomeAnd(f: (T) -> Boolean): Boolean = isSome() && f(value)

fun <T : Any> Option<T>.isNone(): Boolean {
	contract {
		returns(true) implies (this@isNone is None)
		returns(false) implies (this@isNone is Some<T>)
	}
	return this is None
}

inline fun <T : Any> Option<T>.isNoneOr(f: (T) -> Boolean): Boolean = if (isNone()) true else f(value)

fun <T : Any> Option<T>.expect(msg: String): T = if (isSome()) value else error(msg)

fun <T : Any> Option<T>.unwrap(): T = if (isSome()) value else error("Called Option<T>.unwrap() on Option.None")

fun <T : Any> Option<T>.unwrapOr(default: T): T = if (isSome()) value else default

inline fun <T : Any> Option<T>.unwrapOrElse(f: () -> T): T = if (isSome()) value else f()

inline fun <T : Any, U : Any> Option<T>.map(f: (T) -> U): Option<U> = if (isSome()) Some(f(value)) else None()

inline fun <T : Any> Option<T>.inspect(f: (T) -> Unit): Option<T> = this.apply { if (isSome()) f(value) }

inline fun <T : Any, U : Any> Option<T>.mapOr(default: U, f: (T) -> U): U = if (isSome()) f(value) else default

inline fun <T : Any, U : Any> Option<T>.mapOrElse(default: () -> U, f: (T) -> U): U = if (isSome()) f(value) else default()

infix fun <T : Any, U : Any> Option<T>.and(optb: Option<U>): Option<U> = if (isSome()) optb else None()

fun <T : Any, U : Any> Option<T>.andThen(f: (T) -> Option<U>): Option<U> = if (isSome()) f(value) else None()

inline fun <T : Any> Option<T>.filter(predicate: (T) -> Boolean): Option<T> = if (isSome() && predicate(value)) this else None()

infix fun <T : Any> Option<T>.or(optb: Option<T>): Option<T> = if (isSome()) this else optb

inline fun <T : Any> Option<T>.orElse(f: () -> Option<T>): Option<T> = if (isSome()) this else f()

infix fun <T : Any> Option<T>.xor(optb: Option<T>): Option<T> = when {
	this.isSome() && optb.isNone() -> this
	this.isNone() && optb.isSome() -> optb
	else -> None()
}