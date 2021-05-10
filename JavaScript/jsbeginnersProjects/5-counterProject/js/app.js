const btnLower = document.getElementsByClassName("btn counterBtn prevBtn text-uppercase m-2")[0];
const btnUpper = document.getElementsByClassName('btn counterBtn nextBtn text-uppercase m-2')[0];
var counter = 0;

btnLower.addEventListener("click", function(){
  counter--;
  document.getElementById("counter").innerHTML = counter;
  setColor();
})

btnUpper.addEventListener("click", function(){
  counter++;
  document.getElementById("counter").innerHTML = counter;
  setColor();
})

function setColor(){

  if (counter<0){
    document.getElementById("counter").style.color = "red";
  } else if (counter>0) {
    document.getElementById("counter").style.color = "green";
  } else if (counter==0) {
    document.getElementById("counter").style.color = ""
  }
  document.getElementById("counter").style.color
}