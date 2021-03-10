# -*- coding: utf-8 -*-
# Calcula fatorial
import time as t
import sys
sys.setrecursionlimit(1000000)

# **************** funcao em teste *******************

def fatTR(n, acc=1):    
    if n < 2:        
        return acc
    return  fatTR(n - 1, n * acc)

# ****************************************************

def main():    
    
    #versao="2_7_16"
    versao="3_7_9"
    nome_funcao="fatTR"
    nomeArqResult="Results" +"_"+versao+"_"+nome_funcao+"_"+t.strftime("%Y%m%d_%H%M%S")+".csv"    
    resultsCSV = open(nomeArqResult, "w")
    resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
    
    id=1    
    for n in range(0,12,1):    
        inicio=t.time()
        resultado=fatTR(n)
        print(n,resultado)
        fim = t.time()
        tempo=(fim - inicio)
        resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo,versao))
        id=id+1
        resultsCSV.flush()
    resultsCSV.close()
    fim = t.time()
    print("Tempo de Execucao: ", (fim - inicio))

main()




