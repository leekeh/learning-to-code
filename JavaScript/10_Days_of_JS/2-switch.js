function getLetter(s) {
    
    switch (s[0]) {
        case "a":
        case "i":
        case "u":
        case "e":
        case "o":
        return "A";
        
        case "b":
        case "c":
        case "d":
        case "f":
        case "g":
        return "B";
        
        case "h":
        case "j":
        case "k":
        case "l":
        case "m":
        return "C";
        
        default:
        return "D";

    }
}
