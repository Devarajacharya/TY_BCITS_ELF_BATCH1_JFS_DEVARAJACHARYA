<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String msg =(String) request.getAttribute("msg"); %>
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
<title>Consumer Login page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/consumerLogin.css">
</head>

<body>
	<nav>
		<span class="navbar-toggler-icon"> <img id="logo"
			src="${images}/logo.png" alt="">
		</span> <span class="navbar-brand mb-0 h1"></span>
		<h1 id="title">DISCOM ELECTRICITY LIMITED</h1>
		<div class="homelink ">
			<a style="color: white;" href="./discomHomePage"><i
				class="fas fa-home"></i>Home</a> &nbsp; &nbsp; <a style="color: white;"
				href="#">About</a>
		</div>
	</nav>
	
     <% if(msg != null && !msg.isEmpty()) { %>
     <div style="color: white; font-size:35px; font: bold; margin-right: 50px" align="center">
  	<strong style="transition-duration: 60s;"><%= msg %></strong>
	</div>
	<%}%>
   

	 <form onsubmit="validation(); return false"  id="formData" method ="post">
        <%-- <img  class = "avatar" src="${images}/avatar.png" alt=""> --%>
        <h3 style="padding-left: 66px;">USER LOGIN</h3>
        <div class="form-group">
          <label for="exampleInputEmail1"><b> RR-Number :</b></label>
          <input type="text" class="form-control" id="rrnum" name="rrNumber" aria-describedby="emailHelp" placeholder="RR-Number">
          <span id="username" style="color: red;"></span>
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1"><b>Password :</b></label>
          <input type="password" class="form-control" id="psw"  name="password" placeholder="Password" >
          <span id="userpsw" style="color: red;"></span><br>
        </div>   
        <button id="login" type="submit" formaction="./consumerLogin" class="btn btn-primary">Login</button>
        <div>
            <a href="./signUpPage" style="color: white; padding-left: 82px;">New User ? Register</a>
        </div>
      </form>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/consumerlogin.js"></script>
</body>

</html>