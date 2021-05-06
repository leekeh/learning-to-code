function multiplyNumeric(object) {
  for (let key in object){
    if (typeof object[key] != "number") continue;
    object[key] *= 2
  }
}
