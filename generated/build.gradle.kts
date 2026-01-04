plugins {
	id("java")
}

group = "generated"
version = "1.0.0"

repositories {
	mavenCentral()
}

// TODO: The below generator _works_, but the output needed some corrections.  Try https://github.com/openjdk/jextract/blob/master/doc/GUIDE.md#running-jextract next time.
// jextract -l libLLVM-20.so --output generated/src/main/java -I $DEV_LLVM_LOCATION/include/llvm-c -t org.llvm $DEV_LLVM_LOCATION/include/llvm-c/Core.h