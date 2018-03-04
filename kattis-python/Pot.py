import sys

result = 0

n = int(sys.stdin.readline())
for i in range(0, n):
    p = int(sys.stdin.readline())
    number = p // 10
    power = p % 10
    result += pow(number, power)

print(result)