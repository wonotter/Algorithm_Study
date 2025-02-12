import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M = map(int, input().split())

# 인접 리스트로 그래프를 저장할 2차원 리스트
A = [[] for _ in range(N + 1)]

# 방문 여부를 체크하는 리스트
# 모든 노드를 방문하지 않은 상태(False)로 초기화
visited = [False] * (N + 1)

def DFS(v):
    visited[v] = True # 방문한 노드를 True로 표시
    # 현재 v노드에 연결된 모든 노드를 탐색 
    for i in A[v]:
        # e.g. v = 1, A[1] = [2, 5]라면
        # 1번 노드에서 인접한 2번 5번 노드에 대해 재귀함수 호출
        if not visited[i]:
            DFS(i)

# 간선의 개수만큼 입력받음
for _ in range(M):
    # 양 끝점 입력
    s, e = map(int, input().split())

    # 무방향 그래프이므로 서로 간선을 추가함
    A[s].append(e)
    A[e].append(s)

# 연결 요소를 카운트할 변수
count = 0

# 모든 정점의 개수인 N만큼 반복
for i in range(1, N + 1):
    # 인접 리스트 A에서 방문하지 않은 노드가 있다면
    if not visited[i]:
        count += 1 # 연결 요소 카운트
        DFS(i) # DFS 함수를 통해 연결된 모든 노드 방문 처리

print(count)