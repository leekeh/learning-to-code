document.getElementById("btn").addEventListener("click", changeBGColor);

function changeBGColor(){
    let color = generateHexColor();
    document.body.style.backgroundColor = color;
    updateHeader(color)   
}

function generateHexColor(){
    let hexColors = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"];
    let result = "#";
    for (let i=0; i<=5; i++){
        result += hexColors[Math.floor(Math.random()*15)];
    }
    return(result);
}

function updateHeader(color) {
    document.getElementById("hex-value").innerHTML = color;
}