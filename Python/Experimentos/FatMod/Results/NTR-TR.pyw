#fatmod recursivo nao caudal
#fatmod non tail recursive
# -*- coding: utf-8 -*-
# Calcula um "fatorial modificado" 
import time as t
import sys
sys.setrecursionlimit(1000000)

# **************** funcao em teste *******************

def fatmodTR(n, k, acc=1):
    #retorna n! mod (k+1)
    if n == 0:
        return acc
    return fatmodTR(n-1,k, n *  acc %  (k+1))

# ****************************************************

def main():    

    #versao="2_7_16"
    versao="3_7_9"
    nome_funcao="fatmodTR"
    nomeArqResult="Results" +"_"+versao+"_"+nome_funcao+"_"+t.strftime("%Y%m%d_%H%M%S")+".csv"    
    resultsCSV = open(nomeArqResult, "w")
    resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")

    id=1    
    for n in range(0,12,1):
        inicio=t.time()
        print(n,fatmodTR(n,100000))
        fim = t.time()
        tempo=(fim - inicio)
        resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo,versao))
        id=id+1
        resultsCSV.flush()
    resultsCSV.close()
    fim = t.time()
    print("Tempo de Execucao: ", (fim - inicio))

main()



