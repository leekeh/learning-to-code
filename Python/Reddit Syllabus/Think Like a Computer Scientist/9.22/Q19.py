def decipher(string, rep):
    result = ""
    for char in string:
        r = chr((ord(char))-rep)
        if not r.isalpha():
            r = chr(ord(r)+26)
        result += r
    print (result)
    
decipher ("srwdwrC", 3)
