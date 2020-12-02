import turtle
import random

def tree(branchLen,t, siz):
    #reduce pen size
    if branchLen < 10:
        t.color("green")
    ded = random.randrange(5,20)
    ang = random.randrange(15,45)
    if branchLen > 5:
        t.pensize(siz)
        t.forward(branchLen)
        t.right(ang)
        tree(branchLen-ded,t, siz-1)
        t.left(2*ang)
        tree(branchLen-ded,t, siz-1)
        t.right(ang)
        t.backward(branchLen)
        t.color("Sienna")

def main():
    t = turtle.Turtle()
    myWin = turtle.Screen()
    t.left(90)
    t.up()
    t.backward(100)
    t.down()
    t.color("Sienna")
    t.speed(10)
    tree(75,t, 8)
    myWin.exitonclick()

main()
