# 입력 시간을 줄여줄 수 있도록 sys.stdin.readline 사용
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num_arr = [[0] * (N + 1)]
sum_arr = [[0] * (N + 1) for _ in range(N + 1)]

# 원본 배열 입력받기
for i in range(N):
    num_row = [0] + [int(x) for x in input().split()]
    num_arr.append(num_row)

# 합 배열 저장하기
for i in range(1, N + 1):
    for j in range(1, N + 1):
        # sum_arr[i][j-1] + sum_arr[i-1][j]를 연산하면 이미 sum_arr[i-1][j-1]은 2번 더해짐
        # 따라서 sum_arr[i-1][j-1]을 빼준 다음
        # 2차원 배열 대각선 마지막 원소(끝 지점)에 해당하는 원본배열의 num_arr[i][j]를 더함
        sum_arr[i][j] = sum_arr[i][j - 1] + sum_arr[i - 1][j] - sum_arr[i - 1][j - 1] + num_arr[i][j]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())

    # 구간 합을 구할 시작지점인 sum_arr[x1][y1]과 가장 대각선 밑 좌표(끝 지점)인 sum_arr[x2][y2]가 있음
    # 가장 대각선 밑(끝 지점)인 sum_arr[x2][y2]에서
    # y2를 기준으로 행에 해당하는 x1 - 1 좌표 값 만큼 빼줌
    # x2를 기준으로 열에 해당하는 y1 - 1 좌표 값 만큼 빼줌
    # 중복으로 2번 뺄셈이 진행된 x1-1, y1-1 좌표 값을 다시 더함
    result = sum_arr[x2][y2] - sum_arr[x1 - 1][y2] - sum_arr[x2][y1 - 1] + sum_arr[x1 - 1][y1 - 1]
    print(result)