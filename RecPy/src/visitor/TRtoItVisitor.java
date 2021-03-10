/*
 * Author: Roberto Carlos dos Santos
 * Completion of Course Work  (in portuguese: TCC - Trabalho de Conclusao de Curso)   
 * Advisor: Prof. Dsc. Fabiano de Souza Oliveira (Ciencias da Computaçao - UERJ)   	 
 */

package visitor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import lexrParsr.RecPyLexer;
import lexrParsr.RecPyParser;
import lexrParsr.RecPyParserBaseVisitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Este arquivo foi elaborado manualmente. 
   Os outros arquivos Java gerados a partir do Lexer e do Parser foram gerados automaticamente 
   pelo ANTLR4 a partir da gramatica elaborada */

/* Classe de visita à árvore de tradução de função recursiva caudal para 
 * iterativa*/
public class TRtoItVisitor extends RecPyParserBaseVisitor<Object> {
	enum TipoTrad {
			TAIL_RECURSIVE,
			NON_TAIL_RECURSIVE,
			ITERATIVE
		}

    //private Stack<Scope> scopes;
	/** "memory": variable/value string pairs go here */
    private Map<String, String> memory = new HashMap<String, String>();
    
    private int nivelIdentacao=0;

	private String strCodsIntermds="";

	private boolean primeiraPassagem=true; 
    
    private static String result="";
    
    public TRtoItVisitor()  {    	
   		try {
   			result="";	
   			//System.out.println("Passou pelo inicializador");
   		} finally {
   			System.out.println(result);
   		}
    }

    //@SuppressWarnings("deprecation")
	public String runVisitor(String txtEntrada) throws Exception {
    	
    	result="";
    	int qtdLinhasTxtEntr=0;
    	String newNameDef="";
    	String nameDef="";
    	boolean sucess=false;
   		try{   		
   			nameDef=getNameCall(txtEntrada, "def");
   			if (nameDef.equals("main")) {
   				//Função main (não converte. Retorna o texto de entrada)
   				result=txtEntrada;	
   			} else {
	   			if (isExpectedTailRecursion(txtEntrada)) { 			
	   				primeiraPassagem=true; 
	   				System.out.println("Bloco Def:\n>>>\n"+txtEntrada+"<<<\n---");
		   			CharStream stream = CharStreams.fromString(txtEntrada);
		   			RecPyLexer lexer = new RecPyLexer(stream);
		   			lexer.setTipoTraduc(RecPyLexer.TipoTrad.TAIL_RECURSIVE);
					CommonTokenStream cts = new CommonTokenStream(lexer);							
								
					RecPyParser parser = new RecPyParser(cts);
					parser.setBuildParseTree(true);
					parser.setTipoTraduc(RecPyParser.TipoTrad.TAIL_RECURSIVE);	
					
					/* Primeira passagem pega somente os códigos 
					 * que não fazem parte essencial da função
					 * (comentários e outros)*/
					ParseTree tree = parser.start();																	
					this.visit(tree);
					strCodsIntermds=result;
					primeiraPassagem=false;
					result="";
					parser.reset();					
					tree = parser.start();
					System.out.println("Árvore sintática abstrata (AST):\n"+tree.toStringTree(parser)+"\n---\n");
					this.visit(tree);	
					sucess=true;

	   			} else {   				
	   				throw(new Exception("Erro! A funcao '"+nameDef+"' nao eh recursiva ou nao apresenta o padrao em estudo!\n"));
	   			}
   			}
		}   		
   		catch (Exception e) {			
			result=txtEntrada;
			System.out.println(e.getMessage());
            //e.printStackTrace();
        }
   		if (sucess==true) {
   			newNameDef=nameDef.replaceAll("(?<!N)TR", "IT");
   			result=result.replace(nameDef, newNameDef);
   		}
   		return result;      
    } 
	/* Verifica previamente se o modelo é de função conversível */
    private boolean isExpectedTailRecursion(String txtEntrada) {
		String[] lines=txtEntrada.split("\r?\n");
		String nameCall1="";
		String params1=null;
		String params2=null;
		boolean hasIf=false;
		try{
			for (int i=0;i<lines.length; i++) {
				if (i==0) {
					nameCall1=getNameCall(lines[i],"def");
					if (nameCall1.contains("main")) {
						return false;
					}
					params1=getParams(lines[i], nameCall1);
				} else {
					if (lines[i].contains("if") && hasIf==false && ! lines[i].contains("#")) {
						hasIf=true;
					} else {
						// O modelo de função conversível só admite um IF (se houver mais de um, retorna false)
						if (lines[i].contains("if") && hasIf==true) return false;
					}
					if (i==lines.length-1) {
						if (! lines[i].contains(nameCall1)) return false;
						if (nameCall1!="") {
							params2=getParams(lines[i], nameCall1);
						}
					}
				}
			}
			if (isParamsOk(params1,params2) && hasIf ) {
				return true;
			}
			else {
				return false;
			}		
	    } catch (Exception e) {			
	        e.printStackTrace();
	    }
		return false;
    }
    
    /* Obtem o número de linhas representadas em uma longa string */
	private int getQtdLnsTxt(String txt) {
		int qtdLinhas=0;
		int tamStr=txt.length();
		char alimLinha=0;
		//Determina qual o caracter a contar os números de linha,
		//a depender do padrão usado (CRLF, CR ou LF)
		for (int i=0; i<tamStr;i++) {
			if (txt.charAt(i)=='\r') {
				alimLinha='\r';
				break;
			} else {
				alimLinha='\n';
				break;
			}
		}
		for (int i=0; i<tamStr;i++) {
			if (txt.charAt(i)==alimLinha) {
				qtdLinhas++;
			}
		}
		return qtdLinhas;
	}
	
	/* Verifica se a ordem dos parâmetros é a correta */
	private boolean isParamsOk(String params1, String params2) {
		String[] args1=getSetArgs(params1);
		String[] args2=getSetArgs(params2);
		boolean retorno=false;
		for (int i=0;i<args1.length; i++) {
			retorno = false;
			for (int j=0; j<args2.length; j++) {
				if (args2[j].equals(args1[i])) 
				    {
					retorno=true;
					break;
				}
			}
			if (retorno==false) return false;
		}
		return retorno;
	}
	/* Obtem tokens alfanumericos contidos em uma string. 
	 * Esta funcao é utilizada na função getSetArgs() */
	private static String[] getArgsIndivds(String txt) {
		String regex="";
    	regex="(\\W)+?";  //Separa tokens alfanumericos
    	String[] retorno;
    	try {
    		retorno=txt.split(regex);    		
    		if (retorno.length>0) {
    			return retorno;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}
	/* Obtem um conjunto de argumentos (sem repetições, portanto) alfanuméricos
	 * contidos em uma string (exemplo: "(a1+1,b,c1)" retorna {a1,b,c1} ) */
	private static String[] getSetArgs(String txt) {
		String[] args=getArgsIndivds(txt);
		Set<String> conjunto = new HashSet<String>(Arrays.asList(args));
		int contaDigitos=0;
		for (String string : conjunto) {
			if (!string.isEmpty()) {
				Character carInicial=string.charAt(0);
				if (! (Character.isDigit(carInicial))) {
					contaDigitos++;
				}
			}
		}
		String[] retorno=new String[contaDigitos];
		int i=0;
		for (String string : conjunto) {
			if (!string.isEmpty()) {
				Character carInicial=string.charAt(0);
				if (! (Character.isDigit(carInicial))) {
					retorno[i]=string;
					i++;
				}		
			}
		}	
		return retorno;
	}
	/* Retorna somente a parte alfabética da string de entrada */
	private String onlyAlphabetic(String string) {
		String retorno="";
		string=string.replace(" ","");
		string=string.replace("(","");
		string=string.replace(")","");		
		for (int i=0; i<string.length(); i++) {
			char carct=string.charAt(i);
			if ("=!@#$%&*-+*/:?<>.|".indexOf(carct)>-1){
				break;
			} else {
				retorno+=carct;
			}					
		}
		return retorno;
	}

	/* Obtém os parâmetros separadamente (em lista) */
	private String getParams(String line, String nameCall1) {
		//line=line.replace("(", "");
		//line=line.replace(")", "");	
		line=line.replace(":", "");	
		line=line.replace(" ", "");	
		/* Divide em duas partes, tendo como delimitador o nome da 
		 * funcao */
		String[] partes=line.split(nameCall1,2);
		return partes[1];
	}

	/* Obtem o nome da funcao que esta sendo traduzida */
    private String getNameCall(String strParam, String idLine){
		String[] names1=null;
		String[] names2=null;
		try {			
			if ((idLine.equals("def") && strParam.contains("def")) ||
				(idLine.equals("return") && strParam.contains("return"))) {
				names1=strParam.split(idLine,2);
				names1[1]=names1[1].replace(" ","");
				names2=names1[1].split("\\(",2);
				return names2[0];
			}
			else {
				return "";
			}
	
		} catch (Exception e) {
            e.printStackTrace();
        }
		return "";		
	}
	/**
	* Em uma string com parentesis, retorna apenas a substring daquilo que está dentro 
	* dos parêntesis mais externos. 
	* */
	private String cutParnths(String strParam){
		String retorno="";
		int posFinal=strParam.length()-1;
		int posInicial=0;
		try {				
			for (int i=posFinal; i>0; i--){
				Character cChar=strParam.charAt(i);			
				if (cChar.equals(')')){
					posFinal=i;
					break;
				}
			}	
			for (int i=posInicial; i<=posFinal; i++){
				Character cChar=strParam.charAt(i);			
				if (cChar.equals('(')){
					posInicial=i+1;
					break;
				}
			}
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		retorno=strParam.substring(posInicial,posFinal);
		return retorno;
	}
	
	/* Obtem a substring de inicio da primeira linha (serve para manter o
	 * mesmo afastamento nas outras linhas
	 * Formada por espaços e tabs) */
	private String getInitialOffset(String strDef) {
		String retorno="";
		String strChar="";
		for (int i=0; i<strDef.length();i++) {
			strChar=""+strDef.charAt(i);
			if (strChar.equals(" ") || strChar.equals("\t")) {
				retorno+=strChar;
			} else {
				break;
			}
		}
		return retorno;
	}
	private static String leftTrim(String txt) {
		int tam=txt.length();
		for (int i=0; i<tam;i++) {
			if (txt.charAt(i)!=' ') {
				txt=txt.substring(i);
				break;
			}
		}
		return txt;
	}
	private static String repeatSpaces(int n) {
		return new String(new char[n]).replace("\0", " ");
	}
	
	/* ***************** VISITAS *************/
		
	/**
	 * Visit a parse tree produced by {@link RecPyParser#def_expr}.
	 * @param ctx the parse tree
	 * @return null
	 */
	@Override 
	public Object visitDef_blk(RecPyParser.Def_blkContext ctx) {
		/* String da primeira linha da funcao */
		String strDef="";
		/* String dos argumentos da funcao (da primeira linha)*/
		String strParamtrs1 ="";
		/* Nome da funcao (da primeira linha)*/
		String strNameDef="";
		/* Utilizada para split */
		String[] strTemp=null;
		/* SubString de espaços e tabs que vem no inicio da primeira linha */
		String strInitialOffset="";
		
		try {
			memory.clear();			
			strInitialOffset=getInitialOffset(strDef);
			if (memory.containsKey("strInitialOffset")){
				memory.remove("strInitialOffset");
			} 
			memory.put("strInitialOffset", strInitialOffset);
			if (primeiraPassagem==true) return super.visitChildren(ctx);
			System.out.println("#Funcao iterativa resultante da transformacao: \r\n");
			nivelIdentacao=0;			
			strDef=	ctx.getChild(0).getText();	
			/* Primeira linha da funçao traduzida */
			result+=strDef;		
			nivelIdentacao++;
			strNameDef=getNameCall(strDef,"def");
		    strTemp=strDef.split(strNameDef,2);
			strParamtrs1 = strTemp[1];
			strParamtrs1 = cutParnths(strParamtrs1);
			strParamtrs1 = onlyAlphabetic(strParamtrs1);
			
			if (memory.containsKey("strParamtrs1")){
				memory.remove("strParamtrs1");
			} 
			memory.put("strParamtrs1", strParamtrs1);
			
			if (memory.containsKey("strNameDef")){
				memory.remove("strNameDef");
			} 
			memory.put("strNameDef", strNameDef);						
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return super.visitChildren(ctx);
	}
	
	/**
	 * Visit a parse tree produced by {@link RecPyParser#if_expr}.
	 * @param ctx the parse tree
	 * @return null
	 */
	@Override 
	public Object visitIf_expr(RecPyParser.If_exprContext ctx) {
		/* String do if da funcao original (vira while not na
		 * funcao traduzida) */
		String strIf="";
		String strInitialOffset="";
		try {
			if (primeiraPassagem==true) return super.visitChildren(ctx);
			strIf=ctx.getText();
			//strIf=ctx.getText();
			strIf=strIf.split("if")[1];
			strIf=strIf.trim()+"\r\n";
			strIf=repeatSpaces(nivelIdentacao*4)+"while not "+strIf;
			strInitialOffset=memory.get("strInitialOffset");
			/* Linha do if que vira while not */
			result+=strInitialOffset+strIf;
			nivelIdentacao++;
			if (strCodsIntermds.length()>0) {				
				result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+leftTrim(strCodsIntermds);
			}
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return super.visitChildren(ctx);
	}
	
	/**
	 * Visit a parse tree produced by {@link RecPyParser#return_expr}.
	 * @param ctx the parse tree
	 * @return null
	 */
	@Override 
	public Object visitReturn_expr(RecPyParser.Return_exprContext ctx) {
				
		/* A linha do primeiro return (a deste nó) */
		String strReturn1="";		
		try {			
			if (primeiraPassagem==true) return super.visitChildren(ctx);
			
			strReturn1=ctx.getText().trim();
			
			if (memory.containsKey("strReturn1")){
				memory.remove("strReturn1");
			} 
			memory.put("strReturn1", strReturn1);
					
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return super.visitChildren(ctx);
	}
	
	/**
	 * Visit a parse tree produced by {@link RecPyParser#return_tr}.
	 * @param ctx the parse tree
	 * @return null
	 */
	@Override 
	public Object visitReturn_tr( RecPyParser.Return_trContext ctx)
	{							
		/* Ultima linha da funcao ja traduzida (é igual à primeira
		 * linha de return na funçao original) */
		String strReturn1="";
		/* A string do nó atual, que é a última linha da funcao
		 * original  */
		String strReturn2="";
		/* SubString de espaços e tabs que vem no inicio da primeira linha */
		String strInitialOffset="";
		/* Nome da função (obtido na ultima linha da funcao - neste nó) */
		String strNameDef2="";		
		/* Parametros da primeira linha */
		String strParamtrs1 = "";
		/* Parametros da linha do primeiro return (linha deste nó) */
		String strParamtrs2 = "";		
		/* A linha traduzida na forma: parametros1 = parametros2 */
		String strParametros="";

		try {					
			if (primeiraPassagem==true) return super.visitChildren(ctx);
			
			strInitialOffset=memory.get("strInitialOffset");
				
			/* Última linha da função traduzida (é igual
			 * à linha do primeiro return */
			strReturn1=memory.get("strReturn1");
			
			/* Obtem a última linha da funcao original */
			strReturn2=ctx.getText().trim();
			
			strNameDef2=getNameCall(strReturn2, "return");
			
			strParamtrs1=memory.get("strParamtrs1");	        						
			
			/* Divide strReturn2 em duas partes, tendo como delimitador
			 * o nome da função */
			strParamtrs2 = strReturn2.split(strNameDef2,2)[1];
			
			strParamtrs2 = cutParnths(strParamtrs2);
			
			/* String do Else desaparece e, em seu lugar, entram os 
			 * parametros1 = parametros2 */			
	        strParametros = repeatSpaces(nivelIdentacao*4)+ 
	        		strParamtrs1.trim() +" = "+strParamtrs2;		
			
	        result+=strInitialOffset+strParametros+"\n";	
	        nivelIdentacao--;
			
			strReturn1=repeatSpaces(nivelIdentacao*4)+strReturn1.trim();			
			result+=strInitialOffset+strReturn1+"\n";
			nivelIdentacao--;
			
		} catch (Exception e) {
            e.printStackTrace();
        }		
			
		return super.visitChildren(ctx); 
	}			
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 * Visita nós que não fazem parte da funcao estritamente, 
	 * como prints e comments
	 */	 	
	@Override
	public Object visitInterm(RecPyParser.IntermContext ctx) 
	{ 
		String strIntrm="";
		String strInitialOffset="";
		try {
			strInitialOffset=memory.get("strInitialOffset");
			strIntrm=ctx.getChild(0).getText();	
			if (primeiraPassagem==false && strIntrm.contains("#")){
				result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
					leftTrim(strIntrm);
			} else {
				if (primeiraPassagem==true && !strIntrm.contains("#")){
					nivelIdentacao=2;
					result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
							leftTrim(strIntrm);

				}				
			}
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;		
	}
					
	//*******************************

	public static void main(String[] args) throws Exception {		
		
    }
}