function validation(){
    var user = document.getElementById("name").value;
    var email = document.getElementById("emailid").value;
    var fpsw= document.loginForm("psw").value;
    var spsw = document.loginForm("cpsw").value;

    if (user == ""){
        document.getElementById("username").innerHTML = " *Please fill the user name field";
        return false;
    }
    if (email == ""){
        document.getElementById("useremail").innerHTML = " *Please fill the email field";
        return false;
    }
    if (fpsw == ""){
        document.getElementById("userpsw").innerHTML = " *Please fill password field";
        return false;
    }
    if (spsw == ""){
        document.getElementById("usercpsw").innerHTML = " *Please fill the confirmpassword field";
        return false;
    }
    if(firstpassword==secondpassword){
    return true; 
    }
    else{
    alert("password must be same!");
    return false;
    }
    }