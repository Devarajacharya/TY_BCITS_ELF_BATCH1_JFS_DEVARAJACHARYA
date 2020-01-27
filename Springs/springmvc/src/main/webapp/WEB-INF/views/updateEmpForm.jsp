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
	
	<br> <br> <br> 

</body>
</html>
<% if(msg != null && !msg.isEmpty()) {%>
<h2 style="color: green" align="center"><%= msg %></h2>
<%} %>

<% if(errMsg != null && !errMsg.isEmpty()) {%>
<h2 style="color: red;" align="center" ><%= errMsg %></h2>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>