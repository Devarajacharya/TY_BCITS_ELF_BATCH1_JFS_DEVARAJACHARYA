<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="com.bcits.usecasemodule.bean.ConsumerInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% ConsumerInfoBean conInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons"); %>
<jsp:include page="consHeaderPage.jsp"></jsp:include>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/consumerHome.css">
</head>
<body>
<br>
<div class="welcome" ><br>
	<h3 style="margin-top: -10px">Welcome To DISCOM Electricity Limited</h3><br>
</div>
<div class="row" >
  <div class="col-3" ><br>
    <div class="list-group" id="list-tab" role="tablist">
      <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">Consumer Details</a>
      <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">Current Bill</a>
      <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">Monthly Consumption</a>
      <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings">Bill History</a>
    </div>
  </div>
 <div class="col-8">
    <div class="consumerDetails"> <br>
            <table style="font-size: 20px">
                <tr>
                    <td><strong>Name</strong></td>
                    <td>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><strong><%= conInfoBean.getFirstName()+" "+conInfoBean.getLastName() %></strong></td>
                </tr>
                <tr>
                    <td><strong>RR Number</strong></td>
                    <td>:</td>
                    <td><strong><%= conInfoBean.getRrNumber() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>PhoneNumber</Strong></td>
                    <td>:</td>
                    <td><strong><%= conInfoBean.getPhoneNumber() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Email</strong></td>
                    <td>:</td>
                    <td><strong><%= conInfoBean.getEmail() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>Region</Strong></td>
                    <td>:</td>
                    <td><strong><%= conInfoBean.getRegion()%></strong></td>
                </tr>
                <tr>
                    <td><strong>Type Of Consumer</strong></td>
                    <td>:</td>
                    <td><strong><%= conInfoBean.getTypeOfConsumer() %></strong></td>
                </tr>
            </table>
  	  </div>
  	  
  	  <br> <br><div class="form-group" style="width: 500px; font-size: 20px ;">
  		<label for="comment"><strong>Comment:</strong></label>
 		<textarea class="form-control" rows="4 " id="comment"></textarea><br>
 		<button type="submit" formaction="./" class="btn btn-primary" style="margin-top: -7px;">Submit</button>
	</div> 
	</div>
</div>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/employeeLogin.js"></script>
</body>
</html>