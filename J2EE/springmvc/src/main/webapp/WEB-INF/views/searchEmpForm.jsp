<%@page import="com.bcits.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp"></jsp:include>
<%
	EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employeeInfoBean");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="width: 300px; margin-left:500px">
		<legend><h2>Search Employee</h2></legend>
		<form action="./search">
			Employee ID : <input type="text" name="empId" required> <br>
			<br> <input type="submit" value="Search"
				style="margin-left: 98px;">

		</form>
		</fieldset>
		<br>
		<%if (errMsg != null && !errMsg.isEmpty()) {%>
		<h3 style="color: red;" align="center"><%=errMsg%></h3>
		<%}%>

		<%if (employeeInfoBean != null) {%>
		<div align="center">
			<table border="1" style="width: 80%;">
				<tr style="background: navy; color: white; height: 40px">
					<th>Employee ID</th>
					<th>Name</th>
					<th>Designation</th>
					<th>Salary</th>
					<th>DOB</th>
					<th>Joining Date</th>
					<th>Mobile</th>
				</tr>
				<tr style="30px">
					<th><%= employeeInfoBean.getEmpid() %></th>
					<th><%= employeeInfoBean.getEmpname() %></th>
					<th><%= employeeInfoBean.getDesignation() %></th>
					<th><%= employeeInfoBean.getSal() %></th>
					<th><%= employeeInfoBean.getDOB() %></th>
					<th><%= employeeInfoBean.getDOJ() %></th>
					<th><%= employeeInfoBean.getMobileNo() %></th>
				
				</tr>
			</table>
		</div>
		<br><br>
		<%}%>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>