#Fibonacci Numbers
#Using recursion: Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.

def fibonnaci(number):
    if number <= 1:
        return number
    else:
        return(fibonnaci(number-1) + fibonnaci(number-2))

totalNumbers = int(input("How many fibonnaci numbers to be generated? "))

if totalNumbers <= 0:
    print("Please enter a positive number")
else:
    print("Fibonnaci series: ")
    for i in range(totalNumbers):
        print(fibonnaci(i))
