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
		compilations.getByName("main") {
			cinterops {
				// https://raw.githubusercontent.com/JetBrains/kotlin/fad2e9c8f85c8f489c6b199a52ddf308bdc151a5/kotlin-native/llvmInterop/build.gradle.kts
				// https://raw.githubusercontent.com/JetBrains/kotlin/fad2e9c8f85c8f489c6b199a52ddf308bdc151a5/kotlin-native/llvmInterop/llvm.def
				val llvm by creating {
					compilerOpts += listOf(
						// It would be rude to force people to use Nix
						"-I${System.getenv("DEV_LLVM_LOCATION") ?: "/usr/lib/llvm-20"}/include",
						"-v",
						"-D_GNU_SOURCE",
						"-D__STDC_CONSTANT_MACROS",
						"-D__STDC_FORMAT_MACROS",
						"-D__STDC_LIMIT_MACROS"
					)
					linkerOpts += listOf(
						"-L${System.getenv("LIB_LLVM_LOCATION") ?: "/usr/lib/llvm-20"}/lib",
						"-lLLVM-20"
					)
				}
			}
		}
	}
	sourceSets {
		nativeMain.dependencies {
			implementation(libs.kotlinx.io)
		}
	}
}