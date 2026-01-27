{
	description = "The Bunny compiler";

	inputs = {
		nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
		flake-utils.url = "github:numtide/flake-utils";
	};

	outputs = { self, nixpkgs, flake-utils }:
		flake-utils.lib.eachDefaultSystem(system:
			let
				pkgs = import nixpkgs { inherit system; };
				llvm = pkgs.llvmPackages_20;
				glibc = pkgs.glibc;
				libcxx = pkgs.libcxx;
				clangWindows = pkgs.pkgsCross.mingwW64.buildPackages.clang;
			in {
					devShells.default = pkgs.mkShellNoCC {
						buildInputs = with pkgs; [
							llvm.llvm
							llvm.libllvm
							glibc
							libcxx
							llvm.clang
							pkgs.gdb
							clangWindows
						];

						NIX_CFLAGS_COMPILE_FOR_TARGET = "-Wno-unused-command-line-argument";
						CLANG_WINDOWS = "${clangWindows.outPath}/bin/x86_64-w64-mingw32-clang";
						LIB_LLVM_LOCATION = llvm.llvm.lib.outPath;
						DEV_LLVM_LOCATION = llvm.llvm.dev.outPath;
						GLIBC_LOCATION = glibc.outPath;
						LIBCXX_LOCATION = libcxx.outPath;
					};
				}
		);
}