# -*- coding: utf-8 -*-
# Resultado da funcao: concatenacao de texto

import time as t
import sys
sys.setrecursionlimit(1000000)

# ********************* funcao em teste *********************

def textIT(n, acc=""):
    while not  (n==0):
        n,acc = n - 1,str(n) + ". The quick brown fox jumps over the lazy dog.\n" + acc
    return acc

# *************************************************************

def main():    


    #versao="2_7_16"
    versao="3_7_9"
    nome_funcao="textIT"
    nomeArqResult="Results" +"_"+versao+"_"+nome_funcao+"_"+t.strftime("%Y%m%d_%H%M%S")+".csv"    
    resultsCSV = open(nomeArqResult, "w")
    resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
    
    id=1    
    for n in range(2,21,1):
        inicio=t.time()
        textOut=textIT(n)
        
        print(textOut)
 
        fim = t.time()
        tempo=(fim - inicio)
        resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo, versao))
        id=id+1
        resultsCSV.flush()
    resultsCSV.close()
    fim = t.time()
    print("Tempo de Execucao: ", (fim - inicio))

main()





