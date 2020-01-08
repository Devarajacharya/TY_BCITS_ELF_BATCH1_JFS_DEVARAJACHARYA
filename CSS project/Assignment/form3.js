function validation(){
var firstname = document.getElementById("fname").value;
var lastname = document.getElementById("lname").value;
var emailId = document.getElementById("email").value;
var password = document.getElementById("psw").value;
if(firstname == "" ){
document.getElementById("para1").innerHTML = "Please specify your First Name*"
return false;
}
}