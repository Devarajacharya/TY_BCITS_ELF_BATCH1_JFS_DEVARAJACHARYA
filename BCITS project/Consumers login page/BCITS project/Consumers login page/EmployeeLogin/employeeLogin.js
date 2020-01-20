function validation() {
    var user = document.getElementById("empId").value;
    var desig= document.getElementById("designation").value;
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-z]+/;
    if (user == "") {
        document.getElementById("username").innerHTML = " *Please fill the user name field";
        return false;
    } else if ((user.length < 6) || (user.length > 9)) {
        document.getElementById("username").innerHTML = "*Invalid employee ID";
        return false;
    } else if (format.test(user)){
        document.getElementById("username").innerHTML = "*Invalid employee ID";
        return false;
    } else {
        document.getElementById("username").style.display = 'none';
    }   
    if (desig == "") {
        document.getElementById("userpsw").innerHTML = " *Please fill Designation field";
        return false;
    }else{
        document.getElementById("userpsw").style.display = 'none';

    }
}
