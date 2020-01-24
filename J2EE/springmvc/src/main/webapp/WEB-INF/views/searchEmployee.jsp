<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String empId =(String) request.getAttribute("empId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: navy;"> Employee ID : <%= empId %> Details</h1>
<h3 style="color: orange;">
Name : Amisha <br>
Designation : Tester <br>
Mobile No : 8105152611 <br>
Salary : 32000
</h3>
</body>
</html>