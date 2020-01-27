<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="width: 500px;">
		<legend>Employee Login</legend>
		<!-- <form action="./login1" method="post"> -->
		<!-- <form action="./login2" method="post"> -->
		<!-- <form action="./login3" method="post"> -->
		<form action="./login4" method="post">


			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="text" name="empId" required></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td>:</td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="3"><br> <input type="submit" value="Login"
						style="margin-left: 50px; color: green;'"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>