# Funcao recursiva de Fibonacci
# O experimento traduzira a funcao fibIT
# -*- coding: utf-8 -*-
import time as t
import sys
import os
import string
import random
import traceback

sys.setrecursionlimit(1000000)

# **************** funcao em teste *******************

def fibIT(a, b, c):
    while not  (a == 0):
        a,b,c = a-1, b+c, b
    return c

# ****************************************************

def main():
    try:
        nomeArqResult="Results" +"_"+ t.strftime("%Y%m%d_%H%M%S")+".csv"    
        resultsCSV = open(nomeArqResult, "w")
        resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
        #versao="2_7_16"
        versao="3_7_9"
        nome_funcao="fibIT"
        id=1    
        for n in range(0,12,1):
            inicio=t.time()
            b=1
            c=0
            print(n,fibIT(n,b,c))
            fim = t.time()
            tempo=(fim - inicio)
            resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo, versao))
            id=id+1
            resultsCSV.flush()
        resultsCSV.close()
        fim = t.time()
        print("Tempo de Execucao: ", (fim - inicio))
    except:
        print("ERRO na Execucao!!! ")
        traceback.print_exc()
        resultsCSV.close()
        os.remove(nomeArqResult)
            
main()


