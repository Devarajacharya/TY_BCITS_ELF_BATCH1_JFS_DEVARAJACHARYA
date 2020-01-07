function add(a, b) {
    var c = a + b;
    return c;
}
var sum = add(20, 30);
console.log('sum is ', sum)

console.log("===========================")
var n1 = 10;
var str = '10';
//  if (n1 == str) {
if (n1 === str) {
    console.log("Equal")
} else {
    console.log("Not equal")
}

console.log("===========================")

var n = 10;
var arr = [12,3,2];
var str='ninja';
var nums = {

}
console.log(typeof (n));
console.log(typeof(str))
console.log(typeof(arr))
console.log(typeof(true))
console.log(typeof(null))
console.log(typeof(undefined))
console.log(typeof nums)

if(Array.isArray(arr)){
console.log('num is an array')
} else{
    console.log("num is not an array")
}

console.log("===========================")


// var add =function (a,b){
//     return a+b;
// }
var a=10;
var b=30;
var sum =(a,b) => a+b;
console.log(`Sum of ${a} + ${b} is = ${add(a,b)}`)

var sqrt = a=>a*a;
var a=10;
console.log('Sqaure of ',a,' is' , sqrt(a))

