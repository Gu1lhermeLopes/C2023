grammar Dimensions;

program: (instruction? ';' )* EOF;

instruction: dimension
            | unit
            | prefix
            ;

dimension: 'dimension' type=('real'|'integer') ID '[' ID (','ID)? ']'  #dimensionSi
            |'dimension' type=('real'|'integer') ID '=' ID (op=('/'|'*') ID)+ #dimensionDependant
            ;

prefix: 'prefix' type=('real'|'integer') ID '=' notacao;

unit: 'unit' classe=ID '[' ID (','ID)? ']' '=' REAL '*' newclass=ID;

notacao: '10'       #notacaodez
        |'1e'INT   #notacaocienfitica
        ;

INT: '-'?[0-9]+ ;
REAL: INT '.' INT? | '.' INT;
STRING: '"' (.|'\\"')*? '"'  ;
ID: [a-zA-Z]+;
NEWLINE: '\r'? '\n' -> skip; 
WS: [ \t\n\r]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;