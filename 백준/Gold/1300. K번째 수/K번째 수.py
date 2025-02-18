import sys
input = sys.stdin.readline

N = int(input())
k = int(input())

start = 1
end = k
answer = 0

while start <= end:
    mid = (start + end) // 2
    total_count = 0

    for i in range(1, N + 1):
        row_count = mid // i
        if row_count >= N:
            row_count = N
        total_count += row_count

    if total_count < k:
        start = mid + 1
    else:
        end = mid - 1
        answer = mid
    
print(answer)