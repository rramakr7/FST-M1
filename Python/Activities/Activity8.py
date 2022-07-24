#List Checker
#Given a list of numbers, return True if first and last number of a list is same.

numbers_list = list(input("Enter a list of comma separated numbers: ").split(","))
list_length = len(numbers_list)
if(numbers_list[0] == numbers_list[list_length-1]):
    print(True)
else:
    print(False)