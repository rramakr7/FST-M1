#Combining Lists
#Given a two list of numbers create a new list such that new list should contain only odd numbers from the first list and even numbers from the second list.

first_List = [2,5,10,11,14,16,17]
second_List = [1,13,19,10,16,18,20]

print("First list: ", first_List)
print("Second list: ",second_List)

thirdList = []

for number in first_List:
    if (number%2 != 0):
        thirdList.append(number)
for number in second_List:
    if (number%2 == 0):
        thirdList.append(number)

print("Result list is: ",thirdList)
