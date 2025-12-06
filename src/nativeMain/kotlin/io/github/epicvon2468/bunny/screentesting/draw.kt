package io.github.epicvon2468.bunny.screentesting

import platform.posix.usleep

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

// https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797

fun draw() = withHiddenCursor {
	for (x: Int in 42..75) {
		if (x % 2.0 == 0.0) continue
		for (y: Int in 1..25) {
			output(x, y)
			sleep(DELAY)
		}
	}
	for (x: Int in 43..75) {
		for (y: Int in 1..25) {
			if (y % 2.0 == 0.0) continue
			output(x, y)
			sleep(DELAY)
		}
	}
}

fun draw2() = withHiddenCursor {
	output(1, 1, '1')
	output(9, 9, '9')
	output(1920, 1080, 'i')
}

fun draw3() = withHiddenCursor {
	output(1, 2, "This is an overwrite")
}

fun withHiddenCursor(block: () -> Unit) {
	print("\u001b[?25l")
	block()
	println("\u001b[?25h")
}

fun output(x: Int, y: Int, c: Any = '█') = print("\u001b[$y;${x}H$c")

val DELAY: Duration = 0.001.seconds

fun sleep(duration: Duration): Int = usleep(duration.inWholeMicroseconds.toUInt())