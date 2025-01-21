import sys
input = sys.stdin.readline

# 시간복잡도 O(N)에 해결하기 위해 덱 사용
# 덱은 튜플로 (값, 인덱스) 형태로 저장됨
# e.g. mydeque = [(1, 0), (2, 1), (3, 2)]
from collections import deque

N, L = map(int, input().split())
mydeque = deque() # 비어있는 덱 선언
A = list(map(int, input().split()))

for i in range(N):
    # 마지막 요소의 값이 입력값보다 클 경우
    while mydeque and mydeque[-1][0] > A[i]: # mydeque[-1][0]은 마지막 요소의 값을 들고옴
        mydeque.pop() # 마지막 요소값 제거
    
    # 입력값을 덱에 새롭게 추가
    mydeque.append((A[i], i))

    # 첫번째 요소의 값이 윈도우 범위를 벗어난 경우
    # 첫번째 요소의 인덱스 값과 윈도우 범위를 비교해주면 됨
    # e.g. mydeque[0][1] == 0
    # e.g. i = 3, L = 3, i - L == 0
    if mydeque[0][1] <= i - L:
        mydeque.popleft() # 첫번째 요소값 제거
    
    print(mydeque[0][0], end=' ') # 최소값은 항상 가장 첫번째 요소값