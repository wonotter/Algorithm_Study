import sys
input = sys.stdin.readline

# 'A'는 1개 이상, 'C'는 1개 이상 등 조건을 체크하는 체크리스트
checkList = [0] * 4

# 범위 P인 부분문자열에 담긴 문자 종류의 개수를 담는 나의 리스트
myList = [0] * 4

# 체크리스트와 나의 리스트를 myadd, myremove 함수에서 매번 비교하면서
# 개수가 같을 경우 더하거나 뺀다
checkSecret = 0

# 문자를 하나씩 추가하는 함수
def myadd(c):
    global checkList, myList, checkSecret
    if c == 'A':
        myList[0] += 1
        # 나의 리스트에 카운트한 문자 A가 체크리스트의 A의 개수와 조건이 맞을 경우
        if myList[0] == checkList[0]:
            checkSecret += 1 # Secret 값 증가

    elif c == 'C':
        myList[1] += 1
        # 나의 리스트에 카운트한 문자 C가 체크리스트의 C의 개수와 조건이 맞을 경우
        if myList[1] == checkList[1]:
            checkSecret += 1 # Secret 값 증가
    
    elif c == 'G':
        myList[2] += 1
        # 나의 리스트에 카운트한 문자 G가 체크리스트의 G의 개수와 조건이 맞을 경우
        if myList[2] == checkList[2]:
            checkSecret += 1 # Secret 값 증가
    
    elif c == 'T':
        myList[3] += 1
        # 나의 리스트에 카운트한 문자 T가 체크리스트의 T의 개수와 조건이 맞을 경우
        if myList[3] == checkList[3]:
            checkSecret += 1 # Secret 값 증가

# 문자를 하나씩 빼는 함수
def myremove(c):
    global checkList, myList, checkSecret
    if c == 'A':
        # 나의 리스트에 카운트한 문자 A가 체크리스트의 A의 개수와 조건이 맞을 경우
        if myList[0] == checkList[0]:
            checkSecret -= 1 # Secret 값 감소
        myList[0] -= 1
    
    elif c == 'C':
        # 나의 리스트에 카운트한 문자 C가 체크리스트의 C의 개수와 조건이 맞을 경우
        if myList[1] == checkList[1]:
            checkSecret -= 1 # Secret 값 감소
        myList[1] -= 1

    elif c == 'G':
        # 나의 리스트에 카운트한 문자 G가 체크리스트의 G의 개수와 조건이 맞을 경우
        if myList[2] == checkList[2]:
            checkSecret -= 1 # Secret 값 감소
        myList[2] -= 1

    elif c == 'T':
        # 나의 리스트에 카운트한 문자 T가 체크리스트의 T의 개수와 조건이 맞을 경우
        if myList[3] == checkList[3]:
            checkSecret -= 1 # Secret 값 감소
        myList[3] -= 1

answer = 0

S, P = map(int, input().split())
DNA = list(input())
checkList = list(map(int, input().split()))

# 값이 0이라는 것은 특정 문자열이 이미 조건을 만족하므로
for i in range(4):
    if checkList[i] == 0:
        checkSecret += 1 # Secret 값 증가

# 길이 P만큼 문자를 하나씩 나의 리스트에 카운트
for i in range(P):
    myadd(DNA[i])

# Secret 값이 4라는 것은 {'A', 'C', 'G', 'T'}가
# 최소 몇 개 이상어이야 하는 지에 대한 조건을 만족했다는 의미
if checkSecret == 4:
    answer += 1 # 정답 값 증가

# P부터 S까지 반복하면서
for i in range(P, S):
    # 가장 앞쪽부터 위치한 문자를 제거하기 위해 필요한 인덱스 j
    j = i - P

    # 가장 끝부분에 문자 1개 추가
    myadd(DNA[i])

    # 가장 앞부분에 문자 1개 제거
    myremove(DNA[j])

    # 변경된 부분 문자열에서 조건을 만족하는 경우
    if checkSecret == 4:
        answer += 1

print(answer)