<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="consHeaderPage.jsp"></jsp:include>
<% String msg =(String) request.getAttribute("msg"); %>
<% String errMsg =(String) request.getAttribute("errMsg"); %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/consumerHome.css">
</head>
<body>
<div class="row" >
  <div class="col-3"><br>
   <div class="list-group" style="text-align: center;font: bold;font-size: 20px;margin-left: 40px;margin-right: ">
   <a href="./displayConsumerHome" class="list-group-item list-group-item-action ">My Account</a>
  <a href="./displayCurrentBillPage" class="list-group-item list-group-item-action">Current Bill</a>
  <a href="./displayMonthlyConsumptionPage" class="list-group-item list-group-item-action">Monthly Consumption</a>
  <a href="./displayBillHistorysPage" class="list-group-item list-group-item-action">Bill History</a>
  <a href="./consumerPaymentPage" class="list-group-item list-group-item-action">Pay Online</a>
  <a href="./displyPasswordPage" class="list-group-item list-group-item-action active">Change Password</a>
  <a href="./diplayResponse" class="list-group-item list-group-item-action">Complaints Details</a>
  
</div>
  </div>
  <div class="col-6" style="margin-left: 40px;" ><br>
  
     <% if(msg != null && !msg.isEmpty()) { %>
     <div style="color: navy; font-size:35px; font: bold; margin-right: 50px" align="center">
  	<strong style="transition-duration: 60s;"><%= msg %></strong>
	</div>
	<%}%>
	
	 <% if(errMsg != null && !errMsg.isEmpty()) { %>
     <div style="color: red; font-size:35px; font: bold; margin-right: 50px" align="center">
  	<strong style="transition-duration: 60s;"><%= errMsg %></strong>
	</div>
	<%}%>
	<br>
<fieldset style="width: 500px;">

  <form action="./changePassword" method="post">
  <h3>Enter the Password to Change </h3>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Password</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="password">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Confirm Password</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="confPassword">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
 </fieldset>
  </div>
  </div>
<script src="${js}/bootstrap.min.js"></script>
<script src="${js}/employeeLogin.js"></script>
</body>
</html>