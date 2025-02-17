import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
M = int(input())
Q = list(map(int, input().split()))

A.sort()

for target in Q:
    found = False
    start = 0
    end = N - 1

    while start <= end:
        mid_idx = int((start + end) / 2)
        mid_val = A[mid_idx]

        if target == mid_val:
            found = True
            break
        elif target > mid_val:
            start = mid_idx + 1
        elif target < mid_val:
            end = mid_idx - 1
    
    if found:
        print(1)
    else:
        print(0)