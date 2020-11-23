import image

img = image.Image("luther.jpg")
win = image.ImageWin(img.getWidth(), img.getHeight())

for row in range(img.getHeight()):
    for col in range(img.getWidth()):
        p = img.getPixel(col, row)
        avghue = (p.getRed()+p.getGreen()+p.getBlue())/3
        newpixel = image.Pixel(avghue, avghue, avghue)
        img.setPixel(col, row, newpixel)
        
img.draw(win)
