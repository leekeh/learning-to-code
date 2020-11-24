def countOdd(lst):
    count = 0
    for item in lst:
        if item%2==1:
            count += 1
    return count
