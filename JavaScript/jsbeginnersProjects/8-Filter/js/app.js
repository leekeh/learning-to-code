const btnAll = document.querySelector("[data-filter='all']");

const btnCakes =  document.querySelector("[data-filter='cakes']");
const btnCupcakes =  document.querySelector("[data-filter='cupcakes']");
const btnSweets =  document.querySelector("[data-filter='sweets']");
const btnDoughnuts =  document.querySelector("[data-filter='doughnuts']");

const cakes = document.querySelectorAll("[data-item='cakes']");
const cupcakes = document.querySelectorAll("[data-item='cupcakes']");
const sweets = document.querySelectorAll("[data-item='sweets']");
const doughnuts = document.querySelectorAll("[data-item='doughnuts']");


const buttons = [btnAll, btnCakes, btnCupcakes, btnSweets, btnDoughnuts];
const allCards = [cakes, cupcakes, sweets, doughnuts];

buttons.forEach(function (button) {
    button.addEventListener("click", function(e){
        e.preventDefault();
        let filter = button.getAttribute("data-filter");
        console.log("Selected filter: " + filter);
        if (filter == "all") {
            allCards.forEach(function (cards){
                setVisible(cards);
            })
        } else {
            allCards.forEach(function (cardArray){
                if (cardArray[0].getAttribute("data-item")==filter) {
                    setVisible(cardArray);
                } else {
                    setInvisible(cardArray);
                }

            })    
        }


        })
})

function setVisible(cards){
    cards.forEach(function (card){
        card.style.display = "initial";
    })

}


function setInvisible(cards){
    cards.forEach(function (card){
        card.style.display = "none";
    })

}
