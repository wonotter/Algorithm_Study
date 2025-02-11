import sys
input = sys.stdin.readline

N = int(input())
tmp = [0] * (N)
A = list(map(int, input().split()))
result = 0

def merge_sort(s, e):
    global result
    if e - s < 1: return
    m = int((s + e) / 2)

    merge_sort(s, m)
    merge_sort(m + 1, e)

    for i in range(s, e + 1):
        tmp[i] = A[i]
    
    k = s
    idx1 = s
    idx2 = m + 1

    while idx1 <= m and idx2 <= e:
        if tmp[idx1] > tmp[idx2]:
            A[k] = tmp[idx2]
            k += 1
            idx2 += 1

            # 뒷쪽 데이터 값이 더 작다면 결과값 업데이트
            result += idx2 - k

        else:
            A[k] = tmp[idx1]
            k += 1
            idx1 += 1
    
    while idx1 <= m:
        A[k] = tmp[idx1]
        k += 1
        idx1 += 1
    while idx2 <= e:
        A[k] = tmp[idx2]
        k += 1
        idx2 += 1

merge_sort(0, N - 1)
print(result)