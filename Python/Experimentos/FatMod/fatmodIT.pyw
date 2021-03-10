# -*- coding: utf-8 -*-

#fatmod recursivo nao caudal
#fatmod non tail recursive

import time as t
import sys
sys.setrecursionlimit(1000000)

# **************** funcao em teste *****************

def fatmodIT(n, k, acc=1):
    #retorna n! mod (k+1)
    while not  n == 0:
        n,k,acc = n-1,k, n *  acc % (k+1)
    return acc

# ***************************************************

def main():    
    
    #versao="2_7_16"
    versao="3_7_9"
    nome_funcao="fatmodIT"
    nomeArqResult="Results" +"_"+versao+"_"+nome_funcao+"_"+t.strftime("%Y%m%d_%H%M%S")+".csv"    
    resultsCSV = open(nomeArqResult, "w")
    resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
    
    id=1    
    for n in range(0,12,1):
        inicio=t.time()
        print(n,fatmodIT(n,100000))
        fim = t.time()
        tempo=(fim - inicio)
        resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo,versao))
        id=id+1
        resultsCSV.flush()
    resultsCSV.close()
    fim = t.time()
    print("Tempo de Execucao: ", (fim - inicio))


main()




