# Implementation

Status of feature implementation:

### Overall:

- [ ] Runtime;
- [ ] LLVM(-C) for code execution;
- [ ] Lexer;
- [ ] Parser;

### Code Guidelines:

- [X] Input files must use UTF-8 (not checked);
- [X] Input files may use `\r\n` or `\n`;
- [X] Mix of tabs & spaces is allowed;
- [ ] Trailing whitespace is allowed:
	- Problem: Trailing whitespace at end of file crashes lexer.

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