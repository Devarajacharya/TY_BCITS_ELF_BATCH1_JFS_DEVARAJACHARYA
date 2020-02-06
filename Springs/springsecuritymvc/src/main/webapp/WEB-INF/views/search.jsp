<%@page import="com.bcits.springsecuritymvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <jsp:include page="header.jsp"></jsp:include>
    
 <% String errMsg = (String) request.getAttribute("errMsg"); %>
 <% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("empBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
		<%if (errMsg != null && !errMsg.isEmpty()) {%>
		<h3 style="color: red;" align="center"><%=errMsg%></h3>
		<%}%>

<fieldset style="width: 300px; margin-left:500px">
		<legend>Search Employee</legend>
		<form action="./getEmp">
			Employee ID : <input type="text" name="empId" required> <br>
			<br> <input type="submit" value="Search"
				style="margin-left: 98px;">

		</form>
		</fieldset>
		<br>
		<%if (employeeInfoBean != null) {%>
		<div align="center">
			<table border="1" style="width: 80%;">
				<tr style="background: navy; color: white; height: 40px">
					<th>Employee ID</th>
					<th>Name</th>
					<th>Role</th>
					<th>Password</th>
					
				</tr>
				<tr style="30px">
					<th><%= employeeInfoBean.getEmpId() %></th>
					<th><%=employeeInfoBean.getName() %></th>
					<th><%=employeeInfoBean.getRole() %></th>
					<th><%=employeeInfoBean.getPassword() %></th>
					
					
				
				</tr>
			</table>
		</div>
		<br><br>
		<%}%>
</body>
</html>