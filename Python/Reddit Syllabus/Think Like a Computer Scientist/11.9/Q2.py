with open("studentdata.txt") as tx:
    for line in tx:
        content = line.split() #makes it easier to work with content of file
        name = content[0][0].upper() + content[0][1:] #create capitalized name
        som = 0 
        for num in content[1:]:
            som+= int(num)
        print ("{} has an average of {:.2f}%".format(name, som/len(content[1:])))
