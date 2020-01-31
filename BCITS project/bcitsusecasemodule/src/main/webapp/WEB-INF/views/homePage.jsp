<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
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
<title>Login page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/home.css">
</head>

<body>
	<nav>
		<span class="navbar-toggler-icon "> <img id="logo"
			src="${images}/logo.png" alt="">
		</span> <span class="navbar-brand mb-0 h1"></span>
		<h1 id="title">DISCOM ELECTRICITY LIMITED</h1>
		<h6 style="margin-left: 130px;">(Government of Karnataka
			Undertaking)</h6>

		<div class="homelink ">
			<a style="color: white;" href="./home.html"><i class="fas fa-home"></i>Home</a> &nbsp; &nbsp; <a
				style="color: white;" href="./home.html">About</a>
		</div>
	</nav>
	<form>
		<div class="col-md-12 col-sm-12 ">
			<h1 class="welcome">
				<b>WELCOME TO DISCOM</b>
			</h1>
			<p class="contact font-weight-light">
				<i class="fas fa-phone-alt"></i> Call Consumer Helpline Number -
				1912 / 18004251917
			</p>
				<button type="submit" class="btn btn-lg btn-primary button1"
					formaction="./consLoginPage">
					<i class="fas fa-user"></i> USER LOGIN
				</button>
				<button type="submit" class="btn btn-lg btn-primary button2"
					formaction="./empLoginPage">
					<i class="fas fa-user-tie"></i> EMPLOYEE LOGIN
				</button>
				</div>
	</form>
	
	<script src="${js}jquery-3.4.1.js"></script>
	<script src="${js}bootstrap.min.js"></script>

</body>

</html>