<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% List<Object[]> revenueCollected = (List<Object[]>) request.getAttribute("revenueCollected");%>
<% List<Object[]> revenuePending = (List<Object[]>) request.getAttribute("revenuePending");%>
<% List<Object[]> totalRevenue = (List<Object[]>) request.getAttribute("totalRevenue");%>
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
    <br><br>
    <div style="margin-left: 40px">
  
  <br>
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">Date</th>
      <th scope="col">Total Amount</th>
      <th scope="col">Collected Amount</th> 
      <th scope="col">Due Amount</th> 
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1;
    int count;
    if(revenueCollected.size() > revenuePending.size()){
    	count = revenueCollected.size();
    }else{
    	count = revenuePending.size();
    }
  for( int i = 0; i < count; i++ ){ { 
	  Object[] collected = null;
	  Object[] pending = null;
	 try{
	  collected = revenueCollected.get(i);
	 }catch(Exception e){ 
	 }
	 
	 try{
		 pending = revenuePending.get(i);
	 	}catch(Exception e){ 
	 }
	 
	  Calendar cal1 = Calendar.getInstance();
	    Calendar cal2 = Calendar.getInstance();
	    cal1.setTime();
	    cal2.setTime();
  %>
  	<tr>
      <th scope="row"><%= i %></th>
      <td><strong><%= consumerList.getRrNumber() %></strong></td>
      <td><strong><%= consumerList.getFirstName() + " " + consumerList.getLastName()%></strong></td>
      <td><strong><%= consumerList.getEmail()%></strong></td>
      <td><strong><%= consumerList.getTypeOfConsumer()%></strong></td>
      <td><button type="submit" class="btn btn-secondary">Click Here Generate</button></td> 
    </tr>
    <%  i++ ; } %>
   		</tbody>
	</table>
	
  </div>
    </div>
    <script src="${js}/searchRRNumber.js"></script>
   	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>