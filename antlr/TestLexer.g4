lexer grammar TestLexer;

fragment LOWERCASE : [a-z] ;
fragment UPPERCASE : [A-Z] ;
fragment DIGIT : [0-9] ;
fragment OPEN_BRACE : '{' ;
fragment CLOSE_BRACE : '}' ;
fragment OPEN_PAREN : '(' ;
fragment CLOSE_PAREN : ')' ;
fragment EQU : '=' ;

ASSIGNMENT : EQU ;

COMPARISON : EQU EQU ;

TERMINATION : ';' ;

NUMBER : DIGIT+ ([.,] DIGIT+)? ;

FUNCTION : 'fun' ;

FUNCTION_PROTOTYPE : IDENTIFIER OPEN_PAREN IDENTIFIER? CLOSE_PAREN ;

IDENTIFIER : (LOWERCASE | UPPERCASE | '_')+ ;

WHITESPACE : (' ' | '\t') ;

NEWLINE : ('\r'? '\n')+ ;