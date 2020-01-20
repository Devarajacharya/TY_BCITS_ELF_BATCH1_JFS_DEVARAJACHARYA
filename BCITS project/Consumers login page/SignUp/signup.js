function validation() {
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var email = document.getElementById("email").value;
    var pnumber = document.getElementById("pnumber").value;
    var psw = document.getElementById("psw").value;
    var cpsw = document.getElementById("cpsw").value;
    var rrnum = document.getElementById("mnumber").value;
    var houseNum = document.getElementById("houseNum").value;
    var inputAddress1 = document.getElementById("inputAddress1").value;
    var inputAddress2 = document.getElementById("inputAddress2").value;

    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?0-9]+/;
    var format1 = /[A-Z]+/;
    var format2 = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;
    var format3 = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-z]+/;

    //First Name Validation

    if (fname == "") {
        document.getElementById("firstname").innerHTML = " *Please fill the First name field";
        return false;
    } else if ((fname.length < 3) || (fname.length > 20)) {
        document.getElementById("firstname").innerHTML = "*Length must be between 3 and 20";
        return false;
    } else if (format.test(fname)){
        document.getElementById("firstname").innerHTML = "*Name Should Not contains Special character & Number";
        return false;
    } else {
        document.getElementById("firstname").style.display = 'none';
    }  
    
    //Last Name Validation

    if (lname == "") {
        document.getElementById("lastname").innerHTML = " *Please fill the Last name field";
        return false;
    }  else if (format.test(lname)){
        document.getElementById("lastname").innerHTML = "*Name Should Not contains Special character & Number";
        return false;
    } else {
        document.getElementById("lastname").style.display = 'none';
    }   

    //Email validation

    if(email == ""){
        document.getElementById("emailid").innerHTML = " *Please fill Email field";
        return false;  
    }else if (format1.test(email)){
        document.getElementById("emailid").innerHTML = "*Should Not contains Upper Case";
        return false;
    }else{
        document.getElementById("emailid").style.display = 'none';
    }

    //Phone number Validation

    if(pnumber == ""){
        document.getElementById("phonenumber").innerHTML = "*Please fill Phone number field";
        return false;  
    }else if (format2.test(pnumber)){
        document.getElementById("phonenumber").innerHTML = "*Should Not contains character";
        return false;
    }else{
        document.getElementById("phonenumber").style.display = 'none';
    }

    //Password Validation

    if (psw == "") {
        document.getElementById("password").innerHTML = "*Please fill Password field";
        return false;  
    }else if (psw.length < 4){
        document.getElementById("password").innerHTML = "*Should contains more than 4 character";
        return false;
    }else{
        document.getElementById("password").style.display = 'none';
    }
    //confirm password.

    if (cpsw == "") {
        document.getElementById("confirmpassword").innerHTML = "*Please fill field";
        return false;  
    }else if (psw != cpsw){
        document.getElementById("confirmpassword").innerHTML = "*Password is not match";
        return false;
    }else{
        document.getElementById("confirmpassword").style.display = 'none';
    }
    //RR Number Validation

    if (rrnum == "") {
        document.getElementById("rrnumber").innerHTML = " *Please fill the RR Number";
        return false;
    } else if ((rrnum.length < 6) || (rrnum.length > 9)) {
        document.getElementById("rrnumber").innerHTML = "*Invalid RR Number";
        return false;
    } else if (format3.test(rrnum)){
        document.getElementById("rrnumber").innerHTML = "*Invalid RR Number";
        return false;
    } else {
        document.getElementById("rrnumber").style.display = 'none';
    }   

    //Address Validation 

    if (houseNum == "") {
        document.getElementById("houseno").innerHTML = " *Please fill the Address  field";
        return false;
    } else {
        document.getElementById("houseno").style.display = 'none';
    }

    if (inputAddress1 == "") {
        document.getElementById("add1").innerHTML = " *Please fill the Address  field";
        return false;
    } else {
        document.getElementById("add1").style.display = 'none';
    }

    if (inputAddress2 == "") {
        document.getElementById("add2").innerHTML = " *Please fill the Address  field";
        return false;
    } else {
        document.getElementById("add2").style.display = 'none';
    }
}
