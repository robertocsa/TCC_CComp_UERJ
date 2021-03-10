# Resultado: Verifica se dado numero e primo

# -*- coding: utf-8 -*-
import time as t
import sys

sys.setrecursionlimit(1000000)

# ********************* funcao recursiva caudal a traduzir *********************

def primIT(n,i=2):    
    # verifica o caso base:    
    while not (casoBase(n,i)!=None):
        n,i = n, i+1
    return casoBase(n,i)

# ******************************************************************************

def casoBase(n,i):
    if (n <= 2): 
        if (n == 2):
            return True
        else:
            return False
    if (n % i == 0): 
        return False
    if ( (i * i) > n): 
        return True 

def main():    

    #versao="2_7_16"
    versao="3_7_9"
    nome_funcao="primIT"
    nomeArqResult="Results" +"_"+versao+"_"+nome_funcao+"_"+t.strftime("%Y%m%d_%H%M%S")+".csv"    
    resultsCSV = open(nomeArqResult, "w")
    resultsCSV.write("#Id;NomeFuncao;N;Tempo;Versao Python\n")
    
    id=1    
    for n in range(334,100000,999):
        inicio=t.time()

        print(n, primIT(n))
 
        fim = t.time()
        tempo=(fim - inicio)
        resultsCSV.write("%d;%s;%d;%s;%s\n" % (id,nome_funcao, n, tempo, versao))
        id=id+1
        resultsCSV.flush()
    resultsCSV.close()
    fim = t.time()
    print("Tempo de Execucao: ", (fim - inicio))

main()






