import turtle

wn = turtle.Screen()
wn.bgcolor("lightgreen")

alex = turtle.Turtle()
alex.color("blue")

alex.speed(10)

def sqspiral(t,sz,layers):
    '''A function that creates the image of a spiral
    based on the total size and the amount of layers given''' 
    di = 1
    for i in range (layers*2): #do as many loops as it takes to get the given layers, twice because each loop makes half a square/layer
        di += (sz/(layers*2)) #increment in distance is based on total size and layers
        for j in range (2):
            t.forward(di)
            t.right(90)
        
sqspiral(alex, 200, 20)
