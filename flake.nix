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
			in {
					devShells.default = pkgs.mkShellNoCC {
						buildInputs = with pkgs; [
							llvm.llvm
							llvm.libllvm
						];

						LIB_LLVM_LOCATION = llvm.llvm.lib.outPath;
						DEV_LLVM_LOCATION = llvm.llvm.dev.outPath;
					};
				}
		);
}