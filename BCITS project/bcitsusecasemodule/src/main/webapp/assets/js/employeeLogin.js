function validation() {
    var user = document.getElementById("empId").value;
    var password= document.getElementById("password").value;
    
    var userValue = false; 
    var passwordValue=false;
    
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;
    if (user == 0) {
        document.getElementById("username").innerHTML = " *Please fill the user name field";
        return false;
    } else if ((user.length < 3) || (user.length > 8)) {
        document.getElementById("username").innerHTML = "*Invalid employee ID";
        return false;
    } else if (format.test(user)){
        document.getElementById("username").innerHTML = "*Invalid employee ID";
        return false;
    } else {
        document.getElementById("username").style.display = 'none';
        userValue = true;
    }   
    if (password == "") {
        document.getElementById("userpsw").innerHTML = " *Please fill Designation field";
        return false;
    }else{
        document.getElementById("userpsw").style.display = 'none';
        passwordValue = true;
    }
    
    if(passwordValue && userValue ){
    	document.body.appendChild(form);
		form.submit();
		return true;
    }
}
