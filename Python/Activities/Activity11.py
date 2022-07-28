#Fruit Shop
#Create a Python dictionary that contains a bunch of fruits and their prices.
#Write a program that checks if a certain fruit is available or not.

fruit_dict = {
    "apple": 120,
    "banana": 80,
    "grapes": 100,
    "orange": 70,
    "guava": 80
}

fruit_check = input("What are you looking for ? ").lower()

if fruit_check in fruit_dict:
    print("Yes, this is available")
else:
    print("No, this isn't available")
