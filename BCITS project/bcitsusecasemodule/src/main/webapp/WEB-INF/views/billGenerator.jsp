<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.bcits.usecasemodule.bean.ConsumerInfoBean"%>
<%@page import="com.bcits.usecasemodule.bean.EmployeeMasterInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% ConsumerInfoBean conInfoBean = (ConsumerInfoBean) request.getAttribute("consumerBean"); %>
<% EmployeeMasterInfo employee = (EmployeeMasterInfo) session.getAttribute("loggedInEmp"); %>
<% long prev = (long) request.getAttribute("prev");%>

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

			<li class="nav-item"><a class="nav-link" href="./displayEmpHome"> <span><strong>Employe Profile</strong></span></a></li>
			<hr class="sidebar-divider my-0">
			
			<li class="nav-item"><a class="nav-link" href="./getConsumer"> <span><strong>Generate Bill</strong></span> </a></li>
			<hr class="sidebar-divider my-0">

			<li class="nav-item"><a class="nav-link" href="./showConsumer"> <span><strong>Consumer Details</strong></span></a></li>
			<hr class="sidebar-divider my-0">
			
			<li class="nav-item"><a class="nav-link" href="./complaintsDetails"> <span><strong>Complaints Details</strong></span></a></li>
			<hr class="sidebar-divider my-0">  
			
			<li class="nav-item"><a class="nav-link" href="./BillCollected"> <span><strong>Bill Collected</strong></span></a></li>
			<hr class="sidebar-divider my-0"> 
			
			<li class="nav-item"><a class="nav-link" href="./monthRevenue"> <span><strong>Monthly Revenue</strong></span></a></li>
			<hr class="sidebar-divider my-0">   	
		</ul>
		
		
		<div id="page-content-wrapper bill">
			<br>	
			<% if(conInfoBean != null){ %>
			<form id="formData" onsubmit="validation(); return false" method="post" >
				<h3 >Bill Generator</h3>
				<div class="form-row">
					<div class="form-group col-md-10">
						<label for="rrNum">RR Number</label> 
						<input type="tel" class="form-control" id="rrNum" name="rrNumber" value="<%= conInfoBean.getRrNumber() %>" readonly="readonly" placeholder="RR Number">
					</div>
				</div>
				
				<div class="form-row">
					<div class="form-group col-md-5">
						<label for="prev">Previous Reading</label> <input type="tel"
							class="form-control" id="prev"  name="previousReading" value="<%= prev %>" readonly="readonly" placeholder="Previous Reading">
					</div>
					
					<div class="form-group col-md-5">
						<label for="pres">Presence Reading</label> 
						<input type="number" class="form-control" id="pres" name="presenceReading"  placeholder="Presence Reading"  required="required" class="noscroll">
							<span id="presence" style="color: red;"></span>
							
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-5">
						<label for="date">Type Of Consumer</label> 
						<input type="text" class="form-control" name="typeOfConsumer" value="<%= conInfoBean.getTypeOfConsumer()%>" readonly="readonly" id="date">
					</div>
					
					<div class="form-group col-md-5">
						<label for="dueDate">Due Date</label> 
						<input type="date" class="form-control" id="dueDate" name="dueDate" required="required" >
						<span id="due" style="color: red;"></span>
							
					</div>
				</div>
				<button id="login" type="submit" formaction="./generateBill" class="btn btn-success">Generate Bill</button>
				
				<input type="text" class="form-control"  name="region" value ="<%= employee.getRegion() %>"hidden="true">
			</form>
			<% } %>
		</div>
		<script src="${js}/jquery-3.4.1.js"></script>
		<script src="${js}/billGenerator.js"></script>
    	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>