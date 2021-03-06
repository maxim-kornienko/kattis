import sys


def main() -> None:
    result = 0

    n = int(sys.stdin.readline())
    for i in range(0, n):
        p = int(sys.stdin.readline())
        number = p // 10
        power = p % 10
        result += pow(number, power)
    print(result)


if __name__ == '__main__':
    # https://open.kattis.com/problems/pot
    main()
