
def myPi(iters):
    div = 1 #divisor
    result = 1
    for i in range (iters):
        div += 2
        if i%2 == 0:
            result -= (1/div)
        else:
            result += (1/div)
    return result*4

print(myPi(1000000))
