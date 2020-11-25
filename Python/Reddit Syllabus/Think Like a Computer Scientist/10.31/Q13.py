def count(obj, lst):
    count = 0
    for i in lst:
        if obj == i:
            count+=1
    return count
    
def is_in(obj, lst):
    for i in lst:
        if obj == i:
            return True
    return False
    
def reverse(lst):
    return lst[::-1]
    
def index(obj, lst):
    for i in range (len(lst)-1):
        if lst[i] == obj:
            return i
    return -1
    
def insert(obj, i, lst):
    return lst[:i] + [obj] + lst[i:]


lst = [0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9]
print(count(1, lst))
print(is_in(4, lst))
print(reverse(lst))
print(index(2, lst))
print(insert('cat', 4, lst))
