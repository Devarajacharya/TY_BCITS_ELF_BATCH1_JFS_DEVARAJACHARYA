<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="consHeaderPage.jsp"></jsp:include>
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
<link rel="stylesheet" href="${css}/CurrentBill.css">

</head>
<body>
<div class="row" >
  <div class="col-3" ><br>
   <div class="list-group" style="text-align: center;font: bold;font-size: 20px;margin-left: 40px;margin-right: ">
  <a href="./displayConsumerHome" class="list-group-item list-group-item-action ">My Account</a>
  <a href="./displayCurrentBillPage" class="list-group-item list-group-item-action">Current Bill</a>
  <a href="./displayMonthlyConsumptionPage" class="list-group-item list-group-item-action">Monthly Consumption</a>
  <a href="./displayBillHistorysPage" class="list-group-item list-group-item-action ">Bill History</a>
  <a href="./consumerPaymentPage" class="list-group-item list-group-item-action">Pay Online</a>
  <a href="./displyPasswordPage" class="list-group-item list-group-item-action">Change Password</a>
  <a href="./diplayResponse" class="list-group-item list-group-item-action " >Complaints Details</a>
  
  
</div>
  </div>
  <div class="col-7" align="center"><br>
  	<strong style="font-size: 30px; color: navy;"> <%= errMsg %> </strong>
  </div>
  </div>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>