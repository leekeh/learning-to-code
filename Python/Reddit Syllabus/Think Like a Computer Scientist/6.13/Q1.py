
import turtle

def drawSquare(t, sz):
    """Get turtle t to draw a square of sz side"""
    t.pendown()
    for i in range(4):
        t.forward(sz)
        t.left(90)
    t.penup()
    t.forward(sz*2)

def main(amount, t, sz):
    for i in range (amount):
        drawSquare (t, sz)
        
wn = turtle.Screen()
wn.bgcolor("lightgreen")

alex = turtle.Turtle()
alex.color("pink")

main(4, alex, 20)

wn.exitonclick()
