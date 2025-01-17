N = int(input())
sum = 1
count = 1
start_idx = 1
end_idx = 1

while end_idx != N:
    # 정답인 경우
    if sum == N:
        # 정답 카운트
        count += 1

        # 연속된 자연수의 범위를 한 칸 확장시킴
        end_idx += 1

        # 확장한 자연수를 합계에 추가
        sum += end_idx

    # 연속된 자연수의 합이 입력된 수보다 클 경우
    elif sum > N:
        # 연속된 자연수의 시작지점 인덱스를 합에서 뺀 후
        sum -= start_idx

        # 연속된 자연수에서 왼쪽 값 삭제
        start_idx += 1

    # 연속된 자연수의 합이 입력된 수보다 작을 경우
    else:
        # 연속된 자연수의 범위를 한 칸 확장시킴
        end_idx += 1

        # 확장한 자연수를 합계에 추가
        sum += end_idx

print(count)