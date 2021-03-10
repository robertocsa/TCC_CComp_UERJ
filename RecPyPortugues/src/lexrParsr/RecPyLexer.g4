/*
    Author: Roberto Carlos dos Santos 
	Completion of Course Work  (in portuguese: TCC - Trabalho de Conclusao de Curso)
	Advisor: Prof. Dsc. Fabiano de Souza Oliveira (Ciencias da Computacao - UERJ)
 
*/

lexer grammar RecPyLexer;

/*
 * lexer rules
 */
 
@lexer::header { // place this header action only in lexer, not the parser
	package lexrParsr;
	import java.util.*; 
}

@lexer::members{

	public enum TipoTrad {
		TAIL_RECURSIVE,
		NON_TAIL_RECURSIVE,
		ITERATIVE
	}
	// Antes de realizar testes na linha de comando (CMD), configurar a linha abaixo conforme o tipo de algoritmo a testar:
	// Fazer isso tanto no LEXER quanto no PARSER
	private TipoTrad tipoTraduc=TipoTrad.NON_TAIL_RECURSIVE;
	
	private boolean firstReturn=true;
	
	private int contParentsis=0;
	
	private void setFirstReturn(boolean logico){
		firstReturn=logico;
	}
	
	// Check if is it the first line in which 'return' appears
	private boolean isFirstReturn(){
		return firstReturn==true;
	}
	
	private boolean isReturnTR(){
		if (isTailRecursive() && ! isFirstReturn()){			
			return true;
		} else {
			return false;
		}
	}
	private boolean isReturnNTR(){
		if (isNonTailRecursive() && ! isFirstReturn()){			
			return true;
		} else {
			return false;
		}
	}
	public void setTipoTraduc(TipoTrad tipoTrd_){
		tipoTraduc=tipoTrd_;
	}
	public boolean isTailRecursive(){
		return tipoTraduc==TipoTrad.TAIL_RECURSIVE;
	}
	public boolean isNonTailRecursive(){
		return tipoTraduc==TipoTrad.NON_TAIL_RECURSIVE;
	}
	public boolean isIterative(){
		return tipoTraduc==TipoTrad.ITERATIVE;
	}	
}

START_WHILE_BLK:(
   (WHILE_EXPR)
);

END_WHILE_BLK: (
   (ATTRIBUTION
   RETURN_EXPR)
);

LINE_ESCAPE
: '\\' '\r'? '\n' -> skip;

DEF_BLK: (DEF_EXPR);

DEF_EXPR: (DEF DEF_NAME ARGS FP* FINAL_COLON);

DEF: (WS* 'def' WS* { setFirstReturn( true );} )-> pushMode(M_DEF) ; 

IF_: (WS* 'if' WS*) -> pushMode(M_COND);

WHILE_: ( (WS* 'while' WS 'not' WS*)|(WS* 'while' WS*)) ->pushMode(M_COND);

IF_EXPR: (IF_ COND FINAL_COLON);

WHILE_EXPR: (WHILE_ COND FINAL_COLON);

ELSE_: ( WS* 'else' FINAL_COLON);

RETURN_EXPR: ( {isFirstReturn()}? ( WS* 'return' WS* (~'\n')+? NL ) { setFirstReturn(false);}) ; 

RETURN_NTR: ( 
			 ({isReturnNTR() }? WS* 'return' EXPR AP* DEF_NAME AP* ARGS FP* OP AP EXPR NL)| 
			 ({isReturnNTR() }? WS* 'return' EXPR AP* DEF_NAME AP* ARGS FP* NL) | 			 
			 ({isReturnNTR() }? WS* 'return' AP* DEF_NAME AP* ARGS FP* OP AP EXPR NL) 
			);			
			
RETURN_TR: ( {isReturnTR() }? (WS* 'return' WS* DEF_NAME ARGS FP* NL));

INTERM:(EMPTY_LINE | COMMENT | PRINT | SIMPL_BLK );

ATTRIBUTION: ( {isIterative()}? 
	((WS* PARAMETERS)(WS* ',' PARAMETERS)+) '=' ((WS* PARAMETERS)(WS* ',' PARAMETERS)+) NL? |
	((WS* PARAMETERS) '=' (WS* PARAMETERS)) NL? 
	); 

COMMENT  : 
	( WS* '#' ~[\r\n]*? '\r'? '\n'  NL*?
        |  [\u0027][\u0027][\u0027]  .*? [\u0027][\u0027][\u0027] NL*?  // ''''' .*? ''''' 
        | [\u0022][\u0022][\u0022]  .*? [\u0022][\u0022][\u0022] NL*? // '"""' .*? '"""'
        );   // -> channel(COMMENTS_CHNL);

PRINT: ( WS* 'print' WS* PRINT_BLK); // -> pushMode(M_PRINT);	

fragment
WS: ([ \t]+); // -> channel(WSPACES_CHNL);	

fragment
AP: (WS* '(' WS* | WS+);

fragment
FP: (WS* ')' WS* | WS+);

//Comparison operators:
fragment
COMPARISON: 'in' | '==' | '<'|'>'|'>='|'<='|'<>'|'!=';

//Algebric operators:
fragment
OP: '+'|'-'|'*'|'/'|'//'|'%'|'**'|'|'|'^'|'&'|'<<'|'>>'|'~'|'+='|'-='|'*='|'/='|'%='|'&='|'|='|'^='|'<<='|'>>='|'**='|'//='|':=';

fragment
NL: ('\r'?'\n');

fragment
PRINT_BLK: (
	(~('\r'|'\n'))+ NL
	);
	
PARAMETERS: 
	( { isIterative()}?
	( ~('='| '\r' | '\n')+)
	);

//{getCharPositionInLine() == 0}?
SIMPL_BLK: ( ~[\r\n]+ NL?);	

EMPTY_LINE: {super.getCharPositionInLine() == 0}? [ \t]* '\r'? '\n' ;

fragment
EXPR: (( WS* ('_' |' '|'(' | ')' | '[' | ']' | [A-Z] | [a-z]|[0-9])+ OP*)+);
// ->popMode;



/************************************

		MODES

*************************************/

mode M_COND;
PARAMET_COND: 
	( 
	( ~('='| '\r' | '\n')+)
	);

COND: ((AP* PARAMET_COND WS*) COMPARISON (WS* PARAMET_COND FP*))-> pushMode(M_FINAL_COLON);

mode M_DEF;
DEF_NAME: ( { _input.LA(1)!='\u0028'}? (('_' | '.' | [A-Z] | [a-z])([0-9])*)+ )-> pushMode(M_ARGS);

mode M_FINAL_COLON;
FINAL_COLON: (WS* ':' WS* NL*)->mode(DEFAULT_MODE);

mode M_ARGS;
ARGS: 
	(
	( (~('\r' | '\n'))+  ) {contParentsis=0;}
	) ->mode(DEFAULT_MODE);