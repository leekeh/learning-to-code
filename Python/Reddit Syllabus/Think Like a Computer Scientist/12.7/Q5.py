def translator(english):

  pirate = {}
  pirate['sir'] = 'matey'
  pirate['hotel'] = 'fleabag inn'
  pirate['student'] = 'swabbie'
  pirate['boy'] = 'matey'
  pirate['restaurant'] = 'galley'
  pirate['hello'] = 'avast'
  pirate['students'] = 'swabbies'
  pirate['are'] = 'be'
  pirate['lawyer'] = 'foul blaggart'
  pirate['restroom'] = 'head'
  pirate['my'] = 'me'
  pirate['hello'] = 'avast'
  pirate['is'] = 'be'
  pirate['man'] = 'matey'
  result = []
  for word in english.split():
      if word in pirate:
          result.append(pirate[word])
      else:
          result.append(word)
  return " ".join(result)

