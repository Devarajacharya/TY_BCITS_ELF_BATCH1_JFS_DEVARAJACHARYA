<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <jsp:include page="Header.jsp"></jsp:include>
	<%String msg =(String) request.getAttribute("msg");
    String errMsg =(String) request.getAttribute("errMsg");%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br>
<% if(msg != null && !msg.isEmpty()) {%>
<h2 style="color: green"><%= msg %></h2>
<%} %>

<% if(errMsg != null && !errMsg.isEmpty()) {%>
<h2 style="color: red;"><%= errMsg %></h2>
<%} %>
<div align="center">
	<fieldset style="width: 500px">
		<legend>update Employee Record</legend>
		<form action="./updateEmpForm" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td><input type="tel" name="empid"></td>
				</tr>

				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="empname"></td>
				</tr>

				<tr>
					<td>Salary</td>
					<td><input type="text" name="sal" ></td>
				</tr>
				
				<tr>
					<td>Designation</td>
					<td><input type="text" name="designation"></td>
				</tr>
				<tr>
					<td>Blood Group </td>
					<td><input type="text" name="bloodGroup" ></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><input type="date" name="DOB" ></td>
				</tr>
				<tr>
					<td>Date Of Joining</td>
					<td><input type="date" name="DOJ"></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="tel" name="mobileNo"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Department ID</td>
					<td><input type="tel" name="deptId" ></td>
				</tr>
				<tr>
					<td>Manager ID </td>
					<td><input type="tel" name="managerId" ></td>
				</tr>
				<tr>
					<td>Official Mail ID</td>
					<td><input type="email" name="officialMail" ></td>
				</tr>	
				<tr>
					<td><input type="submit" value="Update"
						style="margin-left: 98px; width: 100px"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	</div>
<br> <br>

</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>