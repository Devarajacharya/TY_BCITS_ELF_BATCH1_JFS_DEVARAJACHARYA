<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:include page="index.jsp"></jsp:include>
	<% String errMsg =(String) request.getAttribute("errMsg"); %>
	<% String msg =(String) request.getAttribute("msg"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
		<%if (errMsg != null && !errMsg.isEmpty()) {%>
		<h2 style="color: red;" align="center"><%=errMsg%></h2>
		<%}%>
		
		<%if (msg != null && !msg.isEmpty()) {%>
		<h2 style="color: green;" align="center"><%=msg%></h2>
		<%}%>
	<div align="center">
	<fieldset style="width: 500px">
		<legend>register Employee</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td><input type="tel" name="empId"></td>
				</tr>

				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="name" required></td>
				</tr>
				
				<tr>
					<td>Role</td>
					<td><input type="radio" name="role" value="ROLE_USER">USER</td>
				</tr>
				<tr>
					<td><td><input type="radio" name="role" value="ROLE_ADMIN">Admin</td>
					
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="ADD"
						style="margin-left: 98px; width: 100px" ></td>
				</tr>
			</table>
		</form>
	</fieldset>
</div>
</body>
</html>