function validateForm(){
    var loginForm = document.forms['loginForm']
    var userMail = loginForm['userEmail'].value;
    var pwd = loginForm['userPwd'].value;

    console.log(loginForm)
    console.log('user Mail ' ,userMail)
    console.log('User Password ',pwd)

    if(userMail.trim().length>10){
    document.getElementById('emailErr').style.display = 'none'
    console.log("User mail is valid")
    }else{
        document.getElementById('emailErr').style.display = 'block'
        console.log("User mail is not valid")
    }


if(pwd.trim().length>5){
    document.getElementById('pwdErr').style.display = 'none'
    console.log("password is valid")
    }else{   
        document.getElementById('pwdErr').style.display = 'block'
       console.log("password is not valid")
    }
}

