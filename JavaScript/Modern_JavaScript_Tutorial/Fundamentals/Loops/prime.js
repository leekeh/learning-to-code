let n = prompt("Untill when should we check for primes?", 0);

outer: for (let i=2; i<=n; i++) {
  for (let j=2; j<i; j++) {
    if (i%j==0) continue outer;
  }
  alert(i);
}
