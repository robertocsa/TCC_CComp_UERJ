 /*
    Author: Roberto Carlos dos Santos 
	Completion of Course Work  (in portuguese: TCC - Trabalho de Conclusao de Curso)
	Advisor: Prof. Dsc. Fabiano de Souza Oliveira (Ciências da Computação - UERJ)
 */
parser grammar RecPyParser;

options {tokenVocab=RecPyLexer;}

@header{
	// import javax.swing.JOptionPane;
	package lexrParsr;
}
@members{

	//public boolean isDef_LT(){
	//JOptionPane.showMessageDialog(null,"Debug: entrou na linha 17");
	//	return (_input.LT(1).getText().toUpperCase().equals("DEF")); 
	//}
	
	public enum TipoTrad {
		TAIL_RECURSIVE,
		NON_TAIL_RECURSIVE,
		ITERATIVE
	}
	// Antes de realizar testes na linha de comando (CMD), configurar a linha abaixo conforme o tipo de algoritmo a testar:
	// Fazer isso tanto no LEXER quanto no PARSER
	private TipoTrad tipoTraduc=TipoTrad.NON_TAIL_RECURSIVE;
	
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

/*
 * parser rules
 */

start: ( (defTailRecursive)|(defNonTailRecursive)|(defIterative) ) EOF; 

defTailRecursive: 
( {isTailRecursive()}? 
    (def_blk)
	(((if_expr)
	(interm)*?)
    (return_expr))
	((else_)*                  
	(interm)*?)
	((return_tr) 	
	(interm)*?)
	(empty_line)*
);

defNonTailRecursive: 
( {isNonTailRecursive()}? 
    (def_blk)
	(((if_expr)
	(interm)*?)
    (return_expr))
	((else_)*                  
	(interm)*?)
	((return_ntr)
	(interm)*?)
	(empty_line)*
);

defIterative: 
( {isIterative()}?
	(def_blk)	
	(start_while_blk)
	(end_while_blk)	
	(empty_line)*
);

def_blk: (DEF_BLK interm*);

start_while_blk: ( START_WHILE_BLK interm*);

end_while_blk:  (END_WHILE_BLK interm*);

if_expr: IF_EXPR;

else_: ELSE_;

return_expr: RETURN_EXPR;

return_tr: ( {isTailRecursive()}? RETURN_TR);

return_ntr: ({isNonTailRecursive()}? RETURN_NTR);

print: PRINT;

comment: COMMENT;

attribution: (ATTRIBUTION);

simpl_blk: SIMPL_BLK;

empty_line:EMPTY_LINE;

interm: INTERM; 

