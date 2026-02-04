grammar Main;

@header {
package generated.antlr;
}

import PrimaryLexer;

//whitespace : (WHITESPACE | NEWLINE)* ;

top :
	version
	topLevel*
	;

topLevel : functionDefinition | structDefinition;

version : VERSION NUM_INT NUM_INT NUM_INT ;

functionDefinition :
	FUNCTION IDENTIFIER

	OPEN_PAREN
	parameterList?
	CLOSE_PAREN

	(TYPE_SPECIFIER type)?

	(
		TERMINATION
		|
		OPEN_BRACE
		functionBody
		CLOSE_BRACE
	)
	;

functionBody : (variableDefinition | assignmentExpression | standaloneExpression | returnExpression)*;

structDefinition :
	STRUCT IDENTIFIER
	(
		TERMINATION
		|
		OPEN_BRACE
		(
			variableDefinition
			|
			functionDefinition
		)*
		CLOSE_BRACE
	)
	;

variableDefinition :
	VARIABLE MUTABLE?
	identifierWithType
	(ASSIGNMENT	expression)?
	TERMINATION
	;

standaloneExpression : expression TERMINATION ;

assignmentExpression : IDENTIFIER ASSIGNMENT expression TERMINATION ;

returnExpression : RETURN expression? TERMINATION ;

// https://craftinginterpreters.com/parsing-expressions.html
expression : equalityExpression ;
equalityExpression : comparisonExpression ((COMPARISON_NOT_EQUALS | COMPARISON_EQUALS) comparisonExpression)* ;
comparisonExpression : termExpression ((COMPARISON_GREATER | COMPARISON_GREATER_THAN | COMPARISON_LESS | COMPARISON_LESS_THAN) termExpression)* ;
termExpression : factorExpression ((SUB | ADD) factorExpression)* ;
factorExpression : unaryExpression ((DIV | ASTERISK) unaryExpression)* ;
unaryExpression : (NOT | SUB) unaryExpression | primaryExpression;
primaryExpression :
	NUM_INT
	| NUM_FLOAT
	| STRING_LITERAL
	| TRUE
	| FALSE
	| staticFunctionCall
	| functionCall
	| structFieldCall
	| IDENTIFIER
	| OPEN_PAREN expression CLOSE_PAREN
	;

staticFunctionCall : IDENTIFIER '::' functionCall ;
functionCall : IDENTIFIER OPEN_PAREN argList? CLOSE_PAREN ;
structFieldCall : IDENTIFIER MEMBER_REFERENCE IDENTIFIER ;

argList :
	(
		expression
		(ARGUMENT_SEPARATOR expression)*
		(ARGUMENT_SEPARATOR VARARG)?
	)
	|
	VARARG
	;

parameterList :
	(
		identifierWithType
		(ARGUMENT_SEPARATOR identifierWithType)*
		(ARGUMENT_SEPARATOR VARARG)?
	)
	|
	VARARG
	;

identifierWithType : IDENTIFIER TYPE_SPECIFIER type ;
// TODO: Allow this?
//identifierWithVararg : IDENTIFIER TYPE_SPECIFIER VARARG ;

type : IDENTIFIER | pointerType ;
pointerType : ASTERISK+ IDENTIFIER ;