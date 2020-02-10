<%@page import="java.util.List"%>
<%@page import="com.bcits.usecasemodule.bean.EmployeeMasterInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="headerPage.jsp"></jsp:include>
<% String errMsg =(String) request.getAttribute("errMsg"); %>  
<% List<EmployeeMasterInfo> empList = (List<EmployeeMasterInfo>) request.getAttribute("empList");%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/css/adminLogin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div align="right" style="margin-top: -40px;">
		<a style="color:white; font-size: 25px;" href="./logOut"><i class="fas fa-sign-out-alt"></i>SignOut</a> &nbsp; &nbsp;
	</div>
	<table border="1" style="width: 100%; height:40px; background-color: navy; text-align: center; color: white; margin-top: 20px;">
		<tr>
			<th><h3><a href="./displayHome">Add Employee</a></h3></th>
			<th><h3><a href="./diplayRevoke">Revoke</a></h3></th>
			<th><h3><a href="./displayEmployee">Show All Employee</a></h3> </th>				
		</tr>
	</table>
	
	<% if(empList != null && !empList.isEmpty()) { %>
	<br>
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">Employee ID</th>
      <th scope="col">Employee Name</th>
       <th scope="col">Designation</th>
      <th scope="col">Region</th> 
      <th scope="col">Password</th> 
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1; 
  for( EmployeeMasterInfo empInfo :empList) { %>
  	<tr>
      <th scope="row"><%= i %></th>
      <td><strong><%= empInfo.getEmpId()%></strong></td>
      <td><strong><%= empInfo.getEmpName()%></strong></td>
       <td><strong><%= empInfo.getDesignation()%></strong></td>
      <td><strong><%= empInfo.getRegion()%></strong></td>
       <td><strong><%= empInfo.getPassword()%></strong></td>
    </tr>
    <%  i++ ; } %>
   		</tbody>
	</table>
	<% } else { %>
		<h2 align="center" ><strong style="color: navy;"> <%= errMsg %> </strong></h2>
	<%} %>
</body>
</html>