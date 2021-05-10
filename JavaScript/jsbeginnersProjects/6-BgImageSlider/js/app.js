const images = ["./img/contBcg-0.jpeg", "./img/contBcg-1.jpeg", "./img/contBcg-2.jpeg", "./img/contBcg-3.jpeg", "./img/contBcg-4.jpeg"];
let imageContainer = document.querySelector(".img-container");
let counter = 0;

document.getElementsByClassName("btn btn-left")[0].addEventListener("click", function(){
  counter--;
  if (counter<0) {
    counter = images.length-1;
  }
  setImage();
})

document.getElementsByClassName("btn btn-right")[0].addEventListener("click", function(){
  counter++;
  if (counter> (images.length-1) ) {
    counter = 0;
  }
  setImage();
})

function setImage(){
  imageContainer.style.backgroundImage = `url('${images[counter]}')`;
}






