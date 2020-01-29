<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/headerPage.css">
</head>
<body>
<nav>
		<span class="navbar-toggler-icon"> <img id="logo"
			src="${images}/logo.png" alt="">
		</span> <span class="navbar-brand mb-0 h1"></span>
		<h1 id="title">DISCOM ELECTRICITY LIMITED</h1>
		<div class="homelink " align="right">
		<a style="color: white;" href="./employeeLogout"><i class="fas fa-sign-out-alt"></i>SignOut</a> &nbsp; &nbsp;
			</div>
	</nav>
	 <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>