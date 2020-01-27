<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp"></jsp:include>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<br><br>
<h2 style="color: red; font: bold;" align="center"> <%=errMsg %></h2>
<br><br>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>