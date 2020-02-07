<%@page import="java.text.SimpleDateFormat"%>
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
	<table class="table table-bordered" style="color: black;">
  <thead>
    <tr>
      <th scope="col">NO &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">RR NUmber &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Date &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Complaint Details &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Respond &nbsp;&nbsp;&nbsp;&nbsp;</th>
    </tr>
  </thead>
  <tbody>
  <% int i = 1; 
  for( SupportBean supportBean :supportList) {  %> 
   <form action="./sendResponse" method="post">
   <input name ="rrNumber" type="text" value="<%= supportBean.getSupportBeanPK().getRrNumber()%>" hidden="true" >
   
    <tr>
      <th scope="row"><%= i %></th>
      <td> <%= supportBean.getSupportBeanPK().getRrNumber() %></td>
      <td> <% SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); %>
           <%= formatter.format(supportBean.getSupportBeanPK().getDate()) %></td>
      <td><%= supportBean.getSupport() %></td>
      <td><textarea class="form-control" rows="3 " id="comment" name ="response"></textarea></td> 
 	  <td><button type="submit" class="btn btn-primary">Send</button></td>
    </tr>
    </form>
    <% i++; } %>
  </tbody>
</table>
<%} %>
</div>  
  </div>
    </div>
    <script src="${js}/searchRRNumber.js"></script>
   <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>