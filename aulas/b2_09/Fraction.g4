grammar Fraction;

program: (instrutions? ';' )* EOF;

instrutions:   print            
            | assignment       
            ;

print: 'print' expr;
assignment: expr '->' ID;



expr: op=('-'|'+') expr             #unaryExpr
    | 'reduce' expr             #reduceExpr
    | '(' expr  ')' '^' expr                 #powExpr
    |'(' expr ')'                   #parentExpr
    | expr op=('*'|':') expr        #mulExpr
    | expr op=('-'|'+') expr        #addExpr 
    |LITERAL                       #literalExpr
    |ID                             #idExpr
    ;

LITERAL: NUM ('/' NUM)?;
NUM: [0-9]+;
ID: [a-zA-Z]+;

WS: [ \t\n\r]+ -> skip;
COMMENT: '//' .*? '\n'-> skip;