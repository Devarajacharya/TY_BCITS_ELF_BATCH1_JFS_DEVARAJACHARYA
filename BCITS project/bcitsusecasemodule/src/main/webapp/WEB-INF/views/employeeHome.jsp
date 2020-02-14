<%@page import="com.bcits.usecasemodule.bean.EmployeeMasterInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmployeeMasterInfo empInfo = (EmployeeMasterInfo)session.getAttribute("loggedInEmp"); %>
    <%long count = (long) request.getAttribute("count"); %>
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
   <div id="page-content-wrapper" ><br>
            <table  style="font-size: 20px">
             <tr>
                    <td><strong>Employee Details</strong></td>
                </tr>
                <tr>
                    <td><strong>Employee ID</strong></td>
                    <td>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><strong><%= empInfo.getEmpId() %></strong></td>
                </tr>
                <tr>
                    <td><strong>employee Name</strong></td>
                    <td>:</td>
                    <td><strong><%= empInfo.getEmpName()%></strong></td>
                </tr>
                <tr>
                    <td><Strong>Designation</Strong></td>
                    <td>:</td>
                    <td><strong><%= empInfo.getDesignation() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Region</strong></td>
                    <td>:</td>
                    <td><strong><%= empInfo.getRegion() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>Number of Consumer</Strong></td>
                    <td>:</td>
                    <td><strong><%= count%></strong></td>
                </tr>
            </table><br><br>
  </div>
  </div>
   <script src="${js}/searchRRNumber.js"></script>
   <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>
    