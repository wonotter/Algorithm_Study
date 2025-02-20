import sys
input = sys.stdin.readline

request = list(map(str, input().split('-')))

def MySum(i):
    sum = 0
    temp = list(map(str, i.split('+')))
    
    for i in temp:
        sum += int(i)

    return sum

answer = 0

for i in range(len(request)):
    temp = MySum(request[i])

    if i == 0:
        answer += temp
    else:
        answer -= temp

print(answer)