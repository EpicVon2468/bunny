lexer grammar TestLexer;

fragment LOWERCASE : [a-z] ;
fragment UPPERCASE : [A-Z] ;
fragment DIGIT : [0-9] ;

NUMBER : DIGIT+ ([.,] DIGIT+)? ;

FUNCTION : 'fun' ;

IDENTIFIER : (LOWERCASE | UPPERCASE | '_')+ ;

WHITESPACE : (' ' | '\t') ;

NEWLINE : ('\r'? '\n')+ ;