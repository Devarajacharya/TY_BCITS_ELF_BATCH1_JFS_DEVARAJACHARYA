<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link href="${css}/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top" style="background-color:  rgb(218, 229, 238);">
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Devraj</div></a>
      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <span><h5>Generate Bill</h5></span></a>
      </li>
      
     <hr class="sidebar-divider my-0">
      
      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <span><h5>Show All Consumer</h5></span></a>
        </li>
    </ul>
    
</body>
</html>
    