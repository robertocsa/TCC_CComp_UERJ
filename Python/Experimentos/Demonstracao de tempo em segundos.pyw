#Demonstração de tempo em segundos
import time as t
import sys

def main():    
    
    id=0
    inicio=t.time()
    while id < 61:        
        fim = t.time()
        tempo=(fim - inicio)              
        if (tempo>(0.00+id) and tempo<(1.00+id)):
            print("Tempo de Execucao: ", tempo)
            id=id+1    

main()



