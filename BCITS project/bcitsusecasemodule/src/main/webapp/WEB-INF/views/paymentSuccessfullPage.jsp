<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${css}/paymentSucessfull.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
    <title>Document</title>
</head>
<body>
    <form action="./displayConsumerHome">
    <div class="jumbotron text-center">
        <img src="/Paymentpage/images/Konfest-PNG-JPG-Image-Pic-Photo-Free-Download-Royalty-Unlimited-clip-art-sticker-Check-Mark-Symbol-Right-Tick-Yes-Green-14.png" alt="">
        <h1 class="display">Thank You!</h1>
        <h1>Payment Sucessful</h1>
        <p>
          Having trouble? <a href="">Contact us</a>
        </p>
        </div>
      <div class="panel-footer">
        <div class="sumbot">
            <button class="btn btn-success btn-lg btn-block">Continue To HomePage</button>
        </div>
    </div>
    </form>
    <script src="./resources/js/jquery-3.4.1.js"></script>
    <script src="./resources/js/bootstrap.min.js"></script>
</body>
</html>