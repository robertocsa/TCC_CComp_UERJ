# Funcao recursiva para ordenacao de um vetor
# O experimento traduzira apenas a funcao ordNTR, pois as demais sao auxiliares
# -*- coding: utf-8 -*-
import time as t
import sys
import os
import string
import random
import traceback

sys.setrecursionlimit(1000000)

# **************** funcao em teste *********************

def ordNTR(L):
    if (L==[]):
        return []
    return menor(L) + ordNTR(subtracao (L, menor(L)))

#********************************************************

def subtracao (L, x):
    if (L==[]):
        return []
    if (L[0:1]== x):
        return L[1:len(L)]
    return L[0:1] + subtracao (L[1:len(L)], x) 

def menor (L):
    if (L[1:len(L)]==[]):
        return L[0:1]
    if (L[0:1] < menor (L[1:len(L)])):
        return L[0:1]
    return menor (L[1:len(L)])

def main():
    try:
        #versao="2_7_16"
        versao="3_7_9"
        nome_funcao="ordNTR"
        nomeArqResult="Results" +"_"+ versao+"_"+nome_funcao+".csv"
        resultsCSV = open(nomeArqResult, "w")
        resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
        id=1    
        for n in range(2,12,1):                    
            listaLetras=(string.ascii_letters).upper()
            inicio=t.time()
            
            #V=["H","G","C","A","F","E","D","B",...]
            V=(random.sample(listaLetras, n))
            
            print(n)    
            print(V)
            print(ordNTR(V))
            
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
