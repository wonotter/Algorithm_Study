import sys

input = sys.stdin.readline

N = int(input())
P = list(map(int, input().split()))

# 삽입정렬 알고리즘 사용
for i in range(1, N):
    insert_point = i # 현재값이 삽입될 위치
    insert_value = P[i] # 현재값

    # 현재 값을 기준으로 왼쪽부터 역순으로 탐색
    for j in range(i - 1, -1, -1):
        if P[i] > P[j]: # 삽입하려면 값이 탐색 중인 값보다 크면
            insert_point = j + 1 # 그 다음 위치에 삽입
            break # 삽입 위치를 찾았으므로 반복 종료

        if j == 0: # 끝까지(배열의 첫번째 인덱스까지) 갔지만 위치를 못찾은 경우
            insert_point = 0 # 배열의 맨 앞으로 삽입
    
    for j in range(i, insert_point, -1): # 삽입 위치까지 데이터를 한 칸씩
        P[j] = P[j-1]
    P[insert_point] = insert_value # 삽입 위치에 값 삽입

# 리스트 P의 합 배열 S
S = [0] * N
S[0] = P[0]

# 합 배열 생성
for i in range(1, N):
    S[i] = S[i-1] + P[i]

print(sum(S))