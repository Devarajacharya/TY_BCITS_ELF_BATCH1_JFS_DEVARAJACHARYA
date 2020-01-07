var element = document.getElementById("demo")
console.log(element)
console.log(element.textContent)
element.textContent = 'Hai Hello';
console.log(element.textContent)



var ele = document.createElement("h1")
var d = new Date();
var n = d.getHours();
console.log(n)
if(n>=5 && n<=11){
    ele.textContent = "Good Morning";
}
else if(n<21 && n >14){
ele.textContent = "Good Evening";
} else {
    ele.textContent = "Good Night";
}
document.body.appendChild(ele)



// var ele = document.createElement("h1")
// ele.textContent = "Hai";
// document.body.appendChild(ele)
// ele.style.fontSize='40px'
// ele.style.color='green'

