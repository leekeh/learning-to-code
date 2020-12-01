def countlet(string):
    dicti = {}
    for letter in string.lower():
        if not letter.isalpha():
            pass
        elif letter not in dicti:
            dicti[letter] = 1
        else:
            dicti[letter] += 1
    for key, value in sorted(dicti.items()):
        print (key, value)
        
countlet("This is our example string here")
