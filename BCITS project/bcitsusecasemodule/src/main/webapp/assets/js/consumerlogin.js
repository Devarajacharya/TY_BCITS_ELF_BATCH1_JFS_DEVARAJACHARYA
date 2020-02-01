function validation() {
    var user = document.getElementById("user").value;
    var password = document.getElementById("psw").value;
    var userValue = false; 
    var passwordValue=false;
        
    if (user == "") {
        document.getElementById("username").innerHTML = " *Please fill the Username";
        return false;
    } else if ((user.length < 10) || (user.length > 30)) {
        document.getElementById("username").innerHTML = "*Invalid Username";
        return false;
    }  else {
        document.getElementById("username").style.display = 'none';
        userValue = true;
    }   

    if (password == "") {
        document.getElementById("userpsw").innerHTML = " *Please fill password field";
        return false;
    }else if( password.length <=5 ){
        document.getElementById("userpsw").innerHTML = " *Password Contains At list 5 character";
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
