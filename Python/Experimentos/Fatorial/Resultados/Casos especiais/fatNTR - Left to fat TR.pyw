def factorial(n, acc=1):
    if n < 2:
        return acc
    return  factorial(n - 1, n * acc)


def main():
    n=6
    print(factorial(n))

main()


