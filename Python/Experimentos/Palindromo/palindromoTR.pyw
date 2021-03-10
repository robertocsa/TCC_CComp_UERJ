# Verifica se eh palindromo
# Verifies if is it palindrome

# O experimento traduzira apenas a funcao palTR, pois as demais sao auxiliares
# -*- coding: utf-8 -*-
import time as t
import sys
import os
import string
import random
import traceback

sys.setrecursionlimit(1000000)
from datetime import datetime
import sys
sys.setrecursionlimit(100000)

'''
Exemplos:
print(trPalindromo("rotor")) #Verdadeiro
print(trPalindromo("amorroma")) #Verdadeiro
print(trPalindromo("motor"))   #Falso
print(trPalindromo("amora")) #Falso
print(trPalindromo("ama"))  #Verdadeiro
print(trPalindromo("aedcamacdea")) #Verdadeiro
'''


#**************  funcao em teste **********

def palTR(texto):
    if  (casoBase(texto)!= None):
        return casoBase(texto)
    return palTR(texto[1:len(texto)-1])

#******************************************


def casoBase(texto):
    if (len(texto)<=1):
        return True
    if (texto[0]!=texto[len(texto)-1]):
        return False

def main():
    try:
        #versao="2_7_16"
        versao="3_7_9"
        nome_funcao="palTR"
        nomeArqResult="Results" +"_"+ versao+"_"+nome_funcao+"_"+ t.strftime("%Y%m%d_%H%M%S")+".csv"     
        resultsCSV = open(nomeArqResult, "w")
        resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
        
        id=1    
        
        letras="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        
        for n in range(2,100000,500):
            inicio = t.time()
            texto=""
            for i in range(3):                
                texto+=random.choice(letras)

            resultado=palTR(texto)
            if(resultado==True):
                print(n)
                print(texto) 

            fim = t.time()
            tempo=(fim - inicio)
            resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo, versao))
            id=id+1
            resultsCSV.flush()
        resultsCSV.close()
        fim = t.time()
        print("Tempo de Execucao: ", (fim - inicio))
        del resultsCSV
        del letras
        del nomeArqResult
        del versao
        del nome_funcao
    except:
        print("ERRO na Execucao!!! ")
        traceback.print_exc()
        resultsCSV.close()
        os.remove(nomeArqResult)
            
main()


