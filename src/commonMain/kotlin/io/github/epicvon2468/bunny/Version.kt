package io.github.epicvon2468.bunny

import kotlinx.serialization.Serializable as Serialisable

@Serialisable
data class Version(val major: Int, val minor: Int, val revision: Int) {

	constructor(major: String, minor: String, revision: String) : this(major.toInt(), minor.toInt(), revision.toInt())

	constructor(major: Char, minor: Char, revision: Char) : this(major.digitToInt(), minor.digitToInt(), revision.digitToInt())

	operator fun compareTo(other: Version): Int {
		if (this == other) return 0
		this.major.compareTo(other.major).let {
			if (it != 0) return@compareTo it
		}
		this.minor.compareTo(other.minor).let {
			if (it != 0) return@compareTo it
		}
		return this.revision.compareTo(other.revision)
	}

	override fun toString(): String = "v$major.$minor.$revision"

	companion object {

		operator fun invoke(input: String): Version {
			val versions: List<String> = input.split(' ', '\t').filterNot(CharSequence::isBlank)
			if (versions.size != 3) error("Expected list of three elements, but got: $versions!  (original input: \"$input\")")
			return Version(versions[0].toInt(), versions[1].toInt(), versions[2].toInt())
		}

		val CURRENT: Version = Version(0, 0, 0)
	}
}