def fibonacci (amount):
    sequence = [0,1]
    for i in range (amount-2):
        sequence.append(int(sequence[-1])+int(sequence[-2]))
    print (sequence)
