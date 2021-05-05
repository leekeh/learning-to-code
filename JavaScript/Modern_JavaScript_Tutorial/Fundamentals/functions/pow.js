function pow(x,n) {
  if (n>=1) {
    return x **n;
  }
  return `Power ${n} is not supported, use a positive integer`;
}

let x = prompt("What should x be?", 0)

let n = prompt("What should n be?", 1)

alert(pow(x,n));
