#Multiplication tables
#Write a Python program to create the multiplication table (from 1 to 10) of a number.

number = int(input("Enter a number between 1 to 10: "))
for x in range(1,11):
    ans = number*x
    print(str(number)+"*"+str(x)+"="+str(ans))
