grammar Main;

@header {
package generated.antlr;
}

import PrimaryLexer;

//whitespace : (WHITESPACE | NEWLINE)* ;

primary :
	version
	topLevel*
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
		(
			variableDefinition
			|
			assignmentExpression
			|
			returnExpression
		)*
		CLOSE_BRACE
	)
	;

typeDefinition : STRUCT IDENTIFIER TERMINATION ;

variableDefinition :
	VARIABLE MUTABLE?
	IDENTIFIER TYPE_SPECIFIER type
	ASSIGNMENT
	expression
	TERMINATION
	;

assignmentExpression : IDENTIFIER ASSIGNMENT expression TERMINATION ;

returnExpression : RETURN expression? TERMINATION ;

expression :
	(
		IDENTIFIER
		|
		NUMBER
		|
		STRING_LITERAL
	)
	(
		(
			DIV
			|
			ASTERISK // MUL
			|
			ADD
			|
			SUB
		)
		(
			IDENTIFIER
			|
			NUMBER
			|
			STRING_LITERAL
		)
	)*
	;

parameterList :
	IDENTIFIER TYPE_SPECIFIER type
	(ARGUMENT_SEPARATOR IDENTIFIER TYPE_SPECIFIER type)*
	(ARGUMENT_SEPARATOR IDENTIFIER TYPE_SPECIFIER VARARG)?
	;

type : IDENTIFIER | pointerType ;
pointerType : ASTERISK+ IDENTIFIER ;