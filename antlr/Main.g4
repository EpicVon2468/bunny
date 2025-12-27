grammar Main;

@header {
package generated.antlr;
}

import PrimaryLexer;

//whitespace : (WHITESPACE | NEWLINE)* ;

primary :
	version
	(topLevel)*
	;

topLevel : functionDefinition | typeDefinition;

version : VERSION_DECLARATION ;

functionDefinition :
	FUNCTION IDENTIFIER

	OPEN_PAREN
	parameterList?
	CLOSE_PAREN

	TYPE_SPECIFIER
	type

	(
		TERMINATION
		|
		OPEN_BRACE

		CLOSE_BRACE
	)
	;

typeDefinition : STRUCT IDENTIFIER TERMINATION ;

parameterList : IDENTIFIER TYPE_SPECIFIER type (ARGUMENT_SEPARATOR IDENTIFIER TYPE_SPECIFIER type)* ;

type : IDENTIFIER | pointerType ;
pointerType : '*'+ IDENTIFIER ;