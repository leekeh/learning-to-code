def cups_to_ml(cups):
    print ("{} US cups are {} milliliters".format(cups,(cups*236.588)))
def ml_to_cups(ml):
    print ("{} milliliters are {} cups".format(ml,(ml*0.00422675)))


def abcsolver(inputform):
    z=inputform.split("+")
    b=0
    if len(z)!=3:
        print("Please provide a string in the ax**2+bx+c format.")
    if len(z)==3:               #first, we have to find a b and c 
        for section in z:
            if "**2" in section:
                ax = section
            elif section.isnumeric():
                c = int(section)
            else:
                bx = section
        if ax.endswith("**2"):
            if len(ax) > 4:
                a = int(ax[:-4])
            else:
                a = 1
        else:
            print("Please provide a string in the ax**2+bx+c format.")
        for char in bx:
            if len(bx)>1:
                if char.isnumeric():
                    b += int(char)
            else:
                b = 1
        if a == 0:
            print ("Oops! Make sure a is not 0")
        elif ((b**2)-4*a*c)<0:                  #tests whether discriminant is positive
            d=(b**2)-4*a*c
            print ("The result is a complex number. This is described as -{} plus and minus the square root of {}, divided by {}".format(b,d,(2*a)))
        else:
            x1=((-b+(((b**2)-4*a*c))**0.5)/2*a)
            x2=((-b-(((b**2)-4*a*c))**0.5)/2*a)
            print ("The possible solutions are x1={:.2f} and x2={:.2f}".format(x1,x2))
abcsolver("1x**2+0x+50")
