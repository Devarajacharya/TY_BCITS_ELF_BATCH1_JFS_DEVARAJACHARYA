<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp"></jsp:include>
<% String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
	<br>
<% if(errMsg != null && !errMsg.isEmpty()){ %>
<h2 style="color: red;" align="center"><%= errMsg %></h2>
<%} %>
	
	<fieldset style="width: 500px">
		<legend>Add Employee Record</legend>
		<form action="./addEmployee" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td><input type="tel" name="empid" required></td>
				</tr>

				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="empname" required></td>
				</tr>

				<tr>
					<td>Designation</td>
					<td><input type="text" name="designation" required></td>
				</tr>

				<tr>
					<td>Date Of Joining</td>
					<td><input type="date" name="DOJ" required></td>
				</tr>

				<tr>
					<td>Salary</td>
					<td><input type="text" name="sal" required></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="tel" name="mobileNo" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="ADD"
						style="margin-left: 98px; width: 100px"></td>
				</tr>
			</table>
		</form>
	</fieldset>
<br> <br>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>