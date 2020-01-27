<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Employee Login page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/employeeLogin.css">
</head>

<body>
	<nav>
		<span class="navbar-toggler-icon"> <img id="logo"
			src="${images}/logo.png" alt="">
		</span> <span class="navbar-brand mb-0 h1"></span>
		<h1 id="title">DISCOM ELECTRICITY LIMITED</h1>
		</span>
		<div class="homelink ">
			<a style="color: white;" href="./discomHomePage"><i class="fas fa-home"></i>Home</a> &nbsp; &nbsp; 
			<a style="color: white;" href="#">About</a>
		</div>
	</nav>

	<form onsubmit="validation(); return false" action="#">
		<img class="avatar" src="${images}/avatar.png">
		<h5 style="padding-left: 66px; size: 30px;">EMPLOYEE LOGIN</h5>
		<div class="form-group">
			<label for="exampleInputEmail1"><b> Employee ID :</b></label> <input
				type="text" class="form-control" id="empId"
				aria-describedby="emailHelp" placeholder="Employee ID"> <span
				id="username" style="color: red;"></span><br>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1"><b>Designation :</b></label> <input
				type="text" class="form-control" id="designation"
				placeholder="Designation"> <span id="userpsw"
				style="color: red;"></span><br>

		</div>
		<button id="login" type="submit" class="btn btn-primary">Login</button>

	</form>

	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/employeeLogin.js"></script>


</body>

</html>