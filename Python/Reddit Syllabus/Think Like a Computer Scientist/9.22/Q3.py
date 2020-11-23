def count(p):
    totalcount = 0
    ecount = 0
    for character in p:
        if character.isalpha():
            totalcount+=1
            if character.lower() == "e":
                ecount+=1
    print ('''Your text contains {} alphabetic characters, of which {} ({}%) are 'e'.'''.format(totalcount, ecount, totalcount/ecount))
