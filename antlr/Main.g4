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

// https://craftinginterpreters.com/parsing-expressions.html
expression : equalityExpression ;
equalityExpression : comparisonExpression ((COMPARISON_NOT_EQUALS | COMPARISON_EQUALS) comparisonExpression)* ;
comparisonExpression : termExpression ((COMPARISON_GREATER | COMPARISON_GREATER_THAN | COMPARISON_LESS | COMPARISON_LESS_THAN) termExpression)* ;
termExpression : factorExpression ((SUB | ADD) factorExpression)* ;
factorExpression : unaryExpression ((DIV | ASTERISK) unaryExpression)* ;
unaryExpression : (NOT | SUB) unaryExpression | primaryExpression;
primaryExpression : NUMBER | STRING_LITERAL | TRUE | FALSE | IDENTIFIER | OPEN_PAREN expression CLOSE_PAREN ;

parameterList :
	IDENTIFIER TYPE_SPECIFIER type
	(ARGUMENT_SEPARATOR IDENTIFIER TYPE_SPECIFIER type)*
	(ARGUMENT_SEPARATOR IDENTIFIER TYPE_SPECIFIER VARARG)?
	;

type : IDENTIFIER | pointerType ;
pointerType : ASTERISK+ IDENTIFIER ;