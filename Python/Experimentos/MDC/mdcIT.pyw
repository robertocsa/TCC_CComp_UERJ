# Funcao recursiva de MDC
# O experimento traduzira a funcao mdcIT
# -*- coding: utf-8 -*-
import time as t
import sys
import os
import string
import random
import traceback

sys.setrecursionlimit(1000000)

# **************** funcao em teste *******************

def mdcIT(a, b):
    while not  (b == 0):
        a,b = b, (a % b)
    return a

# ****************************************************

def main():
    try:
        #versao="2_7_16"
        versao="3_7_9"
        nome_funcao="mdcIT"
        nomeArqResult="Results" +"_"+ versao+"_"+nome_funcao+".csv"
        resultsCSV = open(nomeArqResult, "w")
        resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
        
        id=1    
        for n in range(2,21,1):
            inicio=t.time()

            a=100+random.randint(1,1000)           
            print("mdc de ",a,n,"=", mdcIT(a,n))

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

