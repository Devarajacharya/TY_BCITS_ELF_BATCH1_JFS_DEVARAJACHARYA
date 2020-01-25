<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% String errMsg = (String) request.getAttribute("errMsg"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(errMsg != null  && !errMsg.isEmpty()){ %>
<h2 style="color: red;"><%= errMsg %></h2>
<%} %>

	<fieldset style="width: 500px;">
		<legend>Employee Login</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="text" name="empId" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="3"><br> <input type="submit" value="Login"
						style="margin-left: 50px; background:Tomato;"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<br> <br> <br> 
</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>
