grammar Main;

@header {
package generated.antlr;
}

import PrimaryLexer;

//whitespace : (WHITESPACE | NEWLINE)* ;

primary :
	version
	(functionDefinition | typeDefinition)*
	;

version : VERSION_DECLARATION ;

functionDefinition :
	FUNCTION IDENTIFIER

	OPEN_PAREN
	IDENTIFIER TYPE_SPECIFIER IDENTIFIER (ARGUMENT_SEPARATOR IDENTIFIER TYPE_SPECIFIER IDENTIFIER)*
	CLOSE_PAREN

	TYPE_SPECIFIER
	IDENTIFIER

	(
		TERMINATION
		|
		OPEN_BRACE

		CLOSE_BRACE
	)
	;

typeDefinition :
	STRUCT IDENTIFIER TERMINATION
	;