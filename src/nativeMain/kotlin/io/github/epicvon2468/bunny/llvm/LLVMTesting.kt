@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.bunny.llvm

import kotlinx.cinterop.*

import llvm.LLVMAddFunction
import llvm.LLVMAppendBasicBlockInContext
import llvm.LLVMBasicBlockRef
import llvm.LLVMBool
import llvm.LLVMBuildCall2
import llvm.LLVMBuildGlobalString
import llvm.LLVMBuildPointerCast
import llvm.LLVMBuildRet
import llvm.LLVMBuilderRef
import llvm.LLVMConstInt
import llvm.LLVMContextCreate
import llvm.LLVMContextDispose
import llvm.LLVMContextRef
import llvm.LLVMCreateBuilderInContext
import llvm.LLVMDisposeBuilder
import llvm.LLVMDisposeModule
import llvm.LLVMFunctionType
import llvm.LLVMInt32TypeInContext
import llvm.LLVMInt8TypeInContext
import llvm.LLVMModuleCreateWithNameInContext
import llvm.LLVMModuleRef
import llvm.LLVMPointerType
import llvm.LLVMPositionBuilderAtEnd
import llvm.LLVMPrintModuleToFile
import llvm.LLVMTypeRef
import llvm.LLVMValueRef

inline val TRUE: LLVMBool get() = 1
inline val FALSE: LLVMBool get() = 0

//ld.lld: error: undefined symbol: mallinfo2
//>>> referenced by Process.cpp.o:(llvm::sys::Process::GetMallocUsage()) in archive /tmp/included1723761264190233995/libLLVMSupport.a
//>>> did you mean: mallinfo
//>>> defined in: /home/mavity/.konan/dependencies/x86_64-unknown-linux-gnu-gcc-8.3.0-glibc-2.19-kernel-4.9-2/x86_64-unknown-linux-gnu/sysroot/lib64/libc.so.6
//
//ld.lld: error: undefined symbol: __isoc23_strtol
//>>> referenced by Process.cpp.o:(llvm::sys::Process::StandardOutColumns()) in archive /tmp/included1723761264190233995/libLLVMSupport.a
//>>> referenced by Process.cpp.o:(llvm::sys::Process::StandardErrColumns()) in archive /tmp/included1723761264190233995/libLLVMSupport.a
//>>> referenced by InlineAsm.cpp.o:(llvm::InlineAsm::ConstraintInfo::Parse(llvm::StringRef, std::vector<llvm::InlineAsm::ConstraintInfo, std::allocator<llvm::InlineAsm::ConstraintInfo>>&) (.localalias)) in archive /tmp/included1723761264190233995/libLLVMCore.a
//
//ld.lld: error: undefined symbol: arc4random
//>>> referenced by Process.cpp.o:(llvm::sys::Process::GetRandomNumber()) in archive /tmp/included1723761264190233995/libLLVMSupport.a
//
//ld.lld: error: undefined symbol: std::__throw_bad_array_new_length()
//>>> referenced by CommandLine.cpp.o:(llvm::cl::opt<(anonymous namespace)::VersionPrinter, true, llvm::cl::parser<bool>>::handleOccurrence(unsigned int, llvm::StringRef, llvm::StringRef)) in archive /tmp/included1723761264190233995/libLLVMSupport.a
//>>> referenced by Function.cpp.o:(llvm::Function::BuildLazyArguments() const) in archive /tmp/included1723761264190233995/libLLVMCore.a
//>>> referenced by CycleInfo.cpp.o:(llvm::GenericCycleInfo<llvm::GenericSSAContext<llvm::Function>>::print(llvm::raw_ostream&) const) in archive /tmp/included1723761264190233995/libLLVMCore.a
//>>> referenced 20 more times
//
//ld.lld: error: undefined symbol: __isoc23_strtoll
//>>> referenced by JSON.cpp.o:(llvm::json::(anonymous namespace)::Parser::parseValue(llvm::json::Value&)) in archive /tmp/included1723761264190233995/libLLVMSupport.a
//
//ld.lld: error: undefined symbol: __isoc23_strtoull
//>>> referenced by JSON.cpp.o:(llvm::json::(anonymous namespace)::Parser::parseValue(llvm::json::Value&)) in archive /tmp/included1723761264190233995/libLLVMSupport.a
//
//ld.lld: error: undefined symbol: __libc_single_threaded
//>>> referenced by BitstreamRemarkParser.cpp.o:(std::vector<std::shared_ptr<llvm::BitCodeAbbrev>, std::allocator<std::shared_ptr<llvm::BitCodeAbbrev>>>::operator=(std::vector<std::shared_ptr<llvm::BitCodeAbbrev>, std::allocator<std::shared_ptr<llvm::BitCodeAbbrev>>> const&) (.isra.0)) in archive /tmp/included1723761264190233995/libLLVMRemarks.a
//>>> referenced by BitstreamRemarkParser.cpp.o:(std::vector<std::shared_ptr<llvm::BitCodeAbbrev>, std::allocator<std::shared_ptr<llvm::BitCodeAbbrev>>>::operator=(std::vector<std::shared_ptr<llvm::BitCodeAbbrev>, std::allocator<std::shared_ptr<llvm::BitCodeAbbrev>>> const&) (.isra.0)) in archive /tmp/included1723761264190233995/libLLVMRemarks.a
//>>> referenced by BitstreamRemarkParser.cpp.o:(std::vector<std::shared_ptr<llvm::BitCodeAbbrev>, std::allocator<std::shared_ptr<llvm::BitCodeAbbrev>>>::operator=(std::vector<std::shared_ptr<llvm::BitCodeAbbrev>, std::allocator<std::shared_ptr<llvm::BitCodeAbbrev>>> const&) (.isra.0)) in archive /tmp/included1723761264190233995/libLLVMRemarks.a
//>>> referenced 87 more times
fun hello(): Unit = memScoped {
	val context: LLVMContextRef = LLVMContextCreate()!!
	val module: LLVMModuleRef = LLVMModuleCreateWithNameInContext(/*ModuleID =*/ "hello", context)!!
	val builder: LLVMBuilderRef = LLVMCreateBuilderInContext(context)!!

	val int8Type: LLVMTypeRef = LLVMInt8TypeInContext(context)!!
	val int8TypePtr: LLVMTypeRef = LLVMPointerType(int8Type, 0u)!!
	val int32Type: LLVMTypeRef = LLVMInt32TypeInContext(context)!!

	// Puts function
	val putsFunctionArgsType: CArrayPointer<CPointerVarOf<LLVMTypeRef>> = allocArrayOf(
		int8TypePtr
	)

	val putsFunctionType: LLVMTypeRef = LLVMFunctionType(
		/*ReturnType =*/ int32Type,
		/*ParamTypes =*/ putsFunctionArgsType,
		/*ParamCount =*/ 1u,
		/*IsVarArg =*/ FALSE
	)!!
	val putsFunction: LLVMValueRef = LLVMAddFunction(module, "puts", putsFunctionType)!!
	// end

	// Main function
	val mainFunctionType: LLVMTypeRef = LLVMFunctionType(
		/*ReturnType =*/ int32Type,
		/*ParamTypes =*/ null,
		/*ParamCount =*/ 0u,
		/*IsVarArg =*/ FALSE
	)!!
	val mainFunction: LLVMValueRef = LLVMAddFunction(module, "main", mainFunctionType)!!

	val entry: LLVMBasicBlockRef = LLVMAppendBasicBlockInContext(context, mainFunction, "entry")!!
	LLVMPositionBuilderAtEnd(builder, entry)

	val putsFunctionArgs: CArrayPointer<CPointerVarOf<LLVMValueRef>> = allocArrayOf(
		LLVMBuildPointerCast(
			/*arg0 =*/ builder,
			/*Val =*/ LLVMBuildGlobalString(builder, "Hello, world!", "hello"),
			/*DestTy =*/ int8TypePtr,
			/*Name =*/ "0",
		)
	)

	LLVMBuildCall2(
		/*arg0 =*/ builder,
		/*arg1 =*/ putsFunctionType,
		/*Fn =*/ putsFunction,
		/*Args =*/ putsFunctionArgs,
		/*NumArgs =*/ 1u,
		/*Name =*/ "i"
	)
	LLVMBuildRet(builder, LLVMConstInt(int32Type, 0u, FALSE))
	// end

	LLVMPrintModuleToFile(module, "hello.ll", null)

	LLVMDisposeBuilder(builder)
	LLVMDisposeModule(module)
	LLVMContextDispose(context)
}