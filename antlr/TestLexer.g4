lexer grammar TestLexer;

fragment LOWERCASE : [a-z] ;
fragment UPPERCASE : [A-Z] ;
fragment DIGIT : [0-9] ;
fragment OPEN_PAREN : '(' ;
fragment CLOSE_PAREN : ')' ;
fragment EQUALS : '=' ;

OPEN_BRACE : '{' ;
CLOSE_BRACE : '}' ;

ASSIGNMENT : EQUALS ;
COMPARISON : EQUALS EQUALS ;

TERMINATION : ';' ;

NUMBER : DIGIT+ ([.,] DIGIT+)? ;

FUNCTION : 'fun' ;
FUNCTION_PROTOTYPE : IDENTIFIER OPEN_PAREN IDENTIFIER* CLOSE_PAREN ;

IDENTIFIER : (LOWERCASE | UPPERCASE | '_')+ ;

WHITESPACE : (' ' | '\t') ;

NEWLINE : ('\r'? '\n')+ ;