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
<form action= '/HibernateSpringMvc/signupPage'>
		<button type="submit"  id="navSignup" class="form-control">New User? Signup</button><br><br>
</form>
<br/>
<label style="font-weight: bold;color: red;">${loginError}</label>


<div class="form-group form">
	<form action= '/HibernateSpringMvc/login' method="post">
		<div>
			<label>User ID:</label>
			<input type="text" id="userId" name="userId" placeholder="user name" class="form-control">
		</div>
		<br>
		<div>
			<label>Password:</label>
			<input type="password" id="password" name="password" placeholder="password" class="form-control">
		</div>
		<br/>
		<button type="submit"  id="loginButton" class="form-control">Login</button>
	</form>
</div>
</div>
</body>
</html>