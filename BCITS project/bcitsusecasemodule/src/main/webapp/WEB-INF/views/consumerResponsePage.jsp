<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.usecasemodule.bean.SupportBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="consHeaderPage.jsp"></jsp:include>
<% String errMsg =(String) request.getAttribute("errMsg"); %>
<% List<SupportBean> supportlist = (List<SupportBean>) request.getAttribute("supportBean"); %>
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
<link rel="stylesheet" href="${css}/currentBill.css">

</head>
<body >
<div class="row" >
  <div class="col-3" ><br>
   <div class="list-group" style="text-align: center;font: bold;font-size: 20px;margin-left: 40px;margin-right: ">
  <a href="./displayConsumerHome" class="list-group-item list-group-item-action ">My Account</a>
  <a href="./displayCurrentBillPage" class="list-group-item list-group-item-action">Current Bill</a>
  <a href="./displayMonthlyConsumptionPage" class="list-group-item list-group-item-action">Monthly Consumption</a>
  <a href="./displayBillHistorysPage" class="list-group-item list-group-item-action ">Bill History</a>
  <a href="./consumerPaymentPage" class="list-group-item list-group-item-action">Pay Online</a>
  <a href="./displyPasswordPage" class="list-group-item list-group-item-action">Change Password</a>
  <a href="./diplayResponse" class="list-group-item list-group-item-action active">Complaints Details</a>
  
</div>
  </div>
  <div class="col-7" align="center"><br>
  <table class="table table-bordered">
  <thead class="thead-dark">
    <tr>
      <th scope="col">SL.NO</th>
      <th scope="col">Date</th>
      <th scope="col">Request</th>
      <th scope="col">Response</th>
      
    </tr>
  </thead>
  <tbody>
  <%int i=1; 
  for(SupportBean supportBean :supportlist) { %><tr>
    <tr style="height: 100px;">
      <th scope="row"><%=i %></th>
      <% SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); %>
     <td> <%= formatter.format(supportBean.getSupportBeanPK().getDate()) %> </td>
      <td><%= supportBean.getRequest() %></td>
      <td><%= supportBean.getSupport() %></td>
      
    </tr>
     <% i++; 
    } %>
  </tbody>
</table>
  </div>
  </div>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>