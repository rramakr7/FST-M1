#Adding List Numbers
#Write a function sum() such that it can accept a list of elements and print the sum of all elements

def sum(numbers):
    sum = 0
    for n in numbers:
        sum = sum+n
    return sum

numList = [10,20,30,40,50]

result = sum(numList)

print("Sum of all the numbers in the list is " + str(result))