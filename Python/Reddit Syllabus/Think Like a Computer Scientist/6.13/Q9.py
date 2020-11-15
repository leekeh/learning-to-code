import turtle
wn = turtle.Screen()
tess = turtle.Turtle()

def drawpentagram(sz,t):
    for i in range (5):
        t.forward(sz)
        t.right(144)
            
drawpentagram(100, tess)
