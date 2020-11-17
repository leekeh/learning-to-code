import math
def myPi(iters):
    ser = 1
    div = 3
    for i in range (1, iters+1):
        if i%2 == 0:
            ser += 1/(div*3**i)
        else:
            ser -= 1/(div*3**i)
        div +=2
    return math.sqrt(12)*ser

print (myPi(21))
