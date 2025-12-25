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

ASSIGNMENT : EQUALS ;
COMPARISON : EQUALS EQUALS ;

STRING_LITERAL : '"' ('\\"' | .)*? '"';

COMMENT : '//' .*? NEWLINE ;
DOCUMENTATION_COMMENT : '///' .*? NEWLINE ;
SECTION_COMMENT : '/*' *.? '*/' ;

TERMINATION : ';' ;

NUMBER : DIGIT+ ([.,] DIGIT+)? ;

FUNCTION : 'funct' ;
VARIABLE : 'define' ;
RETURN : 'return' ;

STATIC_KEYWORD_REFERENCE : '::' ;
STATIC_KEYWORD__NEW : 'new' ;

TYPE_SPECIFIER: ':';

IDENTIFIER : (LOWERCASE | UPPERCASE | '_')+ ;

WHITESPACE : (' ' | '\t') ;
NEWLINE : ('\r'? '\n')+ ;