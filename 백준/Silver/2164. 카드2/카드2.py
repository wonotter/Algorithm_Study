from collections import deque

N = int(input())
mydeque = deque()

for i in range(1, N + 1):
    mydeque.append(i)

while len(mydeque) != 1:
    mydeque.popleft()

    ins = mydeque.popleft()
    mydeque.append(ins)

print(mydeque.pop())
