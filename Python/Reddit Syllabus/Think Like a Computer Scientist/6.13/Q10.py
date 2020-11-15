import turtle
wn = turtle.Screen()
tess = turtle.Turtle()
tess.speed(10)

def drawpentagram(sz,t):
    for i in range (5):
        t.forward(sz)
        t.right(144)
            
def main(sz,t):
    t.penup()
    t.backward(150)
    t.pendown()
    for i in range (5):
        drawpentagram(sz,t)
        t.penup()
        t.forward(350)
        t.right(144)
        t.pendown()
            
main(100, tess)
