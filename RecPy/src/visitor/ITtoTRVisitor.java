/*
 * Author: Roberto Carlos dos Santos
 * Completion of Course Work  (in portuguese: TCC - Trabalho de Conclusao de Curso)   
 * Advisor: Prof. Dsc. Fabiano de Souza Oliveira (Ciencias da Computaçao - UERJ)   	 
 */

package visitor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import lexrParsr.RecPyLexer;
import lexrParsr.RecPyParser;
import lexrParsr.RecPyParserBaseVisitor;

import java.util.HashMap;
import java.util.Map;

/* Este arquivo foi elaborado manualmente. 
   Os outros arquivos Java gerados a partir do Lexer e do Parser foram gerados automaticamente 
   pelo ANTLR4 a partir da gramatica elaborada */

/* Classe de visita à árvore de tradução de função iterativa para 
 * recursiva caudal (tail recursive)*/
public class ITtoTRVisitor extends RecPyParserBaseVisitor<Object> {

    //private Stack<Scope> scopes;
	/** "memory": variable/value string pairs go here */
    private Map<String, String> memory = new HashMap<String, String>();
    
    private int nivelIdentacao=0;

	private boolean primeiraPassagem=true; 
	
	private String strCodsIntermds="";
    
    private static String result="";
    
    public ITtoTRVisitor()  {    	
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
    	String nameDef="";
    	String newNameDef="";
    	int numLnsTxtEntrada=0;   
    	boolean sucess=false;
   		try{	
   			nameDef=getNameCall(txtEntrada, "def");
   			if (nameDef.equals("main")) {
   				// Funcao main:
   				result=txtEntrada;
   			} else {
	   			if (isExpectedFunction(txtEntrada)) {	
	   				primeiraPassagem=true; 
	   				System.out.println("Bloco Def:\n>>>\n"+txtEntrada+"<<<\n---");		   
		   			CharStream stream = CharStreams.fromString(txtEntrada);
		   			RecPyLexer lexer = new RecPyLexer(stream);
		   			lexer.setTipoTraduc(RecPyLexer.TipoTrad.ITERATIVE);
					CommonTokenStream cts = new CommonTokenStream(lexer);				
					
					RecPyParser parser = new RecPyParser(cts);
					parser.setBuildParseTree(true);
					parser.setTipoTraduc(RecPyParser.TipoTrad.ITERATIVE);		
				
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
	   				throw(new Exception("Erro! A funcao: '"+nameDef+"' nao eh iterativa ou nao apresenta o padrao em estudo!\n"));
	   			}
   			} 
		} catch (Exception e) {
			result=txtEntrada;
			System.out.println(e.getMessage());
            //e.printStackTrace();
        }
   		if (sucess==true) {
   			newNameDef=nameDef.replace("IT", "TR");
   			result=result.replace(nameDef, newNameDef);
   		}
   		return result;      
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
	
	/* Verifica se a funcao recebida se conforma ao modelo de traducao */
    private boolean isExpectedFunction(String txtEntrada) {
		String[] lines=txtEntrada.split("\r?\n");
		String nameCall1="";
		String nameCall2="";
		String[] params1=null;
		String[] params2=null;
		boolean hasWhile=false;
		for (int i=0;i<lines.length; i++) {
			if (i==0) {
				nameCall1=getNameCall(lines[i],"def");
				if (nameCall1.contains("main")) {
					return false;
				}
				params1=getParams(lines[i], nameCall1);
			} else {
				if (nameCall2=="") {
					if (lines[i].contains("while")) hasWhile=true;
					if (i==lines.length-2) {
						if (! lines[i].contains("=")) {
							return false;
						} else {
							String reducedLastLine=
									lines[i].replace("return ","");
							reducedLastLine=onlyAlphabetic(reducedLastLine);
							params2=reducedLastLine.split(",");
						}
					}
					if (i==lines.length-1) {
						if (! lines[i].contains("return ")) {
							return false;				
						}
					}
				}		
			}
		}
		if (isParamsOrderOk(params1,params2) && hasWhile ) {
			return true;
		}
		else {
			return false;
		}
	}

    /* Verifica se o argumento acc ou equivalente foi encontrado em params1*/
	private boolean isParamsOrderOk(String[] params1, String[] params2) {
		for (int i=0;i<params1.length; i++) {
			if (params1[i].contains(onlyAlphabetic(params2[0]))) {
				return true;
			}
		}
		return false;
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
	/* Substitui a ultima substring na string */
	private String replaceLast(String string, String regex, String replacement) {
		String retorno="";
		retorno=invertString(string);
		replacement=invertString(replacement);
		retorno=retorno.replaceFirst(regex, replacement);
		retorno=invertString(retorno);
		return retorno;
	}
	 /* Inverte a string
     * Exemplo: "abc" vira "cba" */
	private String invertString(String string) {
		String retorno="";
		for (int i=string.length(); i>0 ;i--) {
			retorno+=string.charAt(i-1);
		}
		return retorno;
	}
	/* Obtém os parâmetros separadamente (em lista) */
	private String[] getParams(String line, String nameCall1) {
		//line=line.replace("(", "");
		//line=line.replace(")", "");	
		line=line.replace(":", "");	
		line=line.replace(" ", "");	
		/* Divide em duas partes, tendo como delimitador o nome da 
		 * funcao */
		String[] partes=line.split(nameCall1,2);
		return partes[1].split(",");
	}

	/* Obtem o nome da funcao que esta sendo traduzida */
    private String getNameCall(String strParam, String idLine){
		String[] names1=null;
		String[] names2=null;
		try {			
			if ((idLine.equals("def") && strParam.contains("def")) ||
				(idLine.equals("return") && strParam.contains("return"))) {
				names1=strParam.split(idLine);
				names1[1]=names1[1].replace(" ","");
				names2=names1[1].split("\\(");
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
	
	/***********************  VISITAS ***********************/
		
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
		/* SubString de espaços e tabs que vem no inicio da primeira linha */
		String strInitialOffset="";
		
		try {
			memory.clear();			
			nivelIdentacao=0;
			strDef=	ctx.getChild(0).getText();
			strNameDef=getNameCall(strDef,"def");			
			strInitialOffset=getInitialOffset(strDef);
			if (memory.containsKey("strInitialOffset")){
				memory.remove("strInitialOffset");
			} 
			memory.put("strInitialOffset", strInitialOffset);
			
			if (primeiraPassagem==true) return super.visitChildren(ctx);
			
			System.out.println("#Funcao iterativa resultante \n da transformacao da funcao:"+ strNameDef+" \r\n");
			result+=strDef;
			result+=strCodsIntermds;
			nivelIdentacao++;
			strParamtrs1 = onlyAlphabetic(getParams(strDef, strNameDef)[0]);
			if (memory.containsKey("Parmts1")){
				memory.remove("Parmts1");
			} else {
				memory.put("Parmts1", strParamtrs1);
			}	
			if (memory.containsKey("strNameDef")){
				memory.remove("strNameDef");
			} else {
				memory.put("strNameDef", strNameDef);
			}					
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return super.visitChildren(ctx);
	}
	/**
	 * Visit a parse tree produced by {@link RecPyParser#while_expr}.
	 * @param ctx the parse tree
	 * @return null
	 */
	@Override 
	public Object visitStart_while_blk(RecPyParser.Start_while_blkContext ctx) {
		if (primeiraPassagem==true) return super.visitChildren(ctx);
		/* String do if da funcao original (vira while not na
		 * funcao traduzida) */
		String strLine="";
		String strInitialOffset="";
		try {
			strInitialOffset=memory.get("strInitialOffset");
			strLine=ctx.getChild(0).getText();
			/* Linha do while (not) que vira if (not) */
			if (strLine.contains("while not ")) {
				strLine = strLine.replace("while not", "if");
			} else {
				if (strLine.contains("while ")){
					strLine= strLine.replace("while ", "if not");
				} else {
					throw new Exception("Erro: não foi encontrado o comando while!");
				}
			}
			
			result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
					strLine.trim()+"\n";
			nivelIdentacao++;
						
		} catch (Exception e) {
            e.printStackTrace();
        }
		return super.visitChildren(ctx);
	}
	/**
	 * Visit a parse tree produced by {@link RecPyParser#expr_parameters}.
	 * @param ctx the parse tree
	 * @return null
	 */
	@Override 
	public Object visitEnd_while_blk(RecPyParser.End_while_blkContext ctx) 
	{		
		if (primeiraPassagem==true) return super.visitChildren(ctx);
		/* Nome da função (obtido na ultima linha da funcao - neste nó) */
		String strNameDef="";		
		String strReturn1="";
		String strReturn2="";
		/* SubString de espaços e tabs que vem no inicio da primeira linha */
		String strInitialOffset="";
		try {						
					
			strNameDef=memory.containsKey("strNameDef")? 
					memory.get("strNameDef"):"";					
						
			strInitialOffset=memory.get("strInitialOffset");
			/* A linha do primeiro return (a deste nó) */
			strReturn1=ctx.getText().trim();	
			strReturn1="return"+strReturn1.split("return",2)[1];
			result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
					strReturn1+"\n";
			nivelIdentacao--;
			
			/* Obtem a ultima linha de retorno */
			strReturn2=ctx.getText();
			strReturn2=strReturn2.split("return",2)[0];
			strReturn2=strReturn2.split("\\=",2)[1];
			strReturn2=strReturn2.replace("\n", "");
			strReturn2=strReturn2.trim();
			if ((strReturn2.charAt(0)=='(') && 
					strReturn2.charAt(strReturn2.length()-1)==')') {
				strReturn2=strReturn2.substring(1,strReturn2.length()-2);
			}
					
			strReturn2="return "+strNameDef+"("+strReturn2+")";								
			
			result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
					strReturn2.trim()+"\n";
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
					nivelIdentacao=1;
					result+=strInitialOffset+repeatSpaces(nivelIdentacao*4)+
							leftTrim(strIntrm);
				}				
			}
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;		
	}
	
	public static void main(String[] args) throws Exception {		
		
    }
}