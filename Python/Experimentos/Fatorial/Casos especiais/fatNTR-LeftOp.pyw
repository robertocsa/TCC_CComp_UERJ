def factorial(n):
    if n < 2:
        return 1
    return n * factorial(n - 1)

def main():
    n=6
    print(factorial(n))
    
main()

