import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

N, M = map(int, input().split())
A = [[] for _ in range(N)]
visited = [False] * N

arrive = False

def DFS(v, depth):
    global arrive

    if depth == 5:
        arrive = True
        return
    
    visited[v] = True
    for i in A[v]:
        if not visited[i]:
            DFS(i, depth + 1)

    visited[v] = False

for _ in range(M):
    a, b = map(int, input().split())

    A[a].append(b)
    A[b].append(a)

for i in range(N):
    if not visited[i]:
        DFS(i, 1)
    if arrive:
        break
    
if arrive:
    print(1)
else:
    print(0)