function factorial (n) {
    let result = n;
    for (let i = n-1; i>0; i--) {
        result *= i;
    }
    return result
}
