import turtle
wn = turtle.Screen()
wn.bgcolor("lightgreen")

tess = turtle.Turtle()
tess.color("pink")

def drawPoly(t, sd, sz):
    for i in range (sd):
        t.forward(sz)
        t.left(360/sd)
        
drawPoly(tess, 8, 50)
