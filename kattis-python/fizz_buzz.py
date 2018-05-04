import sys


def fizz_buzz(x: int, y: int, n: int) -> None:
    for i in range(1, n + 1):
        override = False
        if i % x == 0:
            override = True
            print('Fizz', end='')
        if i % y == 0:
            override = True
            print('Buzz', end='')
        if not override:
            print(i, end='')
        print()


if __name__ == '__main__':
    # https://open.kattis.com/problems/fizzbuzz
    params = [int(x) for x in sys.stdin.readline().split()]

    fizz_buzz(params[0], params[1], params[2])
