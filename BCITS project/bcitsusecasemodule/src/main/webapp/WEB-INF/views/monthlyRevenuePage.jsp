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

    <% 
    int j=0;
    int k=0;
 
  for( int i = 0; i < totalRevenue.size(); i++ ) { 
	  
	   	Object[] collected = null;
		Object[] pending = null;
		Object[] total = null;
		
		try{	 
	  if(revenueCollected != null && !revenueCollected.isEmpty()){
	  collected = revenueCollected.get(j);
	  }
	 
	  if(revenuePending != null && !revenuePending.isEmpty()){
	  pending = revenuePending.get(k);
	  }
	  
	  }catch(Exception e){
		  
	  }
	  
	  
	  if(totalRevenue != null && !totalRevenue.isEmpty()){
	  total = totalRevenue.get(i);
	  }
  		%>
  	<tr>
      <th scope="row"><%= i+1 %></th>
      
       <%try{
    	   
       if(totalRevenue != null && !totalRevenue.isEmpty()){%>  
      <td><strong><%= total[1]%></strong></td>
      <td><strong><%= total[0] %></strong></td>
      <%} %>
      
      <%  if(revenueCollected != null && !revenueCollected.isEmpty() && collected[1].equals(total[1]) ){ %>
    		  <td><strong><%= collected[0]%></strong></td>
      <% j++;}else{%>
      		<td><strong>null</strong></td>
      <%  } %>
       <% if(revenuePending != null && !revenuePending.isEmpty() && pending[1].equals(total[1]) ){ %>
      <td><strong><%= pending[0]%></strong></td>
      <% k++;} else { %>
     		 <td><strong>null</strong></td>
      <%  } %>
    </tr>
    <%}catch(Exception e){%>
    	<td><strong>null</strong></td>
   <% }} %>
   		</tbody>
	</table>
	
  </div>
    </div>
    <script src="${js}/searchRRNumber.js"></script>
   	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>