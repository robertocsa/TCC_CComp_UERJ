# fatmod iterativa
# Iterative fatmod
import sys
sys.setrecursionlimit(100000)

def fatmod1 ( n, k, a):
    while not  n == 0 :
        n, k, a = (n-1, k , (a * n) % (k+1) ) 
    return  a % k

print(fatmod1(2614,100000, 1))
