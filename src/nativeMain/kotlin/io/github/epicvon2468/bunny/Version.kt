package io.github.epicvon2468.bunny

data class Version(val major: Int, val minor: Int, val revision: Int) {

	operator fun compareTo(other: Version): Int {
		if (this == other) return 0
		when (val it = this.major.compareTo(other.major)) {
			0 -> Unit
			else -> return it
		}
		when (val it = this.minor.compareTo(other.minor)) {
			0 -> Unit
			else -> return it
		}
		return this.revision.compareTo(other.revision)
	}

	companion object {

		fun parse(input: String): Version {
			val versions: List<String> = input.split(" ")
			if (versions.size != 3) error("Expected list of three elements, but got: $versions!  (original input: \"$input\")")
			return Version(versions[0].toInt(), versions[1].toInt(), versions[2].toInt())
		}

		val CURRENT: Version = Version(0, 0, 0)
	}
}