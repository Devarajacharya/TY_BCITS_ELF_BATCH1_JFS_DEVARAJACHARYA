<%@page import="com.bcits.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp"></jsp:include>
    <% EmployeeInfoBean empBean =(EmployeeInfoBean) session.getAttribute("loggedInEmp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: purple;" align="center"> Welcome <%= empBean.getEmpname() %></h1>
</body>
</html>
<br> <br> <br>
 <jsp:include page="footer.jsp"></jsp:include>
