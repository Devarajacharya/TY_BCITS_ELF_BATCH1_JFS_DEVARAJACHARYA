<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% int empId = (Integer)request.getAttribute("empId"); %>
    <% String password = (String )request.getAttribute("psw"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color: navy;">
	Employee Id :<%= empId %> <br>
	Password   : <%= password %>
	</h3>
</body>
</html>