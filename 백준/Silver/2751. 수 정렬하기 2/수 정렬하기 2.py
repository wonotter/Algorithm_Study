'''
e.g. 배열 A가 [5, 3, 8, 4, 2, 7, 1, 6] 인 경우 함수 재귀호출 흐름

merge_sort(1, 8) => [5, 3, 8, 4, 2, 7, 1, 6]
    ├── merge_sort(1, 4) => [5, 3, 8, 4]
    │   ├── merge_sort(1, 2) => [5, 3]
    │   │   ├── merge_sort(1, 1)  → 종료
    │   │   ├── merge_sort(2, 2)  → 종료
    │   │   ├── merge(1, 1, 2)   → [3, 5]
    │   ├── merge_sort(3, 4) => [8, 4]
    │   │   ├── merge_sort(3, 3)  → 종료
    │   │   ├── merge_sort(4, 4)  → 종료
    │   │   ├── merge(3, 3, 4)   → [4, 8]
    │   ├── merge(1, 2, 4)      → [3, 4, 5, 8]
    │
    ├── merge_sort(5, 8) => [2, 7, 1, 6]
    │   ├── merge_sort(5, 6) => [2, 7]
    │   │   ├── merge_sort(5, 5)  → 종료
    │   │   ├── merge_sort(6, 6)  → 종료
    │   │   ├── merge(5, 5, 6)   → [2, 7]
    │   ├── merge_sort(7, 8) => [1, 6]
    │   │   ├── merge_sort(7, 7)  → 종료
    │   │   ├── merge_sort(8, 8)  → 종료
    │   │   ├── merge(7, 7, 8)   → [1, 6]
    │   ├── merge(5, 6, 8)      → [1, 2, 6, 7]
    │
    ├── merge(1, 4, 8)        → [1, 2, 3, 4, 5, 6, 7, 8]
'''

import sys

input = sys.stdin.readline
print = sys.stdout.write

# 병합정렬 알고리즘
def merge_sort(start, end):
    # 그룹화한 원소가 1개인 경우 모두 분할하였으므로 종료
    if end - start < 1: return
    
    # start와 end의 중간값 mid 계산
    mid = int((start + end) / 2)

    # 재귀호출을 통해 가장 처음의 mid값을 기준으로
    # 왼쪽 그룹의 각각 원소들이 모두 그룹을 가지도록 분할
    merge_sort(start, mid)

    # 재귀호출을 통해 가장 처음의 mid값을 기준으로
    # 오른쪽 그룹의 각각 원소들이 모두 그룹을 가지도록 분할
    merge_sort(mid + 1, end)

    # tmp의 역할은 아래 2가지와 같다.
    # 1. 각 그룹에 해당하는 값을 복사하여 인덱스에 대한 저장된 값을 비교한 후 저장함
    # 2. 병합이 진행된 그룹에 한정하여 저장하는 방식 (for문이 재귀호출하는 점을 감안해라!)
    # e.g. merge(1, 2, 4) 인 경우
    # A = [0, 3, 5, 4, 8, 2, 7, 1, 6]
    # tmp = [0, 3, 5, 4, 8, 0, 0, 0]
    for i in range(start, end + 1):
        tmp[i] = A[i]
    
    k = start # 최종 병합된 배열에서 시작 위치
    idx1 = start # 첫 번째 부분 배열의 시작 인덱스
    idx2 = mid + 1 # 두 번째 부분 배열의 시작 인덱스

    while idx1 <= mid and idx2 <= end:
    # 양쪽 그룹의 index가 가리키는 값을 비교한 후 더 작은 수를 선택해 리스트에 저장한 후
    # 선택된 데이터의 index 값을 오른쪽으로 1칸 이동

        # index1이 가리키는 데이터가 더 큰 경우
        if tmp[idx1] > tmp[idx2]:
            A[k] = tmp[idx2]
            k += 1 # 값을 넣었으니 최종 인덱스도 1칸 이동
            idx2 += 1 # 1칸 이동
        
        # index2가 가리키는 데이터가 더 큰 경우
        else:
            A[k] = tmp[idx1]
            k += 1 # 값을 넣었으니 최종 인덱스도 1칸 이동
            idx1 += 1 # 1칸 이동
    
    # 한 쪽 그룹의 데이터가 모두 선택된 후 남은 다른 한쪽 그룹에 대한 남은 데이터 삽입

    # 왼쪽 그룹에 대해 데이터가 남은 경우 삽입
    while idx1 <= mid:
        A[k] = tmp[idx1]
        k += 1
        idx1 += 1
    
    # 오른쪽 그룹에 대해 데이터가 남은 경우 삽입
    while idx2 <= end:
        A[k] = tmp[idx2]
        k += 1
        idx2 += 1

N = int(input())
A = [0] * (N + 1)
tmp = [0] * (N + 1)

for i in range(1, N + 1):
    A[i] = int(input())

merge_sort(1, N)

for i in range(1, N + 1):
    print(str(A[i]) + '\n')