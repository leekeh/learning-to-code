import random

reference = ["distribution", "drown", "decisive", "condemned", "church", "itch", "selective", "frighten", "power",
             "closed", "cow", "apparel"
             ]

solution = random.choice(reference)
x = 10
guessed = []
totalanswers = len(solution)*["_"]
while x>0:
    while totalanswers!=solution:
        a =(input("Pick a letter: ")).lower()
        if len(a) != 1:
            print ("Please pick a letter.")
        elif a in guessed:
            print ("Oops! You guessed that one already. Here's the list of tried letters: {}.".format(guessed))
        else:
            guessed.append(a)
            if a in solution:
                for i, ltr in enumerate(list(solution)):
                    if ltr == a:
                        totalanswers[i]=a
                if   ''.join(totalanswers) == solution:
                    print("You did it! The word was {}.".format(solution))
                    exit
                else:
                    print ("That is right! \n Here's what we have so far: {}. \nTries remaining: {}. Tried letters: {}".format(totalanswers, x, guessed))
            else:
                x -=1
                if x>0:
                    print ("Oh no! {} is not correct. You have {} tries remaining. \n Here's all the characters tried so far: {} ".format(a,x,guessed))
                else:
                    print ("Oh no! You have run out of tries. The word was {}.".format(solution))
                    break