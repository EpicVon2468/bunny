@file:OptIn(ExperimentalKotlinGradlePluginApi::class)
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
	alias(libs.plugins.kotlin.multiplatform)
	alias(libs.plugins.kotlin.serialisation)
}

group = "io.github.epicvon2468.bunny"
version = "1.0.0"

repositories {
	mavenCentral()
}

kotlin {
	jvm {
		binaries {
			executable {
				applicationDefaultJvmArgs.add("-XX:+UseCompactObjectHeaders")
				// This isn't adding the `Main-Class` attribute?!
				mainClass.set("io.github.epicvon2468.bunny.MainKt")
			}
		}
		mainRun {
			args("-XX:+UseCompactObjectHeaders")
			mainClass.set("io.github.epicvon2468.bunny.MainKt")
		}
	}
	jvmToolchain(25)
	linuxX64 {
		binaries {
			executable {
				entryPoint = "io.github.epicvon2468.bunny.main"
				// Thank you, kind stranger.
				// https://discuss.kotlinlang.org/t/mismatch-between-glibc-versions-kotlin-native-on-linux/30780
				linkerOpts += listOf(
					"-L${System.getenv("GLIBC_LOCATION")}/lib",
					"-L${System.getenv("LIBCXX_LOCATION")}/lib",
					"-lc++",
					"--allow-shlib-undefined",
					"--unresolved-symbols=ignore-all",
					"--warn-unresolved-symbols"
				)
			}
		}
		compilations.getByName("main") {
			cinterops {
				// cinterop -def llvm.def -libraryPath $LIB_LLVM_LOCATION/lib -compiler-option -I$DEV_LLVM_LOCATION/include -o llvm
				// https://raw.githubusercontent.com/JetBrains/kotlin/fad2e9c8f85c8f489c6b199a52ddf308bdc151a5/kotlin-native/llvmInterop/build.gradle.kts
				// https://raw.githubusercontent.com/JetBrains/kotlin/fad2e9c8f85c8f489c6b199a52ddf308bdc151a5/kotlin-native/llvmInterop/llvm.def
//				val llvm by creating {
//					compilerOpts += listOf(
//						// It would be rude to force people to use Nix
//						"-I${System.getenv("DEV_LLVM_LOCATION") ?: "/usr/lib/llvm-20"}/include",
//						"-v",
//						"-D_GNU_SOURCE",
//						"-D__STDC_CONSTANT_MACROS",
//						"-D__STDC_FORMAT_MACROS",
//						"-D__STDC_LIMIT_MACROS"
//					)
//					linkerOpts += listOf(
//						"-L${System.getenv("LIB_LLVM_LOCATION") ?: "/usr/lib/llvm-20"}/lib",
//						//"--verbose",
//						"-lLLVM",
//						"-lLLVM-20",
//						"-lLLVMCore"
//					)
//					// llvm-config --cflags --system-libs --ignore-libllvm --libs
//					linkerOpts += "-lLLVMWindowsManifest -lLLVMXRay -lLLVMLibDriver -lLLVMDlltoolDriver -lLLVMTelemetry -lLLVMTextAPIBinaryReader -lLLVMCoverage -lLLVMLineEditor -lLLVMXCoreDisassembler -lLLVMXCoreCodeGen -lLLVMXCoreDesc -lLLVMXCoreInfo -lLLVMX86TargetMCA -lLLVMX86Disassembler -lLLVMX86AsmParser -lLLVMX86CodeGen -lLLVMX86Desc -lLLVMX86Info -lLLVMWebAssemblyDisassembler -lLLVMWebAssemblyAsmParser -lLLVMWebAssemblyCodeGen -lLLVMWebAssemblyUtils -lLLVMWebAssemblyDesc -lLLVMWebAssemblyInfo -lLLVMVEDisassembler -lLLVMVEAsmParser -lLLVMVECodeGen -lLLVMVEDesc -lLLVMVEInfo -lLLVMSystemZDisassembler -lLLVMSystemZAsmParser -lLLVMSystemZCodeGen -lLLVMSystemZDesc -lLLVMSystemZInfo -lLLVMSPIRVCodeGen -lLLVMSPIRVDesc -lLLVMSPIRVInfo -lLLVMSPIRVAnalysis -lLLVMSparcDisassembler -lLLVMSparcAsmParser -lLLVMSparcCodeGen -lLLVMSparcDesc -lLLVMSparcInfo -lLLVMRISCVTargetMCA -lLLVMRISCVDisassembler -lLLVMRISCVAsmParser -lLLVMRISCVCodeGen -lLLVMRISCVDesc -lLLVMRISCVInfo -lLLVMPowerPCDisassembler -lLLVMPowerPCAsmParser -lLLVMPowerPCCodeGen -lLLVMPowerPCDesc -lLLVMPowerPCInfo -lLLVMNVPTXCodeGen -lLLVMNVPTXDesc -lLLVMNVPTXInfo -lLLVMMSP430Disassembler -lLLVMMSP430AsmParser -lLLVMMSP430CodeGen -lLLVMMSP430Desc -lLLVMMSP430Info -lLLVMMipsDisassembler -lLLVMMipsAsmParser -lLLVMMipsCodeGen -lLLVMMipsDesc -lLLVMMipsInfo -lLLVMLoongArchDisassembler -lLLVMLoongArchAsmParser -lLLVMLoongArchCodeGen -lLLVMLoongArchDesc -lLLVMLoongArchInfo -lLLVMLanaiDisassembler -lLLVMLanaiCodeGen -lLLVMLanaiAsmParser -lLLVMLanaiDesc -lLLVMLanaiInfo -lLLVMHexagonDisassembler -lLLVMHexagonCodeGen -lLLVMHexagonAsmParser -lLLVMHexagonDesc -lLLVMHexagonInfo -lLLVMBPFDisassembler -lLLVMBPFAsmParser -lLLVMBPFCodeGen -lLLVMBPFDesc -lLLVMBPFInfo -lLLVMAVRDisassembler -lLLVMAVRAsmParser -lLLVMAVRCodeGen -lLLVMAVRDesc -lLLVMAVRInfo -lLLVMARMDisassembler -lLLVMARMAsmParser -lLLVMARMCodeGen -lLLVMARMDesc -lLLVMARMUtils -lLLVMARMInfo -lLLVMAMDGPUTargetMCA -lLLVMAMDGPUDisassembler -lLLVMAMDGPUAsmParser -lLLVMAMDGPUCodeGen -lLLVMAMDGPUDesc -lLLVMAMDGPUUtils -lLLVMAMDGPUInfo -lLLVMAArch64Disassembler -lLLVMAArch64AsmParser -lLLVMAArch64CodeGen -lLLVMAArch64Desc -lLLVMAArch64Utils -lLLVMAArch64Info -lLLVMOrcDebugging -lLLVMOrcJIT -lLLVMWindowsDriver -lLLVMMCJIT -lLLVMJITLink -lLLVMInterpreter -lLLVMExecutionEngine -lLLVMRuntimeDyld -lLLVMOrcTargetProcess -lLLVMOrcShared -lLLVMDWP -lLLVMDebugInfoLogicalView -lLLVMDebugInfoGSYM -lLLVMOption -lLLVMObjectYAML -lLLVMObjCopy -lLLVMMCA -lLLVMMCDisassembler -lLLVMLTO -lLLVMFrontendOpenACC -lLLVMFrontendHLSL -lLLVMFrontendDriver -lLLVMExtensions -lPolly -lPollyISL -lLLVMPasses -lLLVMHipStdPar -lLLVMCoroutines -lLLVMCFGuard -lLLVMipo -lLLVMInstrumentation -lLLVMVectorize -lLLVMSandboxIR -lLLVMLinker -lLLVMFrontendOpenMP -lLLVMFrontendAtomic -lLLVMFrontendOffloading -lLLVMDWARFLinkerParallel -lLLVMDWARFLinkerClassic -lLLVMDWARFLinker -lLLVMGlobalISel -lLLVMMIRParser -lLLVMAsmPrinter -lLLVMSelectionDAG -lLLVMCodeGen -lLLVMTarget -lLLVMObjCARCOpts -lLLVMCodeGenTypes -lLLVMCGData -lLLVMIRPrinter -lLLVMInterfaceStub -lLLVMFileCheck -lLLVMFuzzMutate -lLLVMScalarOpts -lLLVMInstCombine -lLLVMAggressiveInstCombine -lLLVMTransformUtils -lLLVMBitWriter -lLLVMAnalysis -lLLVMProfileData -lLLVMSymbolize -lLLVMDebugInfoBTF -lLLVMDebugInfoPDB -lLLVMDebugInfoMSF -lLLVMDebugInfoCodeView -lLLVMDebugInfoDWARF -lLLVMObject -lLLVMTextAPI -lLLVMMCParser -lLLVMIRReader -lLLVMAsmParser -lLLVMMC -lLLVMBitReader -lLLVMFuzzerCLI -lLLVMCore -lLLVMRemarks -lLLVMBitstreamReader -lLLVMBinaryFormat -lLLVMTargetParser -lLLVMTableGen -lLLVMSupport -lLLVMDemangle -lrt -ldl -lm -lz -lxml2".split(" ")
//				}
			}
		}
	}
	sourceSets {
		commonMain.dependencies {
			implementation(libs.kotlinx.serialisation)
		}
		nativeMain.dependencies {
			implementation(libs.kotlinx.io)
			implementation(fileTree("${rootDir}/src/nativeInterop/cinterop/llvm.klib"))
		}
		jvmMain.dependencies {
			implementation(libs.antlr4)
		}
	}
}