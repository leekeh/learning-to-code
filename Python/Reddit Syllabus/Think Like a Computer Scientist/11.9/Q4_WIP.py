import turtle

data =  open("labdata.txt", "r")

bby = turtle.Turtle()
bby.shape("circle")
bby.color("blue")
#bby.shapesize(1.0, 1.0, 1) ==> why does this not work??
wn = turtle.Screen()
wn.setworldcoordinates(0, 0, 100, 100) #todo

def plotRegression(data, turtle):
    turtle.penup()
    totalx=0
    totaly=0
    counter = 0
    for line in data:
        x = int(line.split()[0])
        y = int(line.split()[1])
        xlist = 
        ylist = 
        totalx += x #calculate mean at the same time
        totaly += y
        counter += 1
        turtle.goto(x, y)
        turtle.stamp()
    avgx = totalx / counter
    avgy = totaly / counter
    m = sum
        
plotRegression(data, bby)

        
'''x,y
x,y etc
x = mean x values
y = mean y values
n = number of points '''
