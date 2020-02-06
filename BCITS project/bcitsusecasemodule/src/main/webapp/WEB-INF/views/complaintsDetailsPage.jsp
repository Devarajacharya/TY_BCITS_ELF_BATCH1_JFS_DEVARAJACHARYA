<%@page import="java.util.List"%>
<%@page import="com.bcits.usecasemodule.bean.SupportBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% String errMsg =(String) request.getAttribute("errMsg"); %> 
 <% List<SupportBean> supportList = (List<SupportBean>) request.getAttribute("support"); %>  
<jsp:include page="empHeaderPage.jsp"></jsp:include>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>EmployeeHome</title>
  <link href="./resources/fontawesome-free-5.12.0-web/css/all.css " rel="stylesheet" type="text/css">
  <link href="${css}/sb-admin-2.min.css" rel="stylesheet">
   <link rel="stylesheet" href="${css}/employeeHome.css">
  
</head>
<body>
 <div class="d-flex" id="wrapper">
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion">
    	
    	
     		<li class="nav-item"><a class="nav-link" href="./displayEmpHome"> <span><strong>Employe Profile</strong></span></a></li>
			<hr class="sidebar-divider my-0">
			
			<li class="nav-item"><a class="nav-link" href="./getConsumer"> <span><strong>Show All Consumer</strong></span> </a></li>
			<hr class="sidebar-divider my-0">

			<li class="nav-item"><a class="nav-link" href="./generatedBill"> <span><strong>Generated Bill</strong></span></a></li>
			<hr class="sidebar-divider my-0">
			
			<li class="nav-item"><a class="nav-link" href="./complaintsDetails"> <span><strong>Complaints Details</strong></span></a></li>
			<hr class="sidebar-divider my-0">   
    </ul>
    <div id="page-content-wrapper bill">
    <br><br>
    <% if(supportList != null){ %>
    <div style="margin-left: 40px">
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">No &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">RR Number &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">View &nbsp;&nbsp;&nbsp;&nbsp;</th>
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1; 
  for(SupportBean supportBean : supportList ) { %>
  <form action="" >
  <input  type="text" name ="rrNumber" value="<%= supportBean.getSupportBeanPK().getRrNumber() %>" hidden="true" >
  	<tr>
      <th scope="row"><%= i %> </th>
      <td><strong><%= supportBean.getSupportBeanPK().getRrNumber() %> </strong></td>
      <td><button type="submit" class="btn btn-secondary">Click Here View</button></td> 
    </tr>
     </form>
    <% i++; }}%>
   		</tbody>
	</table>
  </div>
    </div>
    <script src="${js}/searchRRNumber.js"></script>
   <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>