<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="headerPage.jsp"></jsp:include>   
<% String errMsg =(String) request.getAttribute("errMsg"); %>
<% String msg =(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/css/adminLogin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<div align="right" style="margin-top: -40px;">
		<a style="color:white; font-size: 25px;" href="./logOut"><i class="fas fa-sign-out-alt"></i>SignOut</a> &nbsp; &nbsp;
	</div>
	<table border="1" style="width: 100%; height:40px; text-align: center; color: white; background-color: navy; margin-top: 20px;">
		<tr >
			<th><h3><a href="./displayHome">Add Employee</a></h3></th>
			<th><h3><a href="./diplayRevoke">Revoke</a></h3></th>
			<th><h3><a href="./displayEmployee">Show All Employee</a></h3> </th>				
		</tr>
	</table>

	
	<% if(errMsg != null && !errMsg.isEmpty()){ %>
	<h2 style="color: red;" align="center"> <%= errMsg %></h2>
	<%} %>
	
	<% if(msg != null && !msg.isEmpty()){ %>
	<h2 style="color: green;" align="center"> <%=msg %></h2>
	<%} %>
	
	<div class="login-form"  style="color: black;">
    <form action="addEmployee" method="post">
		<h3>Add Employees</h3>
        <div class="form-group">
        	<input type="tel" class="form-control" name="empId" placeholder="Employee ID" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="empName" placeholder="Employee Name" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="designation" placeholder="Designation" required="required">
        </div>       
        <div class="form-group">
				<select id="region" class="form-control" name="region" required>
                    <option selected>Choose...</option>
                    <option>Bangalore North</option>
                    <option>Bangalore South</option>
                </select>    
        </div>  
           
        <div class="form-group">
            <input type="text" class="form-control" name="password" placeholder="Password" required="required">
        </div>  
		<div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form>
</div>
</body>
</html>                            