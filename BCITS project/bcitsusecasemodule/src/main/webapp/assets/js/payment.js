function validation() {
    var amount = document.getElementById("amount").value;
    var cardNum = document.getElementById("cardNum").value;
    var name = document.getElementById("name").value;

    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?0-9]+/;

    var amountValid = false;
    var cardNumValid = false;
    var nameValid = false;

    //Amount validation
    if (amount == 0) {
        document.getElementById("billamount").innerHTML = " *Please fill the Amount field";
        return false;
    } else if (amount < 1) {
        document.getElementById("billamount").innerHTML = " *Please Enter the Valid Number";
        return false;
    } else {
        document.getElementById("billamount").style.display = 'none';
        amountValid = true;
    }

    if (cardNum == 0) {
        document.getElementById("cdNum").innerHTML = " *Please fill the Card Number field";
        return false;
    } else if (cardNum < 1) {
        document.getElementById("cdNum").innerHTML = " *Please Enter the Valid Card Number";
        return false;
    }else {
        document.getElementById("cdNum").style.display = 'none';
        cardNumValid = true;
    }
    
    if (name == "") {
        document.getElementById("fname").innerHTML = " *Please fill the First name field";
        return false;
    } else if ((name.length < 3) || (name.length > 20)) {
        document.getElementById("fname").innerHTML = "*Length must be between 3 and 20";
        return false;
    } else if (format.test(name)) {
        document.getElementById("fname").innerHTML = "*Name Should Not contains Special character & Number";
        return false;
    } else {
        document.getElementById("fname").style.display = 'none';
        nameValid = true;
    }

    if(amountValid && cvNumValid && nameValid){
        document.body.appendChild(form);
		form.submit();
		return true;
    }
}