<%@page import="com.bcits.springsecuritymvc.bean.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<% List<EmployeeInfoBean> empList = (List<EmployeeInfoBean>) request.getAttribute("listEmp"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br><br>
	<% if(empList != null ){ %>
	<div align="center">
	<table  border="1px" style="width:90%;">
	<thead style="background: navy;color: white; font: bold;" align="center">
	<tr style="height: 50px">
		<th>Employee ID  </th>
		<th>Employee Name</th>
		<th>Role</th>
		<th>Password</th>
	</tr>
	</thead>
	<tbody>
	<% for(EmployeeInfoBean empInfoBean :empList){ %>
	<tr  style="height: 40px ; font: bold;" align="center">
	<td> <%= empInfoBean.getEmpId() %> </td>
	<td> <%= empInfoBean.getName()%> </td>
	<td> <%= empInfoBean.getRole() %> </td>
	<td> <%= empInfoBean.getPassword()%> </td>
	</tr>
	<% } %>
	</tbody>
 </table>

	<%} else{ %>
	<h2 style="color: red">No Record To Display..</h2>
	<%} %>
	 </div>
	<br><br>
</body>
</html>