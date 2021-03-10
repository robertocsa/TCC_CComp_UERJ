#-*- coding: utf-8 -*-
""" 

Concatena os arquivos de resultados intermediários
ATENCAO!! UTILIZAR A VERSAO 3.7.x do Python ou superior compatível

"""
import os
from datetime import datetime

try:    
    directory = r'.'    

    dateTimeNow=datetime.now()
    strDateTime=dateTimeNow.strftime('%Y_%m_%d__%H_%M')

    nameDestinationFile="RESULTS_"+ strDateTime +".csv"

    destinationFile = open(nameDestinationFile, "w")

    firstLineDestination='true'

    i=1
    destinationFile.write("sep=;\n")    
    
    for entry in os.scandir(directory):        
        if (entry.path.endswith(".csv") and ("Results_" in entry.path) and entry.is_file()):            
            print(entry.path)
            
            originFile = open(entry.path, "r")
            lines=originFile.readlines()
            originFile.close()
            firstLineOrigin='true'            
            for line in lines:                
                if firstLineOrigin=='true':
                    firstLineOrigin='false'
                    if firstLineDestination=='true':
                        firstLineDestination='false'
                        destinationFile.write("ID;%s" % line)                        
                else:
                    line=line.replace(".",",")
                    destinationFile.write("%d;%s" % (i,line))
                    i=i+1
except:
    print("Erro na gravação do arquivo de saída: \n", nameDestinationFile)
finally:
    print("Arquivo de saída: \n", nameDestinationFile,"\ngerado com sucesso!!")
    destinationFile.close() 
