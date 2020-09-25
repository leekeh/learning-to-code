def calculate_frequencies(file_contents):
    # Here is a list of punctuations and uninteresting words you can use to process your text
    punctuations = '''!()-[]{};:'"\,<>./?@#$%^&*_~'''
    uninteresting_words = ["the", "a", "to", "if", "is", "it", "of", "and", "or", "an", "as", "i", "me", "my", \
    "we", "our", "ours", "you", "your", "yours", "he", "she", "him", "his", "her", "hers", "its", "they", "them", \
    "their", "what", "which", "who", "whom", "this", "that", "am", "are", "was", "were", "be", "been", "being", \
    "have", "has", "had", "do", "does", "did", "but", "at", "by", "with", "from", "here", "when", "where", "how", \
    "all", "any", "both", "each", "few", "more", "some", "such", "no", "nor", "too", "very", "can", "will", "just", \
    "on","for","may","there","in", "these", "only", "after", "into", "now", "not", "also", "other", "so", "about", "one"\
    "most", "many", "than"]
    file_contents = file_contents.lower()
    cleanstring = ""
    for char in file_contents:
        if char not in punctuations:
            cleanstring += char
    #remove punctuation
    wordlist = cleanstring.split() #splits into list
    clean_wordlist = [word for word in wordlist if word not in uninteresting_words]
    mydict={}         
    for item in clean_wordlist:
        if item not in mydict.keys():
            mydict[item]=0
        mydict[item]+=1
    
    #wordcloud
    cloud = wordcloud.WordCloud()
    cloud.generate_from_frequencies(mydict)
    return cloud.to_array()
