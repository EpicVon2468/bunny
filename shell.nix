let
	nixpkgs = fetchTarball "https://github.com/NixOS/nixpkgs/tarball/nixos-unstable";
	pkgs = import nixpkgs { config = {}; overlays = []; };
	llvm = pkgs.llvmPackages_20;
in

pkgs.mkShellNoCC {
	packages = with pkgs; [
		llvm.llvm
		llvm.libllvm
	];

	LIB_LLVM_LOCATION = llvm.llvm.lib.outPath;
	DEV_LLVM_LOCATION = llvm.llvm.dev.outPath;
}