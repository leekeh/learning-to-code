
function calcSum(object){
  let sum = 0;
  for (let key in object){
    sum += object[key];
  }
  return sum;
}
