point1 = Point(1,2)
point2 = Point(3,6)
point3 = Point(7,2)

def findcircle(p1, p2, p3):
    a= Point.distancefromPoint(p1,p2)
    b= Point.distancefromPoint(p2,p3)
    c= Point.distancefromPoint(p1, p3)
    s = (a+b+c)/2
    A = (s*(s-a)*(s-b)*(s-c))**0.5
    radi= (a*b*c)/(4*A)
    circ = math.pi*2*radi
    #Todo find center (how???)
    return radi, circ
    
print(findcircle(point1,point2,point3))
