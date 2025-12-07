# Language Specification

This file contains all the specifications for Bunny. This file should be considered a universal source of truth for
behaviour over compiler behaviour.

## Starting a file

- All input files must start with a version specification on the first line. This version text informs the
	compiler with information about the version features that can be used in the program.
	- See [Version Specification](#version-specification).
	- If the compiler is made for an older version than a file specifies, it will crash.
	- TODO: When language has project folder setups, make it so version can be omitted (unless overridden explicitly) if
		it's specified in the root?
- Imports must come at the start of an input file, after the version specification (if it was specified).
	- See [Import Specification](#import-specification).

## Code Guidelines

- All input files **must** be encoded in UTF-8. UTF-16 & UTF-32 will not be tolerated (supporting ligature characters in
	these encodings is problematic).
- Input files may use `\r\n` or `\n` for newlines. Legacy macOS newlines (`\r`) are not supported.
- Input files may contain a mixture of spaces and tabs for indentation, alongside trailing whitespace; However, the
	recommended behaviour is tabs with no trailing whitespace.
- British English is **strongly** recommended, as the standard library will be written with this in mind (Colour vs
	Color, Maths vs Math, Initialise vs Initialize, etc).

## Syntax

#### Version Specification:

- `VERSION {Major} {Minor} {Revision}`.
	- Examples:
		- `VERSION 0 0 0`;
		- `VERSION 20 3 77`;
		- `VERSION 9 3 6`;
	- "VERSION" is not a substitution, you literally write `VERSION ` before the version numbers.
	- Only positive integers may be used in version numbers.
	- The version line will always be at minimum 13 characters long.
	- Force version override from commandline.

#### Import Specification:

- `import {QualifiedName} using "{FilePath}"`.
	- Examples:
		- `import exampleLib.ExtendedMaths using "include/exampleLib"`;
		- `import standard.Maths using "standard"`;
		- `import myModule.MyClass using "this"`;
	- For standard library imports, the file path only needs to be `using "standard"`.
		- This does not require the existence of a `standard` file or directory.
		- TODO: Make the `using "standard"` entirely optional?

#### Semantics:

- A statement/expression is considered terminated when a newline character is read;