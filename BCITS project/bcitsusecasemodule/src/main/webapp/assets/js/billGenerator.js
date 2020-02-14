function validation() {
	
    var previous = document.getElementById("prev").value;
    var presence = document.getElementById("pres").value;
    var dueDate = document.getElementById("dueDate").value;
    
    var pressenceValue=false;
    var dueDateValue=false;
    
	var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;

    if (pressence == null) {
        document.getElementById("presence").innerHTML = " *Please fill the Presence Reading";
        return false;
    } else if (pressence < 1) {
        document.getElementById("presence").innerHTML = "*Enter valid Reading";
        return false;
    } else if (pressence < previous ) {
        document.getElementById("presence").innerHTML = "*Enter valid Reading";
        return false;
    } else if (format.test(pressence)) {
        document.getElementById("presence").innerHTML = "*Enter valid Reading";
        return false;
    }  else {
        document.getElementById("presence").style.display = 'none';
        pressenceValue = true;
    }   
    
    if (dueDate == null) {
        document.getElementById("due").innerHTML = " *Please fill the Due Date";
        return false;
    } else {
        document.getElementById("due").style.display = 'none';
        dueDateValue = true;
    }   
    
    if(pressenceValue && dueDateValue ){
    	document.body.appendChild(form);
    	form.method('POST');
		form.submit();
		return true;
    }
}