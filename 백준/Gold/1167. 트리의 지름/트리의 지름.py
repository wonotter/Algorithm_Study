import sys
input = sys.stdin.readline
from collections import deque

V = int(input())
A = [[] for _ in range(V + 1)]

for _ in range(V):
    Data = list(map(int, input().split()))
    index = 0
    start = Data[index] # 시작 노드 번호
    index += 1

    while True:
        end = Data[index] # 끝 노드 번호
        # -1인 경우 입력 종료
        if end == -1:
            break
        edge = Data[index + 1] # 시작에서 끝 노드 간의 간선거리
        A[start].append((end, edge)) # (끝 노드, 간선)과 같이 튜플 형태로 추가
        index += 2 # 다음 정보를 받기 위해 인덱스 증가

visited = [False] * (V + 1) # 방문리스트
distance = [0] * (V + 1) # 거리 정보를 저장할 리스트

def BFS(v):
    queue = deque()

    # 탐색을 시작하는 노드를 큐에 push
    visited[v] = True
    queue.append(v)

    # 큐가 비어있을때까지 탐색 진행
    while queue:
        now_Node = queue.popleft() # 현재 노드를 pop

        # 현재 노드를 기준으로 (끝 노드, 간선)을 하나씩 들고옴
        for i in A[now_Node]:
            # 아직 방문하지 않은 노드라면
            if not visited[i[0]]:
                # 큐에 push
                visited[i[0]] = True
                queue.append(i[0])

                # 시작 노드가 가진 간선 정보와 끝 노드가 가진 간선 정보를 더하여 새로운 간선 정보 업데이트
                distance[i[0]] = distance[now_Node] + i[1]

# 임의의 노드에서 탐색 시작
BFS(1)
Max = 1

# 거리가 가장 먼 노드를 찾아내어
# 지름의 끝점을 파악
for i in range(2, V + 1):
    if distance[Max] < distance[i]:
        Max = i

# 거리가 가장 먼 노드를 기준으로 다시 BFS 탐색
visited = [False] * (V + 1)
distance = [0] * (V + 1)
BFS(Max)

# 거리 오름차순 정렬
distance.sort()
# 트리에서 가장 멀리있는 노드 (트리의 지름) 출력
print(distance[V])