<%@page import="java.util.List"%>
<%@page import="com.bcits.usecasemodule.bean.ConsumerInfoBean"%>
<%@page import="com.bcits.usecasemodule.bean.EmployeeMasterInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmployeeMasterInfo empInfo = (EmployeeMasterInfo)session.getAttribute("loggedInEmp"); %>
    <%long count = (long) request.getAttribute("count"); %>
    <% List<ConsumerInfoBean> conInfoBean = (List<ConsumerInfoBean>)request.getAttribute("consumerList"); %>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
    <jsp:include page="empHeaderPage.jsp"></jsp:include>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>EmployeeLogin</title>
  <link href="./resources/fontawesome-free-5.12.0-web/css/all.css " rel="stylesheet" type="text/css">
  <link href="${css}/sb-admin-2.min.css" rel="stylesheet">
   <link href="${css}/employeeHome.css">
  
</head>
<body style="background-color:  rgb(218, 229, 238);">
 <div class="d-flex" id="wrapper">
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion">
    

      <li class="nav-item">
        <a class="nav-link" href="index.html"> <span><h5><strong>Generate Bill</h5></strong></span></a>
      </li>
      
     <hr class="sidebar-divider my-0" >
      
      <li class="nav-item">
        <a class="nav-link" href=""> <span><h5><strong>Show All Consumer</strong></h5></span></a>
        </li>     
    </ul>
   <div id="page-content-wrapper" style="margin-left: 50px;color: rgb(23, 32, 42)"><br>
            <table style="font-size: 20px">
             <tr>
                    <td><strong>Employee Details</strong></td>
                </tr>
                <tr>
                    <td><strong>Employee ID</strong></td>
                    <td>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><strong><%= empInfo.getEmpId() %></strong></td>
                </tr>
                <tr>
                    <td><strong>employee Name</strong></td>
                    <td>:</td>
                    <td><strong><%= empInfo.getEmpName()%></strong></td>
                </tr>
                <tr>
                    <td><Strong>Designation</Strong></td>
                    <td>:</td>
                    <td><strong><%= empInfo.getDesignation() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Region</strong></td>
                    <td>:</td>
                    <td><strong><%= empInfo.getRegion() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>Number of Consumer</Strong></td>
                    <td>:</td>
                    <td><strong><%= count%></strong></td>
                </tr>
            </table><br><br>
          <% if(conInfoBean != null ){ %>
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">RR NUmber</th>
      <th scope="col">Name</th>
      <th scope="col">Email Id</th> 
      <th scope="col">Type Of Consumer</th> 
      <th scope="col">Generate Bill</th> 
      
    </tr>
  </thead>
  <tbody>
    <%int i=1; 
  for( ConsumerInfoBean consumerList :conInfoBean) { %>
  <form action="./displayBillPage">
  <input name ="rrNumber" type="number" value="<%=consumerList.getRrNumber() %>" hidden="true" >
  	<tr>
      <th scope="row"><%= i %></th>
      <td><strong><%= consumerList.getRrNumber() %></strong></td>
      <td><strong><%= consumerList.getFirstName() + " " + consumerList.getLastName()%></strong></td>
      <td><strong><%= consumerList.getEmail()%></strong></td>
      <td><strong><%= consumerList.getTypeOfConsumer()%></strong></td>
      <td><button type="button" class="btn btn-secondary">Click Here Generate</button></td> 
    </tr>
    </form>
    <%  i++ ; } %>
   		</tbody>
	</table>
	<%} else { %>
	<h3><%=errMsg %></h3>
	<% } %>
  </div>
  </div>
  
</body>
</html>
    