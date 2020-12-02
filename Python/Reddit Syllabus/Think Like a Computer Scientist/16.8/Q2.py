def reverseList(lst):
    if len(lst) <1:
        return []
    if len(lst) <2:
        return [lst[0]]
    else:
        return [lst[-1]] + reverseList(lst[:-1])
