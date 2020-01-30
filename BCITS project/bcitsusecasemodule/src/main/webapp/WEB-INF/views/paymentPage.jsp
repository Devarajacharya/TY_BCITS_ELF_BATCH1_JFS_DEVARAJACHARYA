<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="consHeaderPage.jsp"></jsp:include>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Payment Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/payment.css">
</head>
<body>  
  
    <div class="page-header text-center">
        <h2>Credit Card Payment Gateway</h2>
    </div>
    <form action="${html}/paymentSucessful.html" onsubmit="validation(); return false ">
        <h3 class="text-center">Payment Details</h3>
        <div class="inlineimage">
            <img class="img-responsive images"
                src="https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/Mastercard-Curved.png">
            <img class="img-responsive images"
                src="https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/Discover-Curved.png">
            <img class="img-responsive images"
                src="https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/Paypal-Curved.png">
            <img class="img-responsive images"
                src="https://cdn0.iconfinder.com/data/icons/credit-card-debit-card-payment-PNG/128/American-Express-Curved.png">
        </div>
        <div class="form-group"> <label>Enter Amount</label>
            <div class="input-group"> 
                <input type="tel" class="form-control" placeholder="Enter the Amount">
            </div>
            </div>
        <div class="form-group"> <label>CARD NUMBER</label>
            <div class="input-group"> 
                <input type="tel" class="form-control" placeholder="Valid Card Number">
            </div>
            <div class="row">
                <div class="col-xs-7 col-md-7">
                    <div class="form-group"> <label><span class="hidden-xs">EXPIRATION</span><span
                                class="visible-xs-inline">EXP</span> DATE</label> <input type="tel" class="form-control"
                            placeholder="MM / YY" /> </div>
                </div>
                <div class="col-xs-5 col-md-5 pull-right">
                    <div class="form-group"> <label>CV CODE</label> <input type="tel" class="form-control"
                            placeholder="CVC" /> </div>
                </div>
            </div>
            <div class="col-xs-12">
                <div class="form-group"> <label>CARD OWNER</label> <input type="text" class="form-control"
                        placeholder="Card Owner Name" /> </div>
            </div>
        </div>
        <div class="panel-footer">
            <div class="sumbot">
                <div class="col-xs-8"> 
                    <button class="btn btn-success btn-lg btn-block">Confirm Payment</button>
                </div>
            </div>
        </div>
    </form>
   <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/payment.js"></script>
</body>
</html>