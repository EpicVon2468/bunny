lexer grammar PrimaryLexer;

fragment LOWERCASE : [a-z] ;
fragment UPPERCASE : [A-Z] ;
fragment DIGIT : [0-9] ;
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

ASTERISK : '*' ; // ptr || multiplication
VARARG : '...' ;

ASSIGNMENT : EQUALS ;
COMPARISON : EQUALS EQUALS ;

STRING_LITERAL : '"' ('\\"' | .)*? '"';

COMMENT : ('//' | '#') .*? (NEWLINE | EOF) ;
DOCUMENTATION_COMMENT : '///' .*? (NEWLINE | EOF) ;
SECTION_COMMENT : '/*' .*? '*/' ;

TERMINATION : ';' ;

NUMBER : DIGIT+ ([.,] DIGIT+)? ;

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

TYPE_SPECIFIER: ':';

IDENTIFIER
	: (LOWERCASE | UPPERCASE | '_')+
	| '`' FUNCTION '`'
	| '`' VARIABLE '`'
	| '`' MUTABLE '`'
	| '`' STRUCT '`'
	| '`' SINGLETON '`'
	| '`' RETURN '`'
	;

VERSION_DECLARATION : 'VERSION ' DIGIT WHITESPACE+ DIGIT WHITESPACE+ DIGIT WHITESPACE* NEWLINE ;

WHITESPACE : (' ' | '\t') ;
NEWLINE : ('\r'? '\n')+ ;