'''Write a program called alice_words.py that creates a text file named alice_words.txt
containing an alphabetical listing of all the words, and the number of times each occurs,
in the text version of Alice’s Adventures in Wonderland.'''

import re

with open("alicetxt", encoding="utf8") as f:
    content = f.read()

dicti = {}
content = content.lower()
content = re.sub(r'[^\w\s]', ' ', content)
pattern = r'[0-9]'
content = re.sub(pattern, ' ', content)
content = content.replace("_", " ")
allwords = content.split()
for word in allwords:
    if word not in dicti:
        dicti[word.lower()] = 1
    else:
        dicti[word.lower()] += 1


out = open('result.txt', 'w')

for word in sorted(dicti.keys()):
    out.write(word + " " + str(dicti[word]))
    out.write("\n")

out.close()
