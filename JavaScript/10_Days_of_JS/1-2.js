"use strict"

function vowelsAndConsonants(s) {
    for (let i=0; i < s.length ; i++) {
        let char = s.charAt(i)
        if (isvowel(char)) {
            console.log(char)
        }
    }
    for (let i=0; i < s.length ; i++) {
        let char = s.charAt(i)
        if (!isvowel(char)) {
            console.log(char)
        }        
    }
}

function isvowel(char) {
    if  (char == "a" || char == "e" || char == "i" || char == "o" || char == "u") {
        return true;
    }
    return false;
}
