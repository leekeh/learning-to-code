
import turtle
wn = turtle.Screen()
tess = turtle.Turtle()
tess.speed(10)

def drawSprite(t, numlegs, lenlegs):
    for i in range (numlegs):
        t.forward(lenlegs)
        t.backward(lenlegs)
        t.right(360/numlegs)
    
    
drawSprite(tess, 15, 120)
