import sys
input = sys.stdin.readline

N = list(map(int, input().split()))
num_arr = list(map(int, input().split()))

sum_arr = [0]
temp = 0

for i in num_arr:
    temp += i
    sum_arr.append(temp)

for i in range(N[1]):
    s, e = map(int, input().split())
    print(sum_arr[e] - sum_arr[s - 1])
