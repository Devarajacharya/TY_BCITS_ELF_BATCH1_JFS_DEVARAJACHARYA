function validation() {
    var user = document.getElementById("rrnum").value;
    var password = document.getElementById("psw").value;
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-z]+/;
    if (user == "") {
        document.getElementById("username").innerHTML = " *Please fill the RR Number";
        return false;
    } else if ((user.length < 6) || (user.length > 9)) {
        document.getElementById("username").innerHTML = "*Invalid RR Number";
        return false;
    } else if (format.test(user)){
        document.getElementById("username").innerHTML = "*Invalid RR Number";
        return false;
    } else {
        document.getElementById("username").style.display = 'none';
    }   

    if (password == "") {
        document.getElementById("userpsw").innerHTML = " *Please fill password field";
        return false;
    }else if( password.length <=5 ){
        document.getElementById("userpsw").innerHTML = " *Password Contains At list 5 character";
        return false;
    }else{
        document.getElementById("userpsw").style.display = 'none';


    }    }
