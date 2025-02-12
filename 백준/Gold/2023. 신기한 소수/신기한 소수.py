import sys, math
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

N = int(input())

# 소수 판별 알고리즘
def isPrime(num):
    if num < 2: return False
    if num == 2: return True
    if num % 2 == 0: return False

    sqrt_num = int(math.sqrt(num))
    # 입력된 값의 절반까지 나머지셈을 진행
    for i in range(3, sqrt_num + 1, 2):
        # 나누어 떨어지는 경우, 즉 약수를 찾은 경우
        if num % i == 0:
            return False # 가지치기 진행
    return True # 소수이므로 DFS 탐색 진행
        
def DFS(num):
    # 주어진 수의 길이가 N을 도달한 경우
    if len(str(num)) == N:
        print(num)
    
    # 주어진 수 * 10 + i를 소수인지 판별해보면서
    # DFS 탐색을 진행할지 가치지기를 진행할지 판단
    else:
        for i in range(1, 10, 2):
            # 뒤에 홀수를 붙이면서 소수인지 판별하도록 실행
            if isPrime(num * 10 + i):
                DFS(num * 10 + i)

DFS(2)
DFS(3)
DFS(5)
DFS(7)