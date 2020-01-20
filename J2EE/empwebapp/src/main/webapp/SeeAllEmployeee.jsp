<%@page import="java.util.List"%>
<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <% List<EmployeePrimaryInfo> employeeList  = (List<EmployeePrimaryInfo>) request.getAttribute("empList");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if (employeeList != null) {%>

 <table border="1px" style="width: 80px;">
	<thead style="background: navy;color: white;">
	<tr style="height: 35px">
		<th>Employee ID  </th>
		<th>Employee Name</th>
		<th>Date Of Birth</th>
		<th>Date Of Join</th>
		<th>Designation  </th>
		<th>Salary</th>
		<th>Mobile NumberS</th>
	</tr>
	</thead>
	<tbody>
	<% for(EmployeePrimaryInfo employee_info : employeeList) { %>
	<tr  style="height: 35px">
	<td><%= employee_info.getEmpId() %></td>
	<td><%= employee_info.getEmpname() %></td>
	<td><%= employee_info.getDOB() %></td>
	<td><%= employee_info.getDOJ() %></td>
	<td><%= employee_info.getDesignation()%></td>
	<td><%= employee_info.getSal() %></td>
	<td><%= employee_info.getMobileNum()%></td>
	</tr>
	<% } %>
	</tbody>
 </table>
<% } else {%>
<h2 style="color: red">No Record To Display..</h2>
<%} %>
</body>
</html>