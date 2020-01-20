<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <% String msg =(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset style="width: 500px">
		<legend>Employee Login</legend>
		<form action="./login2" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="empId" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
				
					<td><input type="submit" value="Login"
						style="margin-left: 50px; color:green;'"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
<% if(msg != null && !msg.isEmpty()) { %>
 <h2 style="color: maroon;"><%= msg %> </h2>
<%} %>












