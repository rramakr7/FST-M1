#Tuple Number Checker
#Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5

numbers_tuple = tuple(input("Enter a list of comma separated numbers: ").split(","))

print("Numbers divisible by 5 are: ")
for x in numbers_tuple:
    if int(x)%5 == 0:
        print(str(x))


