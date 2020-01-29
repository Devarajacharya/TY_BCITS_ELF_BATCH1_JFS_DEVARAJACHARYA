<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
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
<link rel="stylesheet" href="${css}/employeeHome.css">
</head>
<body>
	<%if (msg != null && !msg.isEmpty()) {%>
	<div style="color: green; font-size: 35px; font: bold; margin-right: 50px" align="center">
		<strong><%=msg%></strong>
	</div>
	<%}%>
	<div class="row">
		<div class="col-2">
			<div class="list-group" id="list-tab" role="tablist"
				style="text-align: center;">
				<a class="list-group-item list-group-item-action active"
					id="list-home-list" data-toggle="list" href="#list-home" role="tab"
					aria-controls="home">Employee Details</a> <a
					class="list-group-item list-group-item-action"
					id="list-profile-list" data-toggle="list" href="#list-profile"
					role="tab" aria-controls="profile"></a> Current Bill<a
					class="list-group-item list-group-item-action"
					id="list-messages-list" data-toggle="list" href="#list-messages"
					role="tab" aria-controls="messages">Bill History</a> <a
					class="list-group-item list-group-item-action"
					id="list-settings-list" data-toggle="list" href="#list-settings"
					role="tab" aria-controls="settings">Monthly Consumption</a>
			</div>
		</div>
		<div class="col-9">
			<div class="consumerDetails">
				<fieldset>
					<table>
						<tr>
							<td><strong>Name</strong></td>
							<td>:</td>
							<td></td>
						</tr>
						<tr>
							<td><strong>RR Number</strong></td>
							<td>:</td>
							<td></td>
						</tr>
						<tr>
							<td><Strong>PhoneNumber</Strong></td>
							<td>:</td>
							<td></td>
						</tr>
						<tr>
							<td><strong>Email</strong></td>
							<td>:</td>
							<td></td>
						</tr>
						<tr>
							<td><Strong>Region</Strong></td>
							<td>:</td>
							<td></td>
						</tr>
						<tr>
							<td><strong>Type Of Consumer</strong></td>
							<td>:</td>
							<td></td>
						</tr>
					</table>
				</fieldset>
			</div>
		</div>
	</div>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/employeeLogin.js"></script>
</body>
</html>