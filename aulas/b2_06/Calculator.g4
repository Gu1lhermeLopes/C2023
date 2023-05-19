grammar Calculator;

program: (stat? NEWLINE)* EOF;

stat:   expr                #StatExpr
        | assignment        #StatAss
        ;

assignment: ID '=' expr;

expr: op=('-'|'+') expr           #ExprUnary
    | expr op=('*'|'%'|'/') expr   #ExprMultDivMod
    | expr op=('-'|'+') expr        #ExprAddSub
    |INTEGER                        #ExprInteger
    |ID                             #ExprID
    |'(' expr ')'                   #ExprParent
    ;
INTEGER: [0-9]+;
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n'-> skip;