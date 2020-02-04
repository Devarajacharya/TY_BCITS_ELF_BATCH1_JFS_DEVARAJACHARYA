<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./resources/adminHome.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

</head>
<body>
<div class="signup-form">
    <form action="" method="post">
		<h3>Add Employees</h3>
        <div class="form-group">
        	<input type="tel" class="form-control" name="id" placeholder="Employee ID" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Employee Name" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="desig" placeholder="Designation" required="required">
        </div>       
        <div class="form-group">
            <input type="text" class="form-control" name="region" placeholder="Region" required="required">
        </div>     
        
		<div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form>
</div>
</body>
</html>                            