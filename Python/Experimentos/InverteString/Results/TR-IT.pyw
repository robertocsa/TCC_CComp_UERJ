#Inverte uma string
# it inverts a string

# O experimento traduzira apenas a funcao invIT, pois as demais sao auxiliares
# -*- coding: utf-8 -*-
import time as t
import sys
import os
import string
import random
import traceback

sys.setrecursionlimit(1000000)


# **************** funcao em teste ******************

def invIT(texto, acc=""):
    while not (len(texto)<=0):
        n=len(texto)-1
        texto,acc = texto[0:n], acc+texto[n]
    return acc

#****************************************************

def main():
    try:
        versao="2_7_16"
        #versao="3_7_9"
        nome_funcao="invIT"
        nomeArqResult="Results" +"_"+ versao+"_"+nome_funcao+"_"+ t.strftime("%Y%m%d_%H%M%S")+".csv"    
        resultsCSV = open(nomeArqResult, "w")
        resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")        
        id=1    
        
        letras="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
                
        for n in range(2,12,1):
            inicio = t.time()
            texto=""
            for i in range(n):                
                texto+=random.choice(letras)

            print(n)
            print(texto)
            print("*****************************************")    
            print(invIT(texto))
            print("*****************************************")   

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



