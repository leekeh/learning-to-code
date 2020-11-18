
def calcEaster(year):
    if year not in range (1900, 2099):
        pass 
    a = year % 19
    b = year % 4
    c = year % 7
    d = (19*a+24)%30
    e = (2 * b + 4 * c + 6 * d + 5) % 7
    if year in (1954, 1981, 2049, 2076):
        print("Easter will be on the {} of april".format((22+d+e)-7))
    else:
        print("Easter will be on the {} of april".format(22+d+e))
        
calcEaster(1996)
