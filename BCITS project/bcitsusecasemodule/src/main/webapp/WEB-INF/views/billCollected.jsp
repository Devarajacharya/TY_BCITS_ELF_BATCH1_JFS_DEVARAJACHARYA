<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.usecasemodule.bean.CurrentBill"%>
<%@page import="com.bcits.usecasemodule.bean.BillHistory"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.usecasemodule.bean.MonthlyConsumption"%>
<%@page import="com.bcits.usecasemodule.bean.EmployeeMasterInfo"%>
<%@page import="com.bcits.usecasemodule.bean.ConsumerInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% List<BillHistory> billHistroyList = (List<BillHistory>)request.getAttribute("billHistroy"); %>
<% String errMsg =(String) request.getAttribute("errMsg"); %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="empHeaderPage.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Generator</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="./resources/fontawesome-free-5.12.0-web/css/all.css "rel="stylesheet" type="text/css">
<link href="${css}/sb-admin-2.min.css" rel="stylesheet">
<link rel="stylesheet" href="${css}/bill.css">

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
		<div style="margin-left: 40px">
			<br>	
     	
	<% if(billHistroyList != null && !billHistroyList.isEmpty()){ %>	
       <input class="form-control" id="myInput" type="text" placeholder="Search Month..">
  <br>
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">RR Number</th>
      <th scope="col">Amount Paid</th> 
      <th scope="col">PaymentDate</th> 
      <th scope="col">Payment Status</th>     
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1; 
    for(BillHistory bill : billHistroyList) {%>
    
  	<tr>
      <th scope="row"><%= i %></th>
      <td><strong><%= bill.getBiHistoryPK().getRrNumber()%></strong></td>
      <td><strong><%= bill.getAmount()%></strong></td>
      <td><strong> <% SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); %>
      <%= formatter.format(bill.getBiHistoryPK().getPaymentDate()) %></strong></td>
      <td style="color: green;"><strong><%= bill.getStatus()%></strong></td>
    </tr>
    <%  i++ ; } %>
   		</tbody>
	</table>
	<%} else{%>
	<h3 style="color: navy;"><%=errMsg %></h3>
	<% } %>	
	</div>
		</div>
		</div>
	<script src="${js}/searchRRNumber.js"></script>
   	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>