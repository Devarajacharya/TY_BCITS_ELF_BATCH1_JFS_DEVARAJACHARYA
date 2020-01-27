<%@page import="com.bcits.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:include page="Header.jsp"></jsp:include>
	
<%
	EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employeeInfoBean");
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3 style="color: green;" align="center"><%=msg%></h3>
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
<jsp:include page="footer.jsp"></jsp:include>