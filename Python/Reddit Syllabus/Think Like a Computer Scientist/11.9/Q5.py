import turtle

data =  open("mystery.txt", "r")

bby = turtle.Turtle()
bby.color("DarkTurquoise")
bby.speed(10)
wn = turtle.Screen()
wn.setworldcoordinates(-300, -300, 300, 300)

for line in data:
    elem = line.split()
    if elem[0] == "UP":
            bby.penup()
    elif elem[0] == "DOWN":
            bby.pendown()
    else:
        x = elem[0]
        y = elem[1]
        bby.goto(x, y) 
