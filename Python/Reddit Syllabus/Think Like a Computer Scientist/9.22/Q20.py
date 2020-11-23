def remove_dups(astring):
    newstring = ""
    for char in astring:
        if char not in newstring:
            newstring += char
    return newstring

print(remove_dups("mississippi"))   #should print misp

