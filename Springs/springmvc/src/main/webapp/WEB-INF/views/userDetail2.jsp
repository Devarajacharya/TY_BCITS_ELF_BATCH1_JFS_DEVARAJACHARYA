<%@page import="com.bcits.springmvc.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% UserBean userBean = (UserBean)request.getAttribute("userBean"); %>
 <%String name =(String)request.getAttribute("name"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: orange;">Successfully logged In </h1>
	<h3 style="color: navy;">
	Employee Id :<%= userBean.getEmpId()%> <br>
	Employee Name : <%=name %> <br>
	Password   : <%= userBean.getPassword()%>
	</h3>
</body>
</html>