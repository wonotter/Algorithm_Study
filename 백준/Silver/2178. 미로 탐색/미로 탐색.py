import sys
input = sys.stdin.readline
from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

queue = deque()
N, M = map(int, input().split())
A = [[0] * M for _ in range(N)]
visited = [[False] * M for _ in range(N)]

for i in range(N):
    numbers = list(input())
    for j in range(M):
        A[i][j] = int(numbers[j])

def BFS(i, j):
    queue.append((i, j))
    visited[i][j] = True

    while queue:
        node = queue.popleft()

        for k in range(4):
            x = node[0] + dx[k]
            y = node[1] + dy[k]
            if x >= 0 and y >= 0 and x < N and y < M:
                if A[x][y] != 0 and not visited[x][y]:
                    visited[x][y] = True
                    A[x][y] = A[node[0]][node[1]] + 1
                    queue.append((x, y))

BFS(0, 0)
print(A[N - 1][M - 1])