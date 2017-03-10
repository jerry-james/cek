grammar Sexp;

sexps : sexp* EOF;

sexp : vardefn | fundefn | atom | list ;

// this grammar has an error, its obviously incorrect to allow a vardefn or fundefn form in the body of a vardefn
vardefn : '(' 'define' SYMBOL sexp ')';
fundefn : '(' 'define' '(' fundefnsymbol SYMBOL* ')' sexp* ')';

fundefnsymbol : SYMBOL;

list : '(' sexp* ')';

atom : STRING | SYMBOL | NUMBER ;

STRING       : '"' ('\\' . | ~ ('\\' | '"'))* '"'   ;
WHITESPACE   : (' ' | '\n' | '\t' | '\r') + -> skip   ;
NUMBER       : ('+' | '-')? (DIGIT) + ('.' (DIGIT) +)?   ;
SYMBOL       : SYMBOL_START (SYMBOL_START | DIGIT)*   ;
fragment SYMBOL_START : ('a' .. 'z') | ('A' .. 'Z') | '+' | '-' | '*' | '/' | '.'  ;

fragment DIGIT : ('0' .. '9')  ;
