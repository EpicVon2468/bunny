lexer grammar PrimaryLexer;

fragment LOWERCASE : [a-z] ;
fragment UPPERCASE : [A-Z] ;
fragment DIGIT : [0-9] ;
fragment GREATER : '>' ;
fragment LESS : '<' ;
fragment EQUALS : '=' ;

OPEN_PAREN : '(' ;
CLOSE_PAREN : ')' ;
OPEN_BRACE : '{' ;
CLOSE_BRACE : '}' ;

ARGUMENT_SEPARATOR : ',' ;
MEMBER_REFERENCE : '.' ;

// Brackets, Exponents, Division, Multiplication, Addition, Subtraction

DIV : '/' ;
//MUL : '*' ;
ADD : '+' ;
SUB : '-' ;
NOT : '!' ;

ASTERISK : '*' ; // ptr || multiplication
VARARG : '...' ;

ASSIGNMENT : EQUALS ;
COMPARISON_EQUALS : EQUALS EQUALS ;
COMPARISON_NOT_EQUALS : EQUALS EQUALS ;
COMPARISON_GREATER : GREATER ;
COMPARISON_GREATER_THAN : GREATER EQUALS ;
COMPARISON_LESS : LESS ;
COMPARISON_LESS_THAN : LESS EQUALS ;

STRING_LITERAL : '"' ('\\"' | .)*? '"' ;

COMMENT : ('//' | '#') .*? (NEWLINE | EOF) -> skip ;
DOCUMENTATION_COMMENT : '///' .*? (NEWLINE | EOF) -> skip ;
SECTION_COMMENT : '/*' .*? '*/' -> skip ;

TERMINATION : ';' ;

NUM_INT : DIGIT+ ;
NUM_FLOAT : NUM_INT ('.' DIGIT+)? 'f';

FUNCTION : 'funct' ;
VARIABLE : 'define' ;
MUTABLE : 'mutable' ;
CONSTANT : 'constant' ;
STRUCT : 'type' ;
SINGLETON : 'singleton' ;
RETURN : 'return' ;

STATIC_KEYWORD_NEW : '::new' ;
STATIC_KEYWORD_INSTANCE : '::instance()' ;
STATIC_KEYWORD_DESTROY : '::destroy()' ;

TRUE : 'true' ;
FALSE : 'false' ;

TYPE_SPECIFIER: ':' ;

VERSION : 'VERSION' ;

// prevents identifiers named '_'
RESERVED : '_' ;

IDENTIFIER
	: (LOWERCASE | UPPERCASE | '_') (LOWERCASE | UPPERCASE | '_' | DIGIT)*
	| '`' FUNCTION '`'
	| '`' VARIABLE '`'
	| '`' MUTABLE '`'
	| '`' STRUCT '`'
	| '`' SINGLETON '`'
	| '`' RETURN '`'
	| '`' VERSION '`'
	;

WHITESPACE : (' ' | '\t') -> skip ;
NEWLINE : ('\r'? '\n') -> skip ;