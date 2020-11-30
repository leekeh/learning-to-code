with open("studentdata.txt") as tx:
    for line in tx:
        content = line.split() #makes it easier to work with content of file
        name = content[0][0].upper() + content[0][1:] #create capitalized name
        minimum = min(content[1:])
        maximum = max(content[1:])
        print ("{}'s lowest grade is {} and their highest is {}.".format(name, minimum, maximum))
