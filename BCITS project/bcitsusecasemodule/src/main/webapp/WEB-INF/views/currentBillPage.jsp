<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.usecasemodule.bean.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bcits.usecasemodule.bean.ConsumerInfoBean"%>
<% ConsumerInfoBean conInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons"); %> 
<% CurrentBill currentBill = (CurrentBill) request.getAttribute("currentBill"); %> 
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
  <div class="col-3" ><br>
   <div class="list-group" style="text-align: center;font: bold;font-size: 20px;margin-left: 40px;margin-right: ">
  <a href="./displayConsumerHome" class="list-group-item list-group-item-action ">My Account</a>
  <a href="./displayCurrentBillPage" class="list-group-item list-group-item-action active">Current Bill</a>
  <a href="./displayMonthlyConsumptionPage" class="list-group-item list-group-item-action">Monthly Consumption</a>
  <a href="./displayBillHistorysPage" class="list-group-item list-group-item-action">Bill History</a>
  <a href="./consumerPaymentPage" class="list-group-item list-group-item-action">Pay Online</a>
  <a href="./displyPasswordPage" class="list-group-item list-group-item-action">Change Password</a>
</div>
  </div>
  <div class="col-5" style="margin-left: 50px"><br>
  <div class="card"><br>
  <h3 align="center">ELECTRICITY BILL</h3><br>
   <table style="font-size: 20px; margin-left: 30px;">
                <tr>
                    <td><strong>Name</strong></td>
                    <td>: &nbsp;&nbsp;</td>
                    <td><strong><%= conInfoBean.getFirstName()+" "+conInfoBean.getLastName() %></strong></td>
                </tr>
                <tr>
                    <td><strong>RR Number</strong></td>
                    <td>:</td>
                    <td><strong><%= conInfoBean.getRrNumber() %></strong></td>
                </tr>
                
                <tr>
                    <td><Strong>Previous Reading</Strong></td>
                    <td>:</td>
                    <td><strong><%=currentBill.getPreviousReading() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Presence Reading</strong></td>
                    <td>:</td>
                    <td><strong><%=currentBill.getPresenceReading() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Consumption</strong></td>
                    <td>:</td>
                    <td><strong><%=currentBill.getConsumption() %></strong></td>
                </tr>
                 <tr>
                    <td><strong>Bill Amount</strong></td>
                    <td>:</td>
                    <td><strong><%=currentBill.getBillAmount() %></strong></td>
                </tr>
                 <tr>
                    <td><Strong>Due Date</Strong></td>
                    <td>:</td>
                     
                    <td><% SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); %>
                          <strong><%= formatter.format(currentBill.getDueDate()) %></strong></td>
                </tr>
            </table><br>
  	  </div>
  </div>
  </div>
</body>
</html>