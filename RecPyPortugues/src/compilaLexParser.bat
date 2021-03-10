@echo Para visualizar os tokens gerados em determinada funcao recursiva, digitar: 
@echo compilaLexParser.bat nome_do_arquivo
@echo Exemplo:
@echo compilaLexParser.bat fatmodTR.pyw
@echo Os arquivos de teste situam-se na pasta 'GitHb\Python\TestesEmLinhaCMD' (nao eh necessario digitar o caminho completo)
@echo Coloque um segundo parametro com qualquer conteudo se quiser chamar a representacao grafica da arvore AST
@echo Exemplo: 
@echo compilaLexParser.bat fatmodTR.pyw G
@echo Nao se esqueca de configurar previamente a variavel "tipoTraduc", conforme instrucoes
@echo contidas no arquivo "Leiame-procedimentos de compilacao-Lexer Parser.txt"
call antlr .\lexrParsr\RecPyLexer.g4
call antlr .\lexrParsr\RecPyParser.g4 -visitor
call javac .\lexrParsr\*.java

if [%1]==[] goto somenteCompila

if [%2]==[] goto tokens
	call grun lexrParsr.RecPy start -gui E:\Estudo\UERJ\Materias\TCC\GitLab\TCC_CComp_UERJ\Python\TestesEmLinhaCMD\%1
goto :eof
:tokens
	call grun lexrParsr.RecPy start -tokens E:\Estudo\UERJ\Materias\TCC\GitLab\TCC_CComp_UERJ\Python\TestesEmLinhaCMD\%1	
:somenteCompila
