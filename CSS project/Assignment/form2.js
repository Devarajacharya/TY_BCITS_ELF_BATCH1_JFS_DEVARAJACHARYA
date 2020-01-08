function validation() {
    var user = document.getElementById("name").value;
    var email = document.getElementById("emailid").value;
    var fpsw = document.getElementById("psw").value;
    var spsw = document.getElementById("cpsw").value;

    if (user == "") {
        document.getElementById("username").innerHTML = " *Please fill the user name field";
        return false;
    } else if ((user.length < 3) || (user.length > 15)) {
        document.getElementById("username").innerHTML = "*user length must be between 2 and 15";
        return false;
    } else if( isNaN(user)){
        document.getElementById("username").innerHTML ="*only characters are allowed";
        return false;
    }else {
        document.getElementById("username").style.display = 'none';
    }


    if (email == "") {
        document.getElementById("usermail").innerHTML = " *Please fill the email field";
        return false;
    } else {
        document.getElementById("usermail").style.display = 'none';
    }
    if (fpsw == "") {
        document.getElementById("userpsw").innerHTML = " *Please fill password field";
        return false;
    }
    if (spsw == "") {
        document.getElementById("usercpsw").innerHTML = " *Please fill the confirmpassword field";
        return false;
    }
    // if(firstpassword==secondpassword){
    // return true; 
    // }
    // else{
    // alert("password must be same!");
    // return false;
    // }
}