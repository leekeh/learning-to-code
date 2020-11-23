import image

img = image.Image("luther.jpg")
win = image.ImageWin(img.getWidth(), img.getHeight())

for row in range(img.getHeight()):
    for col in range(img.getWidth()):
        p = img.getPixel(col, row)
        avghue = (p.getRed()+p.getGreen()+p.getBlue())/3
        if avghue < 140:
            newpixel = image.Pixel(0, 0, 0)
        else:
            newpixel = image.Pixel(255, 255, 255)
        img.setPixel(col, row, newpixel)
        
img.draw(win)

