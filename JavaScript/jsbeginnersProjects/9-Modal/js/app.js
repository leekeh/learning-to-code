let images = document.getElementsByClassName("img-container");

let modalbox = document.getElementsByClassName("lightbox-item")[0];
let modalcontainer = document.querySelector(".lightbox-container");
let modalImg;

let imgSources = [];
let index;

const btClose = document.getElementsByClassName("lightbox-close")[0];
const btLeft = document.getElementsByClassName("lightbox-control btnLeft")[0];
const btRight = document.getElementsByClassName("lightbox-control btnRight")[0];

Array.prototype.forEach.call(images, function (image) {
  //This function adds events listeners and collects all images to be cycled through
  imgSources.push(image.getElementsByTagName("img")[0].getAttribute("src"));

  image.addEventListener("click", function () {
    console.log("clicked an image");
    modalImg = image.getElementsByTagName("img")[0].cloneNode(true);
    index = imgSources.indexOf(modalImg.getAttribute("src"));
    modalbox.appendChild(modalImg);
    modalcontainer.classList.add("show");
  });
});

btClose.addEventListener("click", function () {
  modalbox.removeChild(modalImg);
  modalcontainer.classList.remove("show");
});

btLeft.addEventListener("click", function () {
  index--;
  if (index == -1) {
    index = imgSources.length - 1;
  }
  modalImg.src = imgSources[index];
});

btRight.addEventListener("click", function () {
  index++;
  if (index == imgSources.length) {
    index = 0;
  }
  modalImg.src = imgSources[index];
});
