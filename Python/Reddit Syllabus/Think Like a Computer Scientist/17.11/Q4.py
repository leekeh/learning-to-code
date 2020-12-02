    def get_line_to(self, other): #returns elemens of y = ax + b that describes line
        a= (other.y-self.y)/(other.x-self.x)
        b= self.y - a*self.x
        return (a, b)
