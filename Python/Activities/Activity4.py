#rock-paper-scissors - 2 (use of loops)

user1 = input("What is player 1's name ")
user2 = input("What is player 2's name ")

while True:
    user1_answer = input(user1 + ", What do you choose, rock, paper or scissors ").lower()
    user2_answer = input(user2 + ", What do you choose, rock paper or scissors ").lower()

    if user1_answer == user2_answer:
        print("it's a tie")
    elif user1_answer == "rock":
        if user2_answer =="scissors":
            print("Rock wins")
        else:
            print("Paper wins")
    elif user1_answer == "scissors":
        if user2_answer == "paper":
            print("Scissors win")
        else:
            print("Rock wins")
    elif user1_answer == "paper":
        if user2_answer == "rock":
            print("Paper wins!")
        else:
            print("Scissors win!")
    else:
        print("Invalid inputs, try again")

    repeat = input("Do you want to play another round ? Yes/No: ").lower()
    if repeat == "yes":
        pass
    elif repeat =='no':
        raise SystemExit
    else:
        print("You entered an invalid answer, exiting now")
        raise SystemExit