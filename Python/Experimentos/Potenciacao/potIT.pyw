# Resultado: potencia de um numero n na base b
# -*- coding: utf-8 -*-
import time as t
import sys

sys.setrecursionlimit(1000000)

def potIT(n,b, acc):   
    while not  (b==1): 
        n,b,acc = n, b-1, n * acc
    return acc


def main():    
    
    #versao="2_7_16"
    versao="3_7_9"
    nome_funcao="potIT"
    #nomeArqResult="Results" +"_"+ t.strftime("%Y%m%d_%H%M%S")+".csv"
    nomeArqResult="Results" +"_"+ versao+"_"+nome_funcao+"_"+ t.strftime("%Y%m%d_%H%M%S")+".csv"     
    resultsCSV = open(nomeArqResult, "w")
    resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
       
    id=1    
    for n in range(2,21,1):
        inicio=t.time()

        print(potIT(3, n, 1))
 
        fim = t.time()
        tempo=(fim - inicio)
        resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo, versao))
        id=id+1
        resultsCSV.flush()
    resultsCSV.close()
    fim = t.time()
    print("Tempo de Execucao: ", (fim - inicio))

main()

