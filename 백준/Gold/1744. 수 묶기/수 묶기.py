import sys
input = sys.stdin.readline
from queue import PriorityQueue

N = int(input())
Plusq = PriorityQueue()
Minusq = PriorityQueue()
one = 0
zero = 0

result = 0

for i in range(N):
    request = int(input())

    if request == 0:
        zero += 1
    elif request == 1:
        one += 1
    elif request > 1:
        Plusq.put(request * -1)
    elif request < 0:
        Minusq.put(request)

pairs = [0] * 2

while Plusq.qsize() > 1:
    pairs[0] = Plusq.get() * -1
    pairs[1] = Plusq.get() * -1

    result += (pairs[0] * pairs[1])

if Plusq.empty() == False:
    result += Plusq.get() * -1

while Minusq.qsize() > 1:
    pairs[0] = Minusq.get()
    pairs[1] = Minusq.get()

    result += (pairs[0] * pairs[1])

if Minusq.empty() == False:
    if zero == 0:
        result += Minusq.get()

result += one
print(result)