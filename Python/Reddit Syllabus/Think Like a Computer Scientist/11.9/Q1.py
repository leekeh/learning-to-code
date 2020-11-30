with open("studentdata.txt") as tx:
    for line in tx:
        content = line.split()
        if len(content) > 6:
            print(content[0])
            
