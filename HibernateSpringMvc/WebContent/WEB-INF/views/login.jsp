  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
  src="https://code.jquery.com/jquery-3.2.1.js" type="text/javascript"></script>
<title>Login Form</title>
 <script>
$(document).ready(function(){
	
});

function makeAjaxCall(){
	console.log("make ajax");
	var formData=$("#loginForm").serialize();
	console.log(formData);
	$.ajax({
		type : "post",
		url : "/HibernateSpringMvc/login",
		data : formData,
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$(".container").html(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			$(".container").html(e);
		},
		done : function(e) {
			console.log("DONE");
			$(".container").html(e);
		}
	});
}
</script>
</head>
<body>
<div class="container">
<form action= '/HibernateSpringMvc/signupPage'>
		<button type="submit"  id="navSignup" class="form-control">New User? Signup</button><br><br>
</form>
<br/>
<label style="font-weight: bold;color: red;">${loginError}</label>


<div class="form-group form" >
	<form id="loginForm" action= '#' name="myForm" method="POST">
		<div>
			<label>User Name:</label>
			<input type="text" id="username" name="username" placeholder="user name" class="form-control">
		</div>
		<br>
		<div>
			<label>Password:</label>
			<input type="password" id="password" name="password" placeholder="password" class="form-control">
		</div>
		<br/>
		<button type="button"  id="loginButton" class="form-control" onclick="javascript:makeAjaxCall()">Login</button>
	</form>
</div>
</div>
</body>
</html>