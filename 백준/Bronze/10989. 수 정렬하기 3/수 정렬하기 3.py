import sys
input = sys.stdin.readline

count = [0] * 10001
N = int(input())

for i in range(N):
    tmp = int(input())
    count[tmp] += 1

for i in range(10001):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)