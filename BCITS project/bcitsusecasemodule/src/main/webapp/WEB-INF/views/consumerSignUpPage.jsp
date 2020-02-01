<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<% String errMsg =(String) request.getAttribute("errMsg"); %>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignUp page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/signup.css">
</head>

<body>

    <nav>
        <span class="navbar-toggler-icon">
            <img id="logo" src="${images}/logo.png" >
        </span>
        <span class="navbar-brand mb-0 h1"></span>
        <h1 id="title">DISCOM ELECTRICITY LIMITED</h1>
        <div class="homelink "> 
			<a style="color: white;" href="./discomHomePage"><i class="fas fa-home"></i>Home</a> &nbsp; &nbsp; 
            <a style="color: white;" href="#">About</a> 
        </div>
    </nav>
  
    <form  id="formData" onsubmit="validation(); return false" method="post">
     <% if(errMsg != null && !errMsg.isEmpty()){ %>
   <h2 style="color: red; font: bold; margin-right: 10px" align="center"> <%= errMsg %></h2>
   <%} %>
        <h3>Sign Up Here</h3>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="fname">First Name</label>
                <input type="text" class="form-control" id="fname" name="firstName" placeholder="First Name">
                <span id="firstname" style="color: red;"></span>
            </div>
            <div class="form-group col-md-6">
                <label for="lname">Last Name</label>
                <input type="text" class="form-control" id="lname" name="lastName" placeholder="Last Name">
                <span id="lastname" style="color: red;"></span>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                <span id="emailid" style="color: red;"></span>
            </div>
            <div class="form-group col-md-6">
                <label for="pnumber">Phone Number</label>
                <input type="tel" class="form-control" id="pnumber" name="phoneNumber" placeholder="Phone Number">
                <span id="phonenumber" style="color: red;"></span>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="psw">Password</label>
                <input type="password" class="form-control" id="psw" name="password" placeholder="Password">
                <span id="password" style="color: red;"></span>
            </div>
            <div class="form-group col-md-6">
                <label for="cpsw">Confirm Password</label>
                <input type="password" class="form-control" id="cpsw" name="cnfPassword" placeholder="Confirm Password">
                <span id="confirmpassword" style="color: red;"></span>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="mnumber">RR Number</label>
                <input type="text" class="form-control" id="mnumber" name="rrNumber" placeholder="	RR Number">
                <span id="rrnumber" style="color: red;"></span>
            </div>
            <div class="form-group col-md-4">
                <label for="region">Region</label>
                <select id="region" class="form-control" name="region" required>
                    <option selected>Choose...</option>
                    <option>Bangalore North</option>
                    <option>Bangalore South</option>
                </select>  
            </div>
            <div class="form-group col-md-4">
                <label for="region">Consumer Type</label>
                <select id="typeOfConsumer" class="form-control" name="typeOfConsumer" required>
                    <option selected>Choose...</option>
                    <option>Residential consumers</option>
                    <option>Commercial consumers</option>
                    <option>Industries</option>
                </select>  
            </div>
        </div>
        <div class="form-group">
            <label for="inputAddress">Address</label>
            <input type="text" class="form-control" id="houseNum" name="houseNumber" placeholder="House Number">
            <span id="houseno" style="color: red;"></span><br>
            <input type="text" class="form-control" id="inputAddress1" name="address1" placeholder="Address Line 1"> <br>
            <span id="add1" style="color: red;"></span>
            <input type="text" class="form-control" id="inputAddress2" name="address2" placeholder="Address Line 2"> 
            <span id="add2" style="color: red;"></span>
            </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck" required>
                <label class="form-check-label" for="gridCheck">
                    By signing up, I agree to the terms of use and customer terms 
                </label>
            </div>
        </div>
        <button id="login" type="submit"  formaction="./addConsumer" class="btn btn-success">Sign Up</button>
    </form>

    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/signup.js"></script>
</body>

</html>