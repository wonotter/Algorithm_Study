import sys
sys.setrecursionlimit(10**6)
from collections import deque

input = sys.stdin.readline
print = sys.stdout.write

mydeque = deque()
N, M, V = map(int, input().split())
A = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)

def DFS(v):
    print(str(v) + " ")
    visited[v] = True

    for i in A[v]:
        if not visited[i]:
            DFS(i)

def BFS(v):
    mydeque.append(v)
    visited[v] = True

    while mydeque:
        node = mydeque.popleft()
        print(str(node) + " ")

        for i in A[node]:
            if not visited[i]:
                mydeque.append(i)
                visited[i] = True

for i in range(M):
    s, e = map(int, input().split())

    A[s].append(e)
    A[e].append(s)

for i in range(N + 1):
    A[i].sort()

DFS(V)
print("\n")

visited = [False] * (N + 1)

BFS(V)