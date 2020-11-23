import image

img = image.Image("luther.jpg")
win = image.ImageWin(img.getWidth(), img.getHeight())

for row in range(img.getHeight()):
    for col in range(img.getWidth()):
        p = img.getPixel(col, row)
        newred = 0
        newpixel = image.Pixel(newred, p.getGreen(), p.getBlue())
        img.setPixel(col, row, newpixel)
        
img.draw(win)
