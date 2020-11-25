def sumUntilEven(lst):
    result = 0
    i = 0
    while i < len(lst) and lst[i]%2!=0:
        result += lst[i]
        i += 1
    return result
