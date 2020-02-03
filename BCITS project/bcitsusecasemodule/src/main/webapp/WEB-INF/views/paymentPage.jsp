<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="html" value="/resources/html" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Payment Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/payment.css">
</head>

<body>
	<nav>
		<span class="navbar-toggler-icon"> <img id="logo"
			src="${images}/logo.png" alt="">
		</span> <span class="navbar-brand mb-0 h1"></span>
		<h1 id="title">DISCOM ELECTRICITY LIMITED</h1>
		<div class="homelink " align="right">
			<a style="color: white;" href="./displayConsumerHome"><i class="fas fa-home"></i>Home</a> &nbsp; &nbsp; 
			<a style="color: white;" href="./consumerLogout"><i class="fas fa-sign-out-alt"></i>SignOut</a>&nbsp; &nbsp;

		</div>
	</nav>
	<div class="page-header text-center">
		<h2>Credit Card Payment Gateway</h2>
	</div>
	<form  action="./successfullPaymentPage" id="formData" onsubmit="validation(); return false " method="post">
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
		<div class="form-group">
			<label>ENTER AMOUNT</label>
			<div class="input-group">
				<input type="tel" class="form-control"
					placeholder="Enter the Amount" name="amount"  id="amt">
			</div>
			<span id="billamount" style="color: red;"></span>
		</div>
		<div class="form-group">
			<label>CARD NUMBER</label>
			<div class="input-group">
				<input type="tel" class="form-control"
					placeholder="Valid Card Number" id="cardNum">
			</div>
			<span id="cdNum" style="color: red;"></span>
			<div class="row">
				<div class="col-xs-7 col-md-7">
					<div class="form-group">
						<label><span class="hidden-xs">EXPIRATION</span><span
							class="visible-xs-inline">EXP</span> DATE</label> <input type="tel"
							class="form-control" placeholder="MM / YY" id="date" />
					</div>
									<span id="expdate" style="color: red;"></span>
				</div>
				<div class="col-xs-5 col-md-5 pull-right">
					<div class="form-group">
						<label>CV CODE</label> <input type="tel" class="form-control"
							placeholder="CVC" id="cvNum" />
					</div>
				</div>
				<span id="cv" style="color: red;"></span>
			</div>
			<div class="col-xs-12">
				<div class="form-group">
					<label>CARD OWNER</label> <input type="text" class="form-control"
						placeholder="Card Owner Name" id="name" />
				</div>
			</div>
			<span id="fname" style="color: red;"></span>
		</div>
		<div class="panel-footer">
			<div class="sumbot">
				<div class="col-xs-8">
					<button class="btn btn-success btn-lg btn-block" >Confirm Payment</button>
				</div>
			</div>
		</div>
	</form>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/payment.js"></script>
</body>
</html>