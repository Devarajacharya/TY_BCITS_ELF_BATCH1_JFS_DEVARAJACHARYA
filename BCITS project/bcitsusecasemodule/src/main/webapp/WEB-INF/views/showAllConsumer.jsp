<%@page import="com.bcits.usecasemodule.bean.ConsumerInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% List<ConsumerInfoBean> conInfoBean = (List<ConsumerInfoBean>)request.getAttribute("consumerList"); %>
<% String msg =(String) request.getAttribute("msg"); %>
<% String errMsg =(String) request.getAttribute("errMsg"); %>
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
    
    <% if(msg != null && !msg.isEmpty()) { %>
     <div style="color: green; font-size:35px; font: bold; margin-right: 50px" align="center">
  	<strong style="transition-duration: 60s;"><%= msg %></strong>
	</div>
	<%}%>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
     <div style="color: red; font-size:35px; font: bold; margin-right: 50px" align="center">
  	<strong style="transition-duration: 60s;"><%= errMsg %></strong>
	</div>
	<%}%>
    <% if(conInfoBean != null && !conInfoBean.isEmpty()){ %>	
       <input class="form-control" id="myInput" type="text" placeholder="Search rrNumber..">
  <br>
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">RR Number</th>
      <th scope="col">Name</th>
      <th scope="col">Email Id</th> 
      <th scope="col">Type Of Consumer</th> 
      <th scope="col">Generate Bill</th>     
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1; 
  for( ConsumerInfoBean consumerList :conInfoBean) { %>
  <form action="./displayBillPage" method="get">
  <input  type="text"name ="rrNumber" value="<%=consumerList.getRrNumber() %>" hidden="true" >
  	<tr>
      <th scope="row"><%= i %></th>
      <td><strong><%= consumerList.getRrNumber() %></strong></td>
      <td><strong><%= consumerList.getFirstName() + " " + consumerList.getLastName()%></strong></td>
      <td><strong><%= consumerList.getEmail()%></strong></td>
      <td><strong><%= consumerList.getTypeOfConsumer()%></strong></td>
      <td><button type="submit" class="btn btn-secondary">Click Here Generate</button></td> 
    </tr>
    </form>
    <%  i++ ; } %>
   		</tbody>
	</table>
	<%} else { %>
	<h3><%=errMsg %></h3>
	<% } %>
  </div>
    </div>
    <script src="${js}/searchRRNumber.js"></script>
   	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>