import matplotlib.pyplot as plt
import numpy as np
plt.plot(np.random.randn(50).cumsum())
plt.savefig("test1.png")

#pass by object reference
l2=[]
l1=[0,1,2]
print(l2)
print(l1)
print(id(l2))
print(id(l1))
l2=l1
l1.append(3)
print(l2)
print(l1)
print(id(l2))
print(id(l1))

##############################################
l2=[1,2,3,4] # a list named array
pivot=2
less=[]
greater=[]

for num in l2:
    if num < pivot:
        less.append(num)
    else:
        greater.append(num)

print(less)
print(greater)
#################################################

l2=[1,2,3,4] # a list named array
pivot=2
less=[]
greater=[]

for i in range(len(l2)):
    if l2[i] < pivot:
        less.append(l2[i])
    else:
        greater.append(l2[i])

print(less)
print(greater)

##################################################
s = r'this\has\no\special\characters'
print(s)
s2='this\\has\\no\\special\\characters'
print(s2)

#################################################
sequence = [1, 2, None, 4, None, 5]
total = 0
for value in sequence:
    if value is None:
        continue
    total += value

print(total)

sequence = [1, 2, 0, 4, 6, 5, 2, 1]
total_until_5 = 0
for value in sequence:
    if value == 5:
        break
    total_until_5 += value

print(total_until_5)

######################################
x=5
# if x>=0:
#     result = 'Non-negative'
# else:
#     result = 'Negative'

# print(result)

# or as ternary expression
result = 'Non-negative' if x>=0 else 'Negative'

print(result)

#list comprehenstions

list_strings = ['b', 'is', 'cat', 'far', 'love', 'python']




