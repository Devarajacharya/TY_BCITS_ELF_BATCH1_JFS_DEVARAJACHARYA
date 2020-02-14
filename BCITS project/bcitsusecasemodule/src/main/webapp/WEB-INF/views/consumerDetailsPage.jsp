<%@page import="com.bcits.usecasemodule.bean.ConsumerInfoBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% List<ConsumerInfoBean> conInfoBeans = (List<ConsumerInfoBean>) request.getAttribute("consumerList"); %>
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
    	
    	
     		<li class="nav-item"><a class="nav-link" href="./displayEmpHome"> <span><strong>Employee Profile</strong></span></a></li>
			<hr class="sidebar-divider my-0">
			
			<li class="nav-item"><a class="nav-link" href="./getConsumer"> <span><strong>Generate Bill</strong></span> </a></li>
			<hr class="sidebar-divider my-0">

			<li class="nav-item"><a class="nav-link" href="./showConsumer"> <span><strong>Consumer Details</strong></span></a></li>
			<hr class="sidebar-divider my-0">
			
			<li class="nav-item"><a class="nav-link" href="./BillCollected"> <span><strong>Bill Collected</strong></span></a></li>
			<hr class="sidebar-divider my-0">    
			
			<li class="nav-item"><a class="nav-link" href="./billPending"> <span><strong>Bill Pending</strong></span></a></li>
			<hr class="sidebar-divider my-0"> 
			
			<li class="nav-item"><a class="nav-link" href="./complaintsDetails"> <span><strong>Complaints Details</strong></span></a></li>
			<hr class="sidebar-divider my-0"> 
			
			<li class="nav-item"><a class="nav-link" href="./monthRevenue"> <span><strong>Monthly Revenue</strong></span></a></li>
			<hr class="sidebar-divider my-0"> 
    </ul>
    <div id="page-content-wrapper bill">
    <div style="margin-left: 20px; margin-right: 20px;">
    <br>
    <% if(conInfoBeans != null && !conInfoBeans.isEmpty()){   %>	
     <input class="form-control" id="myInput" type="text" placeholder="Search Month..">
  <br>
	<table class="table  table-bordered" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">RR_Number </th>
      <th scope="col">Name </th>
      <th scope="col">Email ID</th> 
      <th scope="col">Phone_Number</th> 
      <th scope="col">Address</th>
      <th scope="col">Type_Of_Consumer</th>
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1; 
  for( ConsumerInfoBean consumerInfoList :conInfoBeans) {  %>
  	<tr>
      <th scope="row"><%= i %> </th>
      <td><strong><%= consumerInfoList.getRrNumber() %> </strong></td>
      <td><strong><%= consumerInfoList.getFirstName()+" "+consumerInfoList.getLastName() %></strong></td>
      <td><strong><%= consumerInfoList.getEmail()%></strong></td>
      <td><strong><%= consumerInfoList.getPhoneNumber() %></strong></td>
      <td><strong><%= consumerInfoList.getHouseNumber() +" "+ consumerInfoList.getAddress1() +" "+ consumerInfoList.getAddress2()%></strong></td>
      <td><strong><%= consumerInfoList.getTypeOfConsumer()%></strong></td>
    </tr>
    <% i++; } %>
   		</tbody>
	</table>
	<%}%>
  </div>
  </div>
    </div>
    <script src="${js}/searchRRNumber.js"></script>
   <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>