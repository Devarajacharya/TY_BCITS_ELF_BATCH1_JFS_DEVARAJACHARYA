function showAlert() {
    alert("Hi Welcome to cinema Hall")
}



var ele = document.createElement("h1")
function showmsg() {
    ele.textContent = "Hai Hello";
    document.body.appendChild(ele)
    ele.style.fontSize = '40px'
    ele.style.color = 'green'
}

// function displayele() {
// var dispElement = document.getElementById('disp')
// dispElement.style.display = 'block'
// hidelement()
// }

// function hidelement(){
// var hideElement = document.getElementById('disp')
// hideElement.style.display = 'none'
// }


function dispElements() {

    var dispElement = document.getElementById('disp')
    var mybtn = document.getElementById('mybtn');
    if (dispElement.style.display === '' || dispElement.style.display === 'none') {
        dispElement.style.display = 'block'
        mybtn.textContent = 'click here to hide h1 element'
    } else {
        dispElement.style.display = 'none'
        mybtn.textContent = 'click here to show h1 element'
    }
}


// ***********************************************//

function change1() {
    var dispElement = document.getElementById('para1')
    dispElement.style.color = "blue"
    dispElement.style.fontSize = "50px"
}
function change2() {
    var dispElement = document.getElementById('para1')
    dispElement.style.color = "Green"
    dispElement.style.fontSize = "31px"


}

// *************************************************//

function showdata(){
    console.log("Working...")
}

function showdetail(){
    console.log("Onkey Down executed")
}


// function showdetail(){
//     var dispElement = document.getElementById('id')
//     getValue(dispElement)
// }
// function getValue(dispElement){
// console.log(dispElement.value)
// }


function getInputValue(){
    var inpElement = document.getElementById('myip')
    console.log(inpElement.nodeValue)
    var showElement = document.getElementById('show')
    showElement.textContent = inpElement.nodeValue;
}