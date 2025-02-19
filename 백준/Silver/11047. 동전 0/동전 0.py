import sys
input = sys.stdin.readline

N, K = map(int, input().split())
A = [0] * N

for i in range(N):
    A[i] = int(input())

count = 0
while K != 0:
    for i in range(N - 1, -1, -1):
        if A[i] > K:
            continue
        else:
            count += K // A[i]
            K = K % A[i]            
            break

print(count)