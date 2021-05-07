const button = document.querySelector("button");
button.addEventListener("click", changecolor);

function changecolor() {
    document.body.style.backgroundColor = randomColor();
}

function randomColor() {
    let red = Math.floor(Math.random()*255);
    let green = Math.floor(Math.random()*255);
    let blue = Math.floor(Math.random()*255);
    return "rgb(" + red + ", " + green + ", " + blue + ")";
}