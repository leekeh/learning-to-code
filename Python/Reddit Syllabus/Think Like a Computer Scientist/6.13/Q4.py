import turtle
wn = turtle.Screen()
wn.bgcolor("lightgreen")

alex = turtle.Turtle()
alex.color("blue")

alex.speed(10)

def drawSquare(t, sz):
    """Get turtle t to draw a square of sz side"""
    for i in range(4):
        t.forward(sz)
        t.left(90)
        
def main(t,sz, amount):
    for i in range (amount):
        for j in range (4):
            drawSquare(t,sz)
            t.right(90)
        t.right(90/amount)
    
    
main(alex, 90, 5)
