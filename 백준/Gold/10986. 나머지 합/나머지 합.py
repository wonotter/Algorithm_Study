import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num_arr = list(map(int, input().split()))
sum_arr = [0] * N
c_arr = [0] * M
sum_arr[0] = num_arr[0]

for i in range(1, N):
    sum_arr[i] = sum_arr[i - 1] + num_arr[i]

answer = 0

for j in range(N):
    remainder = sum_arr[j] % M
    
    if remainder == 0:
        answer += 1

    c_arr[remainder] += 1

for i in range(M):
    if c_arr[i] > 1:
        answer += (c_arr[i] * (c_arr[i] - 1) // 2)

print(answer)