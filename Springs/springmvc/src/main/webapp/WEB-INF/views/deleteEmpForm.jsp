<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp"></jsp:include>
    <%String msg =(String) request.getAttribute("msg");
    String errMsg =(String) request.getAttribute("errMsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset style="width: 300px; margin-left:550px">
		<legend><h2>Delete Employee</h2></legend>
		<form action="./delete">
			Employee ID : <input type="text" name="empId" required> <br>
			<br> <input type="submit" value="Delete"
				style="margin-left: 98px;">

		</form>
		</fieldset>
		<br><br>
</body>
</html>

<% if(msg != null && !msg.isEmpty()) {%>
<h2 style="color: green" align="center"><%= msg %></h2>
<%} %>

<% if(errMsg != null && !errMsg.isEmpty()) {%>
<h2 style="color: red;" align="center" ><%= errMsg %></h2>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>