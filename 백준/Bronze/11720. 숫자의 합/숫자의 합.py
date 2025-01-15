N = int(input())
num = input()

num = ",".join(num)

sum = 0
for i in num:
    if i == ",":
        continue
    else:
        sum += int(i)

print(sum)