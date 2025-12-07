# Setup

Information on how to setup the project locally.

### Downloading from source

- Clone [the repo](https://github.com/EpicVon2468/bunny) using git,
	or [download the repo as a zip archive via GitHub](https://github.com/EpicVon2468/bunny/archive/refs/heads/master.zip).

### Dependencies

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download) ("Optional") (Fear not, broke people! Scroll down on the
	download page for the free Community Edition).
- [Nix](https://nix.dev/install-nix).
- [Direnv](https://direnv.net/docs/installation.html). You only need to install it via your package manager of choice, and
	then [hook it into your shell](https://direnv.net/docs/hook.html). Everything else is already setup.

### Execution

- Run `direnv allow` in the project directory (This will start the `nix-shell` with
	the [project configuration](/shell.nix)).
- Restart your shell and reopen the directory.
- Take your pick of build action. Either:
	- Open IntelliJ using the `idea` command, import the project and run the `runDebugExecutableLinuxX64` Gradle task.
		- NOTE: If you use IntelliJ, you must always open it via running the `idea` command in the project directory, or Nix
			will not be active when you try to build or run.
	- OR run `./gradlew --refresh-dependencies runDebugExecutableLinuxX64` in your terminal.
		- NOTE: I haven't actually tested if this will work without IntelliJ, and Kotlin might not be configured or
			installed properly without it, but I can't say for sure.
- In both cases, you can find an output binary under `build/bin/linuxX64/debugExecutable/bunny.kexe`