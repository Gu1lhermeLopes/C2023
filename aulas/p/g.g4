grammar Fraction;

program: (instrutions? ';' )* EOF;

instrutions:   write            
            | assignment       
            ;

write: op=('write'|'writeln') expr;
init: ID  ID;
assignment: ID = expr;



read: ID'= read 'STRING;


read "Name: " >> names;


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