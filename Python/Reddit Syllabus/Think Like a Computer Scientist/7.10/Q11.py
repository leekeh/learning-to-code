def is_rightangled(a, b, c):
    if c>a and c>b:
        return abs(a**2+b**2 - c**2) < 0.001
    elif b>a:
        return abs(a**2+c**2 - b**2) < 0.001
    else:
        return abs(b**2+c**2 - a**2) < 0.001
