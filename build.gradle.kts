plugins {
	alias(libs.plugins.kotlin.multiplatform)
}

group = "io.github.epicvon2468.bunny"
version = "1.0.0"

repositories {
	mavenCentral()
}

kotlin {
	linuxX64 {
		binaries {
			executable {
				entryPoint = "io.github.epicvon2468.bunny.main"
			}
		}
	}
	sourceSets {
		nativeMain.dependencies {
			implementation(libs.kotlinx.io)
		}
	}
}