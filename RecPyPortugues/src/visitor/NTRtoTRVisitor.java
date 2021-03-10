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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Este arquivo foi elaborado manualmente. 
   Os outros arquivos Java gerados a partir do Lexer e do Parser foram gerados automaticamente 
   pelo ANTLR4 a partir da gramatica elaborada */

/* Classe de visita à árvore de tradução de função recursiva não caudal
 * (non tail recursive) para recursiva caudal (tail recursive)*/
public class NTRtoTRVisitor extends RecPyParserBaseVisitor<Object> {

    //private Stack<Scope> scopes;
	/** "memory": variable/value string pairs go here */
    private Map<String, String> memory = new HashMap<String, String>();
    
    private int nivelIdentacao=0; 
    
    private static String result="";
    
    private String operador="";

	private String operadorEsq="";

	private String operadorDir="";
	
	private String nameDef="";
    
    public NTRtoTRVisitor()  {    	
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
    	String newNameDef="";
    	boolean sucess=false;
   		try{	
   			nameDef=getNameCall(txtEntrada);
   			if (nameDef.equals("main")) {
   				//Função main:
   				result=txtEntrada;
   			} else {
	   			if (isExpectedTailRecursion(txtEntrada)) {
		   			System.out.println("Bloco Def:\n>>>\n"+txtEntrada+"<<<\n---");
		   			CharStream stream = CharStreams.fromString(txtEntrada);
		   			RecPyLexer lexer = new RecPyLexer(stream);
		   			lexer.setTipoTraduc(RecPyLexer.TipoTrad.NON_TAIL_RECURSIVE);
					CommonTokenStream cts = new CommonTokenStream(lexer);
								
					//*******************
					RecPyParser parser = new RecPyParser(cts);
					parser.setBuildParseTree(true);
					parser.setTipoTraduc(RecPyParser.TipoTrad.NON_TAIL_RECURSIVE);
					ParseTree tree = parser.start();
					System.out.println("Árvore sintática abstrata (AST):\n"+tree.toStringTree(parser)+"\n---\n");
											
					this.visit(tree);	
					sucess=true;
					
	   			} else {   				
	   				throw(new Exception("Erro! A funcao '"+nameDef+"' nao eh recursiva ou nao apresenta o padrao em estudo!\n"));   				
	   			}
   			}
   		} 
		catch (Exception e ) {
			result=txtEntrada;
			System.out.println(e.getMessage());
            //e.printStackTrace();
        }
   		if (sucess==true) {
   			newNameDef=nameDef.replace("NTR", "TR");
   			result=result.replace(nameDef, newNameDef);
   		}
   		return result;      
    } 
	/* Faz uma verificação prévia se o modelo de função se enquadra
	 * como convertível  */
    private boolean isExpectedTailRecursion(String txtEntrada) {
		String[] lines=txtEntrada.split("(?<=\r\n)");
		String nameCall1="";
		String params1=null;
		String params2=null;
		boolean hasIf=false;
		try{
			for (int i=0;i<lines.length; i++) {
				if (i==0) {
					nameCall1=getNameCall(lines[i]);
					if (nameCall1.contains("main")) {
						return false;
					}
					params1=getParams(lines[i], nameCall1, "def");
				} else {
					if (lines[i].contains("if") && hasIf==false) {
						hasIf=true;
					} else {
						// O modelo de função conversível só admite um IF (se houver mais de um, retorna false)
						if (lines[i].contains("if") && hasIf==true) return false;
					}					
					if (i==lines.length-1) {
						if (! hasTail(lines[i], nameCall1)) return false;
						if (! lines[i].contains(nameCall1)) return false;
						if (nameCall1!="") {
							params2=getParams(lines[i], nameCall1,"return");
						}
					}		
				}
			}
			if (isParamsOk(params1,params2) && hasIf) {
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
	private boolean hasTail(String string, String defName) {
		if (isLeftOperator(string,defName) || isRightOperator(string,defName)) {
			return true;
		}
		return false;
	}
		
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
	
	/* Obtem os parâmetros que vem apos o nome da funcao 
	 * Retorna uma lista de strings*/
	private String getParams(String line, String nameCall1, String tipo) {
		line=line.replace(":", "");	
		String[] partes=null;
		try {
			partes=line.split(nameCall1,2);
			if (isLeftOperator(line, nameCall1) || tipo.equals("def")) {
				return partes[1];
			} 
			if (isRightOperator(line, nameCall1)) {
				partes=partes[1].split("\\"+operadorDir,2);
				return partes[0];
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
		return null;
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
	/* Obtem o nome da funcao que esta sendo traduzida */
	private String getNameCall(String text){
    	String retorno="";
    	String regex="";
    	boolean found=false;
    	regex="(\\w+)(\\S?)(\\()(.*?)(\\))";
    	try {
	    	Pattern patt=Pattern.compile(regex);    	
	    	Matcher matcher=patt.matcher(text);
	    	found=matcher.find();
	    	retorno=matcher.group(1);
	    	if (found) {
	    		return retorno;
	    	} else {
	    		return "";
	    	}
    	} catch (Exception e) {
            e.printStackTrace();
        }
    	return "";
    }
	/* Verifica se a operação ocorre à esquerda e à direita do nome da função 
     * (ou, false se não há operador nem à esquerda nem à direita) 
     */
	private boolean isLeftAndRightOperator(String text, String nameDef) {
    	if (text.trim().substring(0,3).equals("def")) return false;
    	boolean retorno=false;
    	String regex="";    	
    	regex="return.+?([\\+\\-\\*\\/\\%]{1}) *?"+nameDef+"\\(+.+?\\)+ *?([\\+\\-\\*\\/\\%]{1}) *?";
    	try {
    		Pattern patt=Pattern.compile(regex);
    		Matcher matcher=patt.matcher(text);
    		retorno=matcher.find();
    		//System.out.println(regex+"\n"+text);
    		if (retorno) {     			
    			operadorEsq=matcher.group(1);
    			operadorDir=matcher.group(2);
    			//System.out.println(matcher.group(0));
    			return(retorno);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return false;
	}
	    
    /* Verifica se a operação ocorre à esquerda do nome da função 
     * (ou, false se não há operador à esquerda) 
     */
    private boolean isLeftOperator(String text, String nameDef) {
    	if (text.trim().substring(0,3).equals("def")) return false;
    	boolean retorno=false;
    	String regex="";
    	regex="return.+?([\\+\\-\\*\\/\\%]{1}) *?"+nameDef;
    	try {
    		Pattern patt=Pattern.compile(regex);
    		Matcher matcher=patt.matcher(text);
    		retorno=matcher.find();
    		if (retorno) { 
    			operadorEsq=matcher.group(1);
    			//System.out.println(operadorEsq);
    			return(retorno);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return false;
    }
    
    /* Verifica se a operação ocorre à direita do nome da função 
     * (ou, false se não há operador à direita) 
     */
    private boolean isRightOperator(String text, String nameDef) {
    	boolean retorno=false;
    	String regex="";
    	regex=nameDef+"\\(.*\\) *?([\\+\\-\\*\\/\\%]{1})";
    	try {
	    	Pattern patt=Pattern.compile(regex);
	    	Matcher matcher=patt.matcher(text);
	    	retorno=matcher.find();
	    	if (retorno) {
	    		operadorDir=matcher.group(1);
	    		//System.out.println(operadorDir);
	    		return(retorno);
	    	}
	    } catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
			
	private int getPosCloseParent(int posInicio, String txt) {
		int contaNivel=0;
		int retorno=-1;
		String caract="";
		for (int i=posInicio; i< txt.length(); i++) {
			caract=""+txt.charAt(i);
			if (caract.equals("(")) contaNivel++;
			if (caract.equals(")")) {
				contaNivel--;
				if (contaNivel==0) {
					retorno=i;
					break;
				}
			}
		}
		return retorno;
	}
    /* Obtem o argumento externo à funcao, juntamente com o 
     * operador respectivo 
     * Retorna uma string - exemplo:  "n +" ou "+ n" ou "n *" etc  */
	private String getArgument(String text, String nameCall, String direcao){
	    String retornoEsq="";
	    String retornoDir="";
	    String retorno=text.replace("return ","");        
	    /* Se o operador está à esquerda */
        if (direcao=="left"){
        	retornoEsq=retorno.split(nameCall,2)[0].trim();
            return retornoEsq;    
        } else {
        	retornoDir=text;
        	int posInicio=0;
            int posClose=getPosCloseParent(posInicio,retornoDir);
            if (posClose>-1){
                retornoDir=retornoDir.substring(posClose+1, retornoDir.length());
            } else {
                retornoDir=">>>  ERRO!!!!! (nao encontrou parentesis de fechamento) <<<";
            }
            return retornoDir;
        }
    }
    private String makeTailCall(String text, String nameDef){
        String retorno="";
        if (! hasTail(text, nameDef)){
            return "";
        }
        //String nameCall=getNameCall(text);
        String[] partesRetrn=text.split("(?<="+nameDef+")",2);
        String arg="";
        String argEsq="";
        String argDir="";
        if (isLeftAndRightOperator(text, nameDef)){
        	argEsq=getArgument(partesRetrn[0],nameDef,"left");
        	int posFirstParents=text.indexOf(nameDef)+nameDef.length();
            int posCloseParents=getPosCloseParent(posFirstParents, text);
            retorno=text.substring(0,posCloseParents);            
        	retorno=retorno.replace(argEsq,"");
        	//Troca dois espaços intermediarios por apenas um:
        	retorno=retorno.replaceFirst("(?<a1>return)  (?<a2>.)", "${a1} ${a2}");
            argEsq=argEsq.replace("\r\n",")");
            argEsq=onlyAlphabetic(argEsq) +" "+ operadorEsq;
            argEsq=", "+argEsq+" <<acc>>";  
            retorno=retorno+argEsq;
            String[] partes2=partesRetrn[1].split(operadorDir);
            argDir=partes2[1];
        	argDir=argDir.replace("\r\n","");
        	argDir=argDir+")";
        	retorno=retorno.replace("<<acc>>", " acc "+operadorDir+" "+argDir);
        } else if (isLeftOperator(text, nameDef)){
            argEsq=getArgument(partesRetrn[0],nameDef,"left");
            partesRetrn[0]=partesRetrn[0].replace(argEsq,"");
            argEsq=argEsq.replace("\r\n","");            
            if (operadorEsq.equals("+")) {
            	argEsq=replaceLast(argEsq, "+", "");
            	argEsq=", acc + "+argEsq+")";
            } else {
            	argEsq=", "+argEsq+" acc)";
            }
            partesRetrn[1]=replaceLast(partesRetrn[1],")", argEsq);
            retorno=partesRetrn[0]+partesRetrn[1];
            //retorno=retorno.replace("\\\\r\\\\n", "\\r\\n");
            //retorno=retorno.replace("\r\n","");
        } else if (isRightOperator(text, nameDef)) {
            argDir=getArgument(partesRetrn[1],nameDef,"right");
            partesRetrn[1]=partesRetrn[1].replace(argDir,"");
            argDir=argDir.replace("\r\n","");            
            if (operadorDir.equals("+")) {
            	argDir=argDir.replaceFirst("\\+","");
            	argDir=","+argDir+"+ acc )";
            } else {
            	argDir=argDir+")";
            	argDir=", acc "+argDir;
            }
            partesRetrn[1]=replaceLast(partesRetrn[1],")", argDir);
            retorno=partesRetrn[0]+partesRetrn[1];
            //retorno=retorno.replace("\\\\r\\\\n", "\\r\\n");
            //retorno=retorno.replace("\r\n","");
        }
        return retorno; 
    }			
	
    /* Substitui a ultima substring na string */
	private static String replaceLast(String txt, String search, String replacement) {
		String retorno=txt;
		int tamStr=txt.length();
		int tamSearch=search.length();
	    for (int i=tamStr-1; i>=0; i--) {
	    	if (txt.charAt(i)==search.charAt(0)) {
	    		for (int j=0; j<tamSearch && (i+j) < tamStr; j++) {
	    			if (j==tamSearch-1) {
		    			return txt.substring(0,i)+replacement+txt.substring(i+tamSearch, tamStr);
		    		}
	    		}	    		
	    	}
	    }
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
	/* Retorna somente a parte alfabética da string de entrada */
	private String onlyAlphabetic(String string) {
		String retorno="";
		string=string.replace(" ","");
		string=string.replaceFirst("\\(","");
		string=replaceLast(string,"\\)","");		
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
	
	/* ---------------------- VISITAS ----------------- 
	 * ------------------------------------------------*/

	/**
	 * Visit a parse tree produced by {@link RecPyParser#def_expr}.
	 * @param ctx the parse tree
	 * @return null
	 */
	@Override
	public Object visitDef_blk(RecPyParser.Def_blkContext ctx) {
		/* String da primeira linha da funcao */
		String strDef="";		
		/* SubString de espaços e tabs que vem no inicio da primeira linha */
		String strInitialOffset="";
		
		try {
			memory.clear();
			nivelIdentacao=0;
			System.out.println("#Funcao recursiva caudal resultante da transformacao: \r\n");
						
			strDef=ctx.getText();
			strInitialOffset=getInitialOffset(strDef);	
			
			strDef=strDef.replaceFirst("\\) *\\:" , ", acc=<<strRetValue>>):");
			result+=strDef;			
			nivelIdentacao++;
		
			if (memory.containsKey("strInitialOffset")){
				memory.remove("strInitialOffset");
			} 
			memory.put("strInitialOffset", strInitialOffset);			
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null; 
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
			strIf=repeatSpaces(nivelIdentacao*4)+leftTrim(ctx.getText());
			
			strInitialOffset=memory.get("strInitialOffset");
			//strIf=memory.get("strIf");			
			result+=strInitialOffset+strIf;
			nivelIdentacao++;			
			
			/* Linha do if que vira while not */
			if (memory.containsKey("strIf")){
				memory.remove("strIf");
			} 
			memory.put("strIf", strIf);
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
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
		String strRetValue="";	
		String strDef="";
		String strInitialOffset="";
		String strIf="";
		try {
			strInitialOffset= memory.get("strInitialOffset");
			strReturn1=ctx.getText().trim();		
						
			strRetValue=strReturn1.replace("return ", "");
			strRetValue=strRetValue.replace("\r\n","");
			strRetValue=strRetValue.trim();

			result=result.replaceFirst("<<strRetValue>>", strRetValue);			
			
			//strReturn1=replaceLast(strReturn1, strRetValue, "acc");
			
			//strReturn1=strReturn1.replace("return ", "return acc");
			strReturn1="return acc\n";
					
			result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+strReturn1;
			nivelIdentacao--;
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */	 
		
	@Override
	public Object visitReturn_ntr( RecPyParser.Return_ntrContext ctx)
	{			
		String strReturn2="";
		String strInitialOffset="";
		try {		
			strInitialOffset=memory.get("strInitialOffset");
			strReturn2 =ctx.getText().trim();
			strReturn2 = makeTailCall(strReturn2, nameDef);
						
			result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
					strReturn2+"\r\n";
			nivelIdentacao--;
			
		} catch (Exception e) {
            e.printStackTrace();
        }			
		return visitChildren(ctx); 
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
			result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
					leftTrim(strIntrm);
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;		
	}	

	public static void main(String[] args) throws Exception {		
		
    }
}