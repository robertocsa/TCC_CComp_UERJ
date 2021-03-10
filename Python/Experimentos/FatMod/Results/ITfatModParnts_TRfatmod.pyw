# fatmod iterativa
# Iterative fatmod
import sys
sys.setrecursionlimit(100000)

def fatmod1 ( n, k, a):
    if  n == 0 :
        return  a % k
    return fatmod1(n-1, k , (a * n) % (k+1))


print(fatmod1(2614,100000, 1))

