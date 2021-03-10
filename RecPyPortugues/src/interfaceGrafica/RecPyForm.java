// Interface gráfica (janela principal) do pré-compilador RecPy
// TCC de Roberto Carlos dos Santos
// Prof. Fabiano de Souza Oliveira
// Curso de graduação em Ciências da Computação
// UERJ - 2020-1

package interfaceGrafica;

import javax.swing.*;

import visitor.TRtoItVisitor;
import visitor.NTRtoITVisitor;
import visitor.NTRtoTRVisitor;
import visitor.ITtoTRVisitor;

import java.nio.file.Files;
import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecPyForm 
	extends JFrame
	implements ActionListener
	{
	/**
	 * 
	 */
	private TRtoItVisitor rpVisitor0=null;
	private NTRtoTRVisitor rpVisitor1=null;
	private NTRtoITVisitor rpVisitor2=null;
	private ITtoTRVisitor rpVisitor3=null;
		
	private static final long serialVersionUID = 385962866588104561L;
	
	private Container c; 
	private JTextArea txtOrig;
	private JTextArea txtDest;
	private JButton btOpen;
	private JButton btRun;
	private JButton btSave;
	private JButton btCopy;
	private JButton btExit;
	private JButton btClear;
	private JLabel lbJanOrig;
	private JLabel lbJanDest;
	/* Botoes de selecao do tipo de traducao a realizar */
	private JRadioButton[] translations;
	private ButtonGroup translationsTypes;
	private JPanel jplTranslationType;
	private JPanel jplBotoes;
	private JPanel jplLabels;
	private JPanel jplTextOrig;
	private JPanel jplTextDest;

	private int posBlkDefNaLinha;
	
	private static File of;
	private static File sf;	
	
	private int qtdLinesTxtEntr;

	private boolean isBlockDef=false;
	
	public RecPyForm(){
		setTitle("RecPy: Pré-Compilador para a conversão de funções recursivas em Python");
		setBounds(20, 20, 1180, 680); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(new BorderLayout());     
        
        jplLabels=new JPanel(new BorderLayout());
              
        lbJanOrig = new JLabel(); 
        lbJanOrig.setFont(new Font("Arial", Font.PLAIN, 17)); 
        lbJanOrig.setSize(450, 25);        
        lbJanOrig.setText("O código da função recursiva caudal (TR) a traduzir:");
        jplLabels.add(lbJanOrig, BorderLayout.LINE_START);
        lbJanOrig.setLocation(5, 2); 
        
        lbJanDest = new JLabel(); 
        lbJanDest.setFont(new Font("Arial", Font.PLAIN, 17)); 
        lbJanDest.setSize(450, 25); 
        lbJanDest.setLocation(480, 2); 
        lbJanDest.setText("O código iterativo (IT) correspondente: "+ repeatStr(" ",58));
        jplLabels.add(lbJanDest, BorderLayout.LINE_END); 
        
        /* Áreas de Texto: */
        jplTextOrig=new JPanel(new BorderLayout());
        jplTextDest=new JPanel(new BorderLayout());
        //-----------------------------------------------                
        txtOrig = new JTextArea(300,580);        
        txtOrig.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPaneOrig = new JScrollPane(txtOrig);
        scrollPaneOrig.setPreferredSize(new Dimension(580, 300));          
        txtOrig.setAutoscrolls(true);
        txtOrig.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jplTextOrig.add(scrollPaneOrig);
        
        //----------------------------------------------       
               
        txtDest = new JTextArea(300,520);        
        JScrollPane scrollPaneDest = new JScrollPane(txtDest);
        scrollPaneDest.setPreferredSize(new Dimension(580, 300));        
        txtDest.setFont(new Font("Arial", Font.PLAIN, 16));       
        txtDest.setBackground(Color.decode("#dddddf"));
        txtDest.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtDest.setEditable(false);  
        jplTextDest.add(scrollPaneDest);
        scrollPaneDest.setPreferredSize(new Dimension(300,580));
        c.add(jplTextOrig, BorderLayout.WEST); 
        c.add(jplTextDest, BorderLayout.CENTER); 
        
        jplBotoes = new JPanel(new FlowLayout()); 
        
        jplTranslationType = new JPanel();        
        jplTranslationType.setLocation(150, 595);
        jplTranslationType.setSize(850,40);
        
		// botões seletores de tipo de tradução:        
        translationsTypes= new ButtonGroup();
        translations = new JRadioButton[] {
				new JRadioButton("Recursiva caudal para Iterativa (TR-IT) ", true),
				new JRadioButton("Recursiva não caudal para Recursiva caudal (NTR-TR) "),
				new JRadioButton("Recursiva não caudal para Iterativa (NTR-IT) "),
				new JRadioButton("Iterativa para Recursiva caudal (IT-TR) ")
				};
		// botões seletores de tipo de tradução:
		for (int i = 0; i < translations.length; i++) {
			jplTranslationType.add(translations[i]);
			translationsTypes.add(translations[i]);
			//translations[i].setEnabled(false);
			(translations[i]).addActionListener(new ActionListener() {				 
			    @Override
			    public void actionPerformed(ActionEvent event) {			 
			    	if (translations[1].isSelected()|| translations[3].isSelected()) {			    		
						lbJanDest.setText("O código recursivo caudal (TR) correspondente: " + repeatStr(" ",44));
						if (translations[1].isSelected()) {
							lbJanOrig.setText("O código recursivo não caudal (NTR) a traduzir:");
						} else {
							lbJanOrig.setText("O código iterativo (IT) a traduzir:");
						}
					} else {
						lbJanDest.setText("O código iterativo (IT) correspondente: "+ repeatStr(" ",58));
						if (translations[0].isSelected()) {
							lbJanOrig.setText("O código recursivo caudal (TR) a traduzir:");
						} else {
							lbJanOrig.setText("O código recursivo não caudal (NTR) a traduzir:");
						}
					}		
			    	txtDest.setText("");
					btSave.setEnabled(false);
					btClear.setEnabled(false);
					btCopy.setEnabled(false);
			    }
			});
		}				
		jplBotoes.add(jplTranslationType);
		jplBotoes.setPreferredSize(new Dimension(950, 100));
        
        btOpen = new JButton("Carregar código original"); 
        btOpen.setFont(new Font("Arial", Font.PLAIN, 17)); 
        btOpen.setSize(130, 60); 
        btOpen.setLocation(20, 540); 
        btOpen.addActionListener(this); 
        jplBotoes.add(btOpen); 
        
        btRun = new JButton("Traduzir"); 
        btRun.setFont(new Font("Arial", Font.PLAIN, 17)); 
        btRun.setSize(130, 40); 
        btRun.setLocation(20, 590); 
        btRun.addActionListener(this); 
        //btRun.setEnabled(false);
        jplBotoes.add(btRun); 
                  
        btSave = new JButton("Salvar resultado"); 
        btSave.setFont(new Font("Arial", Font.PLAIN, 17)); 
        btSave.setSize(130, 40); 
        btSave.setLocation(155, 540); 
        btSave.addActionListener(this); 
        btSave.setEnabled(false);
        jplBotoes.add(btSave);
        
        btCopy = new JButton("Copiar resultado"); 
        btCopy.setFont(new Font("Arial", Font.PLAIN, 17)); 
        btCopy.setSize(130, 40); 
        btCopy.setLocation(290, 540); 
        btCopy.addActionListener(this); 
        btCopy.setEnabled(false);
        jplBotoes.add(btCopy);
        
        btClear = new JButton("Apagar resultado"); 
        btClear.setFont(new Font("Arial", Font.PLAIN, 17)); 
        btClear.setSize(130, 40); 
        btClear.setLocation(425, 540); 
        btClear.setEnabled(false);
        btClear.addActionListener(this); 
        jplBotoes.add(btClear);  
 
        btExit = new JButton("Sair"); 
        btExit.setFont(new Font("Arial", Font.PLAIN, 17)); 
        btExit.setSize(130, 40); 
        btExit.setLocation(560, 540); 
        btExit.addActionListener(this); 
        jplBotoes.add(btExit);                      
        		
		c.add(jplLabels, BorderLayout.PAGE_START);
		c.add(jplBotoes, BorderLayout.PAGE_END);
        
        setVisible(true); 		
	}	

	@Override
	/* Age de acordo com o evento acionado (cliques em botoes) */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== btOpen) {
			String txtEntrada="";
			
			try (FileChooser selFile=new FileChooser()) {
				btSave.setEnabled(false);
				btClear.setEnabled(false);
				btCopy.setEnabled(false);
				selFile.openFile();
				of=FileChooser.getSelectedOpenFile();					
				List<String> lines=Files.readAllLines(of.toPath());
				ListIterator<String> listItr = lines.listIterator();
				btRun.setEnabled(true);
				for (int i = 0; i < translations.length; i++) {
					translations[i].setEnabled(true);
				}
				qtdLinesTxtEntr=0;
		        while (listItr.hasNext()) {
		        	txtEntrada+=listItr.next()+"\n";		        	
		        }		        

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			txtOrig.setText(txtEntrada);
		}		
		/* Botao de traducao acionado */
		if (e.getSource()== btRun) {			
			String txtEntrada=txtOrig.getText();
			String txtSaida = "";			
			//int typeTranslation=0;
			try {			
				if (translations[0].isSelected()){
					//Tail recursive to iterative
					rpVisitor0= new TRtoItVisitor();						
				} else if (translations[1].isSelected()){
					//Non Tail Recursive to tail recursive
					rpVisitor1= new NTRtoTRVisitor();					
				} else if (translations[2].isSelected()){
					//typeTranslation=2; //Non Tail Recursive to iterative
					rpVisitor2= new NTRtoITVisitor();
				} else {
					rpVisitor3= new ITtoTRVisitor();
				}
				String strEntDefBlock="";
				posBlkDefNaLinha=0;   //Reset (=-1 -> não é bloco DEF || >0 Posição do bloco 'def ...' na linha inicial do bloco)
				txtEntrada=setLinhaFinalPadraoWindows(txtEntrada);
				txtEntrada=txtEntrada+"\r\n\r\n\r\n";  //Para não atingir EOF (ao final, essas linhas extras serão eliminadas)
				String[] lines = txtEntrada.split("(?<=\r\n)");
				qtdLinesTxtEntr=lines.length;
				String line="";
				//int nrLines=lines.length;
				/* Para cada linha contida no texto do campo txtOrig */
				for (int nrLine=1; nrLine<=qtdLinesTxtEntr;nrLine++)  
				{		
					line=lines[nrLine-1];
					line=deleteExtraSpaces(line);
					/* Verifica se apareceu uma nova linha 'def ...'
					 * ou se está continuando a preencher um bloco def já iniciado  */
					if (isLineDef(line) || isBlockDef) {	
						isBlockDef=true;
						/* Se chegou ao final do bloco DEF e se existe texto para traduzir,
						 * chama o tradutor (runVisit) */
						if (isEndBlockDef(line, nrLine) && 
							strEntDefBlock.length()>0) {
							strEntDefBlock=setLinhaFinalPadraoWindows(strEntDefBlock);
							String blocoTraduzido="";
							if (translations[0].isSelected()){
								//Tail recursive to iterative
								blocoTraduzido=rpVisitor0.runVisitor(strEntDefBlock);	
							} else if (translations[1].isSelected()){
								//Non Tail Recursive to tail recursive
								blocoTraduzido=rpVisitor1.runVisitor(strEntDefBlock);
							} else if (translations[2].isSelected()){
								//Non Tail Recursive to iterative								
								blocoTraduzido=rpVisitor2.runVisitor(strEntDefBlock);
							} else {
								//iterative to Tail recursive
								blocoTraduzido=rpVisitor3.runVisitor(strEntDefBlock);
							}							
							txtSaida+=blocoTraduzido;
							strEntDefBlock="";
							if (! isLineDef(line)) {
								posBlkDefNaLinha=0;
								isBlockDef=false;
								//Linha de bloco de código comum (não função)
								txtSaida+=line;								
							} else {
								/* Vai acrescentando linhas ao bloco de funcao */
								strEntDefBlock+=line;
							}							
						} else {
							/* Vai acrescentando linhas ao bloco de funcao */
							strEntDefBlock+=line;	
						}						
					/* Trata-se de linha de bloco comum (sem ser bloco de função)
					 * Nesse caso, não traduz nada. Apenas copia a linha original */
					} else {
						//Linha de bloco de código comum (não função)
						txtSaida+=line;
					}					
				} 								
				//txtSaida = rpVisitor.runVisitor(txtEntrada, typeTranslation);
				btSave.setEnabled(true);
				btClear.setEnabled(true);
				btCopy.setEnabled(true);
				//Elimina as três linhas que foram acrescidas ao final:
				txtSaida=txtSaida.substring(0, txtSaida.length()-6);
				txtSaida=renameFunctions(txtSaida, translations);
				System.out.println(txtSaida);
				txtDest.setText(txtSaida);
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
		}
		/* Botao de cópia para a area de transferência acionado */
		if (e.getSource()== btCopy) {
			txtDest.selectAll();
			txtDest.copy();
		}
		/* Botao de gravacao do arquivo de saida acionado */
		if (e.getSource()== btSave) {
			String txtSaida=txtDest.getText();
			String fileName="";
			try (FileChooser selFile=new FileChooser()) {				
				selFile.saveFile();
				sf=FileChooser.getSelectedSaveFile();	
				fileName=FileChooser.getFilename();				
				Files.write(sf.toPath(),txtSaida.getBytes());  
				String msg="O arquivo: \n"+fileName+"\nfoi salvo com sucesso!";
				JOptionPane.showMessageDialog (null, msg);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		/* Botao para limpar a area de texto de destino acionado*/
		if (e.getSource()== btClear) {
			txtDest.setText("");
			btSave.setEnabled(false);
			btClear.setEnabled(false);
			btCopy.setEnabled(false);
		}
		/* Botao de saida acionado */
		if (e.getSource()== btExit) {
			this.dispose();
		}		
	}
	/* Retorna somente uma linha com a marca de final de paragrafo
	 * se, no inicio da linha houver somente espacos ou tabulacoes*/
	private static String deleteExtraSpaces(String line) {
		String retorno=line;
		Pattern strPattern = Pattern.compile("[!-~]");
	    Matcher m = strPattern.matcher(line);
		boolean hasAlpha=m.find();
		if (! hasAlpha) {
			retorno = "\r\n";
		}
		return retorno;
	}

	private String renameFunctions(String txt, JRadioButton[] translats) {
		String retorno="";
		String origFunction="";
		String destFunction="";
		if (translats[0].isSelected()) {
			origFunction="TR";
			destFunction="IT";	
		} else {
			if (translats[1].isSelected()) {
				origFunction="NTR";
				destFunction="TR";	
			} else {
				if (translats[2].isSelected()) {
					origFunction="NTR";
					destFunction="IT";
				}  else {
					origFunction="IT";
					destFunction="TR";					
				}
			}
		}
		retorno=txt.replaceAll("(.*)"+origFunction, "$1"+destFunction);
		return retorno;
	}

	private String setLinhaFinalPadraoWindows(String strEntDefBlock) {		
		String retorno=strEntDefBlock.replaceAll("(?<!\r)\n|\r(?!\n)", "\r\n");		
		return retorno;
	}

	/* obtem o trecho em string que contem os caracteres das linhas em branco
	 * situadas ao final do bloco da funcao em analise. Essas linhas sao retiradas
	 * do bloco de funcao e se tornam codigo comum (nao passam pelo tradutor, pois
	 * alem de desnecessarias, podem atrapalhar) */
	private String getFinalBlankLines(String strEntDefBlock) {
		int tam=strEntDefBlock.length();
		int cont=0;
		for (int i=tam; i>0;i--) {
		    if (!(strEntDefBlock.charAt(i-1)=='\r'||strEntDefBlock.charAt(i-1)=='\n'||strEntDefBlock.charAt(i-1)=='\t'||strEntDefBlock.charAt(i-1)==' ')) {
				break;
			}
			cont++;
		}
		return strEntDefBlock.substring(tam-cont, tam);
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

	/* Conta a quantidade de linhas finais em branco no código de funcao a traduzir */
	private int countFinalBlankLines(String strEntDefBlock) {
		int tam=strEntDefBlock.length();
		int retorno=0;
		char carRetorno=0;
		for (int i=0; i<tam; i++) {
			if (strEntDefBlock.charAt(i)=='\r') {
				carRetorno='\r';
				break;
			}else {
				carRetorno='\n';
				break;
			}
		}
		for (int i=tam; i>0;i--) {
		    if (!(strEntDefBlock.charAt(i-1)=='\r'||strEntDefBlock.charAt(i-1)=='\n'||strEntDefBlock.charAt(i-1)=='\t'||strEntDefBlock.charAt(i-1)==' ')) {
				break;
			}
		    if (strEntDefBlock.charAt(i-1)==carRetorno) retorno++;
		}
		return retorno;
	}

	/* Verifica se está na linha inicial de uma funcao (contem o comando "def ...") */
	private boolean isLineDef(String line) {
		//Verificando se entrou em um bloco DEF
		if (line.contains("def ") && !(line.contains("#") || line.contains("'''") || line.contains("\"\"\""))) {
			posBlkDefNaLinha=getPosBlkNaLinha(line);
			//System.out.println("PosBlkNaLinha: "+posBlkDefNaLinha);
			return true;
		} else {
			return false;
		}		
		
	}
	/* Verifica se estava em um bloco de funcao e se chegou à última linha desse bloco */
	private boolean isEndBlockDef(String line, int nrLine){
		if (! isBlockDef) {
			return false;
		} 
		int posTempBlkDefNaLinha=getPosBlkNaLinha(line);
		if (posTempBlkDefNaLinha==posBlkDefNaLinha || (isBlockDef && isLastLine(nrLine))) {
			posBlkDefNaLinha=0;
			return true;
		} else {
			return false;
		}
	}
	/* Verifica se chegou à última linha do bloco de funcao */
	private boolean isLastLine(int nrLine) {		
		return nrLine==qtdLinesTxtEntr;
	}

	/* Obtem a posicao do início do bloco da função, dentro da linha.
	 * Essa posição levará em conta a quantidade de espaços e de tabulações
	 * Cada tab vale 4 espacos 
	 * Essa posicao é importante para indentacao e desindentacao 
	 * A mesma posicao de inicio deve ser a do final do bloco */
	private int getPosBlkNaLinha(String line) {
		int tamLine=line.length();
		int retorno=0;
		for (int i=0; i<tamLine;i++) {
			if (line.charAt(i)==' '){
				retorno++;
			}
			if (line.charAt(i)=='\t'){
					retorno=retorno+4;
				}
			if (line.charAt(i)!=' ' && line.charAt(i)!='\t' && line.charAt(i)!='\r' && line.charAt(i)!='\n') { //&& line.charAt(i)!='\r' && line.charAt(i)!='\n' ) {
				break;
			}
		}
		return retorno;
	}
	/* repeat x vezes uma determinada string de entrada
	 * Em alguma versões mais recentes do Java, isso já existe pronto. */
	private String repeatStr(String strEnt, int qtdRepeats) {
		String retorno="";
		for (int i=1; i<=qtdRepeats; i++) {
			retorno+=strEnt;
		}
		return retorno;
	}
}
/* Carrega a interface (janela) principal do aplicativo RecPy*/
class RecPy{
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception 
	{
		try {
			//System.out.println("Informs. sobre a cadeia ClassLoader: \n"+ classLoaderUtil.getCurrentClassLoaderDetail());
			RecPyForm janelaRecPy=new RecPyForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}