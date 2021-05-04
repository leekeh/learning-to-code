let input=0;
while (100>input && in) {
  input = prompt("Gimme a nr", 0);
  if (input == null) {
    break;
  }
}
   
//better example:
let num;

do {
  num = prompt("Enter a number greater than 100?", 0);
} while (num <= 100 && num)
