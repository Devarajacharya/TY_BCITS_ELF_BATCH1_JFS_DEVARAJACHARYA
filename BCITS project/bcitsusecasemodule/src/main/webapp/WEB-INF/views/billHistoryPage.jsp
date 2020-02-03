<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.usecasemodule.bean.BillHistory"%>
<%@page import="com.bcits.usecasemodule.bean.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% List<BillHistory> billHistory = (List<BillHistory>) request.getAttribute("billHistory"); %>
<jsp:include page="consHeaderPage.jsp"></jsp:include>
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
   <a href="./displayConsumerHome" class="list-group-item list-group-item-action active">My Account</a>
  <a href="./displayCurrentBillPage" class="list-group-item list-group-item-action">Current Bill</a>
  <a href="./displayMonthlyConsumptionPage" class="list-group-item list-group-item-action">Monthly Consumption</a>
  <a href="./displayBillHistorysPage" class="list-group-item list-group-item-action">Bill History</a>
  <a href="./consumerPaymentPage" class="list-group-item list-group-item-action">Pay Online</a>
   <a href="#" class="list-group-item list-group-item-action">Change Password</a>
  
</div>
  </div>
  <div class="col-8 " style="margin-left: 40px;"><br>
  <div class="card ">
  <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.NO</th>
      <th scope="col">Payment Amount</th>
      <th scope="col">Payment Date</th>
      <th scope="col">Payment Description</th>
      
    </tr>
  </thead>
  <tbody>
  <%int i=1; 
  for( BillHistory bill :billHistory) { %><tr>
      <th scope="row"><%= i %></th>
      <td><%= bill.getAmount() %></td>
      <td>
      <% SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); %>
      <%= formatter.format(bill.getBiHistoryPK().getPaymentDate()) %></td>
      <td style="color: green;"><%= bill.getStatus() %></td>
	    </tr>
    <% i++; 
    } %>
   </tbody>
</table>
</div>
  </div>
  </div>
</body>
</html>