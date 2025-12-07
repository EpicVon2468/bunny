# Implementation

Status of feature implementation:

### Overall:

- [ ] Runtime;
- [ ] LLVM for code execution;
- [ ] Lexer;
- [ ] Parser;

### Specification:

- Version Specification:
	- [X] Per-file configuration;
	- [ ] Project-wide configuration;
- Import Specification:
	- [ ] Importing;
	- [ ] Standard library imports only requiring `using "standard"`;
	- [ ] Standard library imports not requiring any `using` statements;
	- [ ] Module imports only requiring `using "this"`;
- Semantics:
	- [X] Statement/expression termination on newline;