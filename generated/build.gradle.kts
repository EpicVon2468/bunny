plugins {
	id("java")
}

group = "generated"
version = "1.0.0"

repositories {
	mavenCentral()
}

tasks.withType<JavaCompile> {
	options.apply {
		encoding = "UTF-8"
		isIncremental = true
	}
}

// jextract --include-dir $DEV_LLVM_LOCATION/include/llvm-c --output . --target-package org.llvm --library LLVM-20 --use-system-load-library $DEV_LLVM_LOCATION/include/llvm-c/Core.h
// jextract --include-dir $DEV_LLVM_LOCATION/include/llvm-c --output . --target-package org.llvm --library LLVM-20 --use-system-load-library $DEV_LLVM_LOCATION/include/llvm-c/Target.h