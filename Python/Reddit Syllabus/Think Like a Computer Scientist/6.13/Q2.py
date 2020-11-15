import turtle
wn = turtle.Screen()
wn.bgcolor("lightgreen")

alex = turtle.Turtle()
alex.color("pink")

def drawSquare(t, sz):
    """Get turtle t to draw a square of sz side"""
    for i in range(4):
        t.forward(sz)
        t.left(90)
        
def main(t,amount):
    sz = 20
    for i in range(amount):
        drawSquare(t, sz)
        t.penup()
        t.backward(10)
        t.right(90)
        t.forward(10)
        t.left(90)
        t.pendown()
        sz +=20

main(alex, 5)
