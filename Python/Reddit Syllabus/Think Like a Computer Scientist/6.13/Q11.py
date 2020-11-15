
import turtle
wn = turtle.Screen()
tess = turtle.Turtle()
tess.speed(10)

def drawstar(n, sz,t):
    if n>3 and n%2!=0: #check if n can make a star, give error if not
        for i in range (n):
            t.forward(sz)
            t.right(180-(180/n))
    else:
        print ("That n does not work, using it would not create a star")
        raise ValueError
        
