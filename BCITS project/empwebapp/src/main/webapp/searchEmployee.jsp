<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmployeePrimaryInfo employeePrimaryInfo =(EmployeePrimaryInfo)
    											request.getAttribute("empInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset style="width: 300px">
<legend><h2>SearchEmployee</h2></legend>
		<form action="./getEmp">	
		Employee ID : 
		<input type="text" name="empId" required> <br> <br>
		<input type="submit" value="Search" style="margin-left: 98px">

	</form>
	</fieldset>
	
	<% if (employeePrimaryInfo != null) { %> <h3 style="color: green;">
	Name          = <%= employeePrimaryInfo.getEmpname() %> <br>
	Salary        = <%= employeePrimaryInfo.getSal() %> <br>
	Designation   = <%= employeePrimaryInfo.getDesignation() %> <br>
	Date Of Birth = <%= employeePrimaryInfo.getDOB() %> <br>
	<%} else { %>
	<h2 style="color: red">Employee ID Is Not Found..!!</h2>
	<%} %> </h3>
</body>
</html>