def computeFactorial(number):
    if number < 0:
        return "we can't handle negative factorials, yet.."
    elif number < 2:
        return 1
    else:
        return number * computeFactorial(number-1)
