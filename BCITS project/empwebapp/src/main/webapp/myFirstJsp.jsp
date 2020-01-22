<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%! private int a = 10;
     public void setA(int a){
    	 this.a=a;
     }
     public int getA(){
    	 return a;
     }
     
     public String name="seema";
     
     public String getName(){
    	 return name;
     }
     public String getName(String name){
    	 return name;
     }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: green"><b>Welcome to JSP..</b></h1><h3 style="color: orange;">
	a =<%=a %> <br>
	a =<%= getA() %> <br>
	<% setA(100); %>
	a =<%= getA() %> <br> <br>
	
	name = <%=name %> <br>
	name = <%= getName() %> <br>
	name =<%= getName(" Dinga") %> <br> <br>
	
	<% for(int i=0; i<5; i++){ %>
	<%= getName() %> <br>
	<% } %>
	</h3>
</body>
</html>

<%@ include file="date.html" %>

<%-- <jsp:forward page="./currentDate"></jsp:forward>
 --%>
<%-- <jsp:forward page="./date.html"></jsp:forward>--%>

 <%-- <jsp:forward page="./searchEmp?empId=123"> --%>
 
<%-- <jsp:forward page="./searchEmp">
<jsp:param value="120" name="empId"/>
</jsp:forward> --%>


<%-- <jsp:include page="/currentDate"></jsp:include>--%>
<%-- <jsp:include page="/searchEmp">
<jsp:param value="120" name="empId"/>
</jsp:include> --%>



















