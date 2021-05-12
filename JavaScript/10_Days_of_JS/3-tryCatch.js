function reverseString(s) {
    var result;
    try {
        var splitString = s.split("");
        var reversedArray = splitString.reverse();
        result = reversedArray.join("");
    } catch (err) {
        console.log(err.message);
        result = s;
    } finally {
        console.log(result);
    }
}
