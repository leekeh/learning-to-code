def fibon(leng):
    if leng<2:
        return [0,1, 1, leng]
    else:
        return fibon(leng-1)+ [fibon(leng-1)[-1]+fibon(leng-1)[-2]]


print(fibon(8)) #will give 2 more than given length

