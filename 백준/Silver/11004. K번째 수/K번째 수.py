import sys
input = sys.stdin.readline

N, K = map(int, input().split())
A = list(map(int, input().split()))

# 퀵 정렬 알고리즘
def quickSort(start, end, K):
    global A

    # 분할할 구간이 아직 남은경우
    if start < end:
        # 현재 구간의 피봇을 설정하고 배열을 분할
        pivot = findPivot(start, end)
        
        # 목표값인 K번째에 해당하는 값이 피봇 위치라면
        if pivot == K:
            return # 바로 종료하여 오름차순으로 정렬된 K번째 값 출력
        
        # K번째 값이 pivot보다 오른쪽 구간에 있다면 오른쪽만 탐색
        elif pivot < K:
            quickSort(pivot + 1, end, K)
        
        # K번째 값이 pivot보다 왼쪾 구간에 있다면 왼쪽만 탐색
        elif pivot > K:
            quickSort(start, pivot-1, K)

# 배열의 두 원소를 교환하는 함수
# 교환할 두 원소의 인덱스를 넣으면 됨
def swap(i, j):
    global A
    temp = A[i]
    A[i] = A[j]
    A[j] = temp

# e.g. [3, 7, 2, 5, 1, 6, 4]
# 피봇을 찾고 배열을 재배치하는 함수
def findPivot(start, end):
    global A

    # 데이터가 2개인 경우는 바로 비교하여 정렬
    if start + 1 == end:
        # 두 원소가 정렬되어 있지 않다면 교환
        if A[start] > A[end]:
            swap(start, end)
        return end # 피봇의 위치 반환
    
    # 중간 인덱스를 구하여 피봇으로 설정한 다음
    M = (start + end) // 2
    # 시작 위치와 교환
    swap(start, M)

    pivot = A[start] # 피봇값
    i = start + 1 # 피봇의 다음 인덱스를 i로 설정
    j = end # 배열의 마지막 인덱스를 j로 설정

    # i와 j가 서로 교차할때까지 반복
    while i <= j:
        # 오른쪽에서부터 피봇보다 작은 값이 있을때까지 반복하여 내려옴
        while pivot < A[j] and j > 0:
            j = j - 1
        # 왼쪽에서부터 피봇보다 큰 값이 있을때까지 반복하여 올라감
        while pivot > A[i] and i < len(A)-1:
            i = i + 1
        
        # i와 j가 서로 교차하지 못한 채 반복문이 종료되었다면
        # 1. M = pivot = 5, [5, 7, 2, 3, 1, 6, 4]
        # 2. i는 현재 1번 인덱스인 7을 가리키고, j는 6번 인덱스인 4를 가리키는 상황
        if i <= j:
            # 서로 다른 집합에 있는 두 값을 swap
            swap(i, j)
            i = i + 1
            j = j - 1
    
    # 위의 while문이 끝나면 i와 j가 교차한 지점이 되므로
    # 피봇이 가리키는 값과 i와 j가 교차한 지점과 swap
    # 3. j = 4이고, 현재 1을 가리킴
    # 4. i = 5이고, 현재 6을 가리킴
    # 5. 따라서 pivot보다 작은 값을 가리키고 있는 A[j]와 pivot값을 swap
    A[start] = A[j]
    A[j] = pivot

    # 피봇의 최종위치 반환
    return j

# K번째 수를 찾기 위해 퀵 정렬 실행
quickSort(0, N - 1, K - 1) # 배열은 0부터 시작하니까 K-1을 넣어야 함
print(A[K - 1]) # 결과 출력 역시 K-1