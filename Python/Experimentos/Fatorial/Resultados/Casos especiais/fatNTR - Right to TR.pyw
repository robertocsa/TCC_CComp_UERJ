#Fatorial Recursivo nao caudal com operacao de cauda aa direita
from datetime import datetime
import sys
sys.setrecursionlimit(100000)

def fatNTR(n, acc=1):
    if n < 2:
        return acc        
    return fatNTR(n - 1, acc *n)


def main():
    start =datetime.now()
    n=188
    print(fatNTR(n))
    end =datetime.now()
    elapsed=end-start
    print('Elapsed time: (hh:mm:ss.ms) {}'.format(elapsed))


main()









