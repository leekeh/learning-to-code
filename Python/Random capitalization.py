import random
def myfunction(text):
    listoutput = []
    for char in text:
        flip = random.randint(0,1)
        if (flip == 0):
            if len(listoutput) >= 2:
                if listoutput[-1].isupper() and listoutput[-2].isupper(): #avoid more than two of the same
                    listoutput.append(char.lower())
                else:
                    listoutput.append(char.upper())
            else:
                listoutput.append(char.upper())
        else:
            if len(listoutput) >= 2:
                if listoutput[-1].islower() and listoutput[-2].islower(): #avoid more than two of the same
                    listoutput.append(char.lower())
                else:
                    listoutput.append(char.lower())
            else:
                listoutput.append(char.lower())
    print ("".join(listoutput))
    
myfunction("Mitochondria are tiny organelles inside cells that are involved in releasing energy from food. This process is known as cellular respiration. It is for this reason that mitochondria are often referred to as the powerhouses of the cell.")
