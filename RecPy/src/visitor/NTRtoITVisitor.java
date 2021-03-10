/*
 * Author: Roberto Carlos dos Santos
 * Completion of Course Work  (in portuguese: TCC - Trabalho de Conclusao de Curso)   
 * Advisor: Prof. Dsc. Fabiano de Souza Oliveira (Ciencias da Computaçao - UERJ)   	 
 */

package visitor;

import lexrParsr.RecPyParserBaseVisitor;

import java.util.HashMap;
import java.util.Map;

/* Este arquivo foi elaborado manualmente. 
   Os outros arquivos Java gerados a partir do Lexer e do Parser foram gerados automaticamente 
   pelo ANTLR4 a partir da gramatica elaborada */

/* Classe de visita à árvore de tradução de função recursiva não caudal 
 * (non tail recursive) para função iterativa */
public class NTRtoITVisitor extends RecPyParserBaseVisitor<Object> {
   
    public static String result="";
    
    public NTRtoITVisitor()  {
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
    	String blocoTraduzidoNTR_TR="";
    	String blocoTraduzidoTR_IT="";
    	String nameDef="";
    	String newNameDef="";
    	boolean sucess=false;
   		try{	
   			nameDef=getNameCall(txtEntrada, "def");
   			if (nameDef.equals("main")) {
   				// Funcao main:
   				result=txtEntrada;
   			} else {   				  			
   			
	   			//Non Tail Recursive to tail recursive
	   			NTRtoTRVisitor visitorNTR_TR = new NTRtoTRVisitor();
	   			
	   			//Tail recursive to iterative
	   			TRtoItVisitor visitorTR_IT = new TRtoItVisitor();
	   			
	   			blocoTraduzidoNTR_TR=visitorNTR_TR.runVisitor(txtEntrada);	
	   			System.out.println("Bloco traduzido de NTR->TR>>>\n"+blocoTraduzidoNTR_TR+"<");
	   			
	   			blocoTraduzidoTR_IT=visitorTR_IT.runVisitor(blocoTraduzidoNTR_TR)+"\n";
	   			System.out.println("Bloco traduzido de TR->IT>>>\n"+blocoTraduzidoTR_IT+"<");   			
	   			
	   			result=blocoTraduzidoTR_IT;
	   			sucess=true;
   			}
   			
		} catch (Exception e) {
			result=txtEntrada;
            e.printStackTrace();
        }
   		if (sucess==true) {
   			newNameDef=nameDef.replace("NTR", "IT");
   			result=result.replace(nameDef, newNameDef);
   			result=cutFinalBlankLines(result)+"\r\n";
   		}
   		return result;      
    } 
	/* Retira do bloco de funcao a traduzir as linhas finais em branco */
	private String cutFinalBlankLines(String strEntDefBlock) {
		int tam=strEntDefBlock.length();
		int cont=0;
		for (int i=tam; i>0;i--) {
		    if (!(strEntDefBlock.charAt(i-1)=='\r'||strEntDefBlock.charAt(i-1)=='\n'||strEntDefBlock.charAt(i-1)=='\t'||strEntDefBlock.charAt(i-1)==' ')) {
				break;
			}
			cont++;
		}
		return strEntDefBlock.substring(0,tam-cont);
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
    	
	public static void main(String[] args) throws Exception {		
		
    }
}