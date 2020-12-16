class Point:

    def __init__(self, initX, initY):
        """ Create a new point at the given coordinates. """
        self.x = initX
        self.y = initY

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def distanceFromOrigin(self):
        return ((self.x ** 2) + (self.y ** 2)) ** 0.5

    def __str__(self):
        return "x=" + str(self.x) + ", y=" + str(self.y)

    def halfway(self, target):
         mx = (self.x + target.x) / 2
         my = (self.y + target.y) / 2
         return Point(mx, my)

class Rectangle:
    """rectangle defined by left corner, width and height"""
    def __init__(self, point, width, height):
        self.llcorner = point
        self.width = width
        self.height = height
        self.xmin = point.x
        self.xmax = point.x + width
        self.ymin = point.y
        self.ymax = point.y + height
        
    def __str__(self):
        return "a rectangle of {} by {}, starting at {}".format(self.width, self.height, self.llcorner)
        
    def getWidth(self):
        return self.width
    def getHeight(self):
        return self.height
    def area(self):
        return self.width * self.height
    def peri(self):
        return self.width*2 + self.height*2
    def trans(self):
        self.width, self.height = self.height, self.width
        #swaps these values
        
    def contains(self, Point):
        xa = self.llcorner.x
        xb = xa + self.width
        ya = self.llcorner.y
        yb = ya + self.height
        return Point.x >= self.xmin and Point.x < self.xmax and Point.y >= self.ymin and Point.y < self.ymax
    
    def diagonal(self): 
        return (self.height**2 + self.width**2)**0.5
    
    def collide (sq1, sq2):
        if sq1.xmin > sq2.xmax and sq1.ymin > sq2.ymax:
            return False
        elif sq2.xmin > sq1.xmax and sq2.ymin > sq1.ymax:
            return False
        else:
            return True
        
