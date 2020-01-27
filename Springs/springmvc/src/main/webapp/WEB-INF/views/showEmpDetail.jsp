<%@page import="com.bcits.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h3 style="color: red;" align="center"><%=errMsg%></h3>
	<%}%>
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
			<tr style="">
				<th><%=employeeInfoBean.getEmpid()%></th>
				<th><%=employeeInfoBean.getEmpname()%></th>
				<th><%=employeeInfoBean.getDesignation()%></th>
				<th><%=employeeInfoBean.getSal()%></th>
				<th><%=employeeInfoBean.getDOB()%></th>
				<th><%=employeeInfoBean.getDOJ()%></th>
				<th><%=employeeInfoBean.getMobileNo()%></th>

			</tr>
		</table>
	</div>
	<br>
	<br>

</body>
</html>