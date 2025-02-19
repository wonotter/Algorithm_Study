import sys
from queue import PriorityQueue

input = sys.stdin.readline

N = int(input())
q = PriorityQueue()

for _ in range(N):
    request = int(input())
    q.put(request)

pairs = [0] * 2
sum = 0
while q.empty() == False:
    pairs[0] = q.get()

    if q.empty():
        break
    
    pairs[1] = q.get()
    q.put(pairs[0] + pairs[1])
    sum += pairs[0] + pairs[1]

print(sum)