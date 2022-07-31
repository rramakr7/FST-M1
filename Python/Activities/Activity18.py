#Reading CSV Files
"""
Read the CSV made in the previous program:
Print the values only in the Usernames column
Print the username and password of the second row
Sort the Usernames column data in ascending order and print data
Sort the Passwords column in descending order and print data
"""

import pandas

dataframe = pandas.read_csv("sample.csv")
print("Full Data:")
print(dataframe)
print("======================================")
print("Values in the Username column:")
print(dataframe["Usernames"])
print("======================================")
print("Username: " + dataframe["Usernames"][1],"|","Password: " + dataframe["Passwords"][1])
print("======================================")
print("Data sorted with ascending usernames:")
print(dataframe.sort_values('Usernames'))
print("=======================================")
print("Data sorted with descending passwords:")
print(dataframe.sort_values('Passwords',ascending=False))
