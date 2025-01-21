import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

answer =[0] * N # 결과를 저장할 배열
stack = [] # 현재 탐색 중인 인덱스를 저장

for i in range(N):
    # 스택이 비어있지 않고, 입력값이 스택의 top에 위치한 인덱스보다 큰 경우
    # top에 위치한 스택을 pop하여 answer에 현재 값을 저장한다

    # 정리하면 오큰수를 발견한 경우 while문을 통해 오큰수의 조건을 만족할때까지 반복하면서
    while stack and A[stack[-1]] < A[i]:
        # 스택에서 인덱스를 pop한 것을 answer 인덱스 위치에 오큰수의 정답으로 저장
        answer[stack.pop()] = A[i]
    
    # 입력값 인덱스인 i를 스택에 추가
    stack.append(i)

# 스택에 남은 값 처리
while stack:
    # 이 경우는 오른쪽에 자신보다 큰 숫자가 없는 경우
    answer[stack.pop()] = -1
    
for i in range(N):
    print(str(answer[i]), end=" ")