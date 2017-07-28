<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<div class="container">
${loginError}

<div class="form-group form">
	<form action= '/SpringLoginForm/signUp' method="post">
		<div>
			<lable>User Name:</lable>
			<input type="text" id="userId" name="userId" placeholder="user name" class="form-control">
		</div>
		<br>
		<div>
			<lable>Password:</lable>
			<input type="password" id="password" name="password" placeholder="password" class="form-control">
		</div>
		<div>
			<lable>Email:</lable>
			<input type="text" id="email" name="email" placeholder="Email" class="form-control">
		</div>
		<br>
		<div>
			<lable>Phone:</lable>
			<input type="phone" id="phone" name="phone" placeholder="phone" class="form-control">
		</div>
		<div>
			<lable>City:</lable>
			<input type="city" id="city" name="city" placeholder="city" class="form-control">
		</div>
		<button type="submit"  id="signUpButton" class="form-control">SignUp</button>
	</form>
</div>
</div>
</body>
</html>