import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

arr.sort()

count = 0

for k in range(N):
    i = 0
    j = N -1

    while i < j:
        if arr[i] + arr[j] == arr[k]:
            if i != k and j != k:
                count += 1
                break
            
            elif i == k:
                i += 1
            elif j == k:
                j -= 1

        elif arr[i] + arr[j] < arr[k]:
            i += 1
        
        else:
            j -= 1

print(count)