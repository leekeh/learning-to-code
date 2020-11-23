def count(substr,theStr):
    count  = 0
    while substr in theStr:
        count+=1
        theStr = theStr.replace(substr, "", 1)
    return count
