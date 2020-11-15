def mySqrt(n):
    guess = n/2 #initial guess
    for i in range (100): #each loop adding more precision
        guess = 0.5 * (guess + (n/guess))
    return guess
