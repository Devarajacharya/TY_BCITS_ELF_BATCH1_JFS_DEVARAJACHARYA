<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% String msg = (String) request.getAttribute("msg"); %>
    <jsp:include page="consHeaderPage.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% if(msg != null && !msg.isEmpty()){ %>
     <div style="color: green; font-size:35px; font: bold; margin-right: 50px" align="center">
  	<strong><%= msg %></strong>
	</div>
   <%} %>

</body>
</html>