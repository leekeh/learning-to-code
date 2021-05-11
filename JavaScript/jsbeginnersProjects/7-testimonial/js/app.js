function Customer(imgSrc, name, review) {
    this.image = imgSrc;
    this.name = name;
    this.review = review;
  }

var person1 = new Customer("img/customer-0.jpg", "henk", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam sit voluptatum illo? Quae fugiat.");
var person2 = new Customer("img/customer-1.jpg", "henk2", "textttt");
var person3 = new Customer("img/customer-2.jpg", "piet", "textsdafttt");
var person4 = new Customer("img/customer-3.jpg", "jean", "textt3tt");
var person5 = new Customer("img/customer-4.jpg", "bas", "texttt23rt");

let customers = [person1, person2, person3, person4, person5];

counter = 0;
updateContent();

document.getElementsByClassName("btn prevBtn")[0].addEventListener("click", function(){
    counter--;
    if (counter<0) {
        counter = customers.length - 1;
    }
    updateContent();
})

document.getElementsByClassName("btn nextBtn")[0].addEventListener("click", function(){
    counter++;
    if (counter> (customers.length-1)) {
        counter=0;
    }
    updateContent();
})

function updateContent() {
    let chosenOne = customers[counter];
    document.getElementById("customer-name").innerHTML = chosenOne.name;
    document.getElementById("customer-img").src = chosenOne.image;
    document.getElementById("customer-text").innerHTML = chosenOne.review;
}