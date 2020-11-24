def max(lst):
    result = lst[0]
    for item in lst:
        if item>result:
            result=item
    return result
