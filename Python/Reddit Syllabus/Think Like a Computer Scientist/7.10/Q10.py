import math
def is_rightangled(a, b, c):
    return abs(math.sqrt(a**2+b**2) - math.sqrt(c**2)) < 0.0001
