<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
  src="https://code.jquery.com/jquery-3.2.1.js" type="text/javascript"></script>

<title>SignUp Form</title>
<script>
$(document).ready(function(){
	
});

function makeSignupAjaxCall(){
	console.log("make ajax");
	var formData=$("#signupForm").serialize();
	console.log(formData);
	$.ajax({
		type : "post",
		url : "/HibernateSpringMvc/signup",
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
<br/>
<label style="font-weight: bold;color: red;">
${loginError}
</label>
<div class="form-group form">
	<form action= '/HibernateSpringMvc/signup' method="post" id="signupForm">
		<div>
			<label>User ID:</label>
			<input type="text" id="username" name="username" placeholder="user name" class="form-control">
		</div>
		<br>
		<div>
			<label>Password:</label>
			<input type="password" id="password" name="password" placeholder="password" class="form-control">
		</div>
		<div>
			<label>Email:</label>
			<input type="text" id="email" name="email" placeholder="Email" class="form-control">
		</div>
		<br>
		<div>
			<label>Phone:</label>
			<input type="phone" id="phone" name="phone" placeholder="phone" class="form-control">
		</div>
		<div>
			<label>City:</label>
			<input type="city" id="city" name="city" placeholder="city" class="form-control">
		</div>
		<button type="button" onclick="javascript:makeSignupAjaxCall()" id="signUpButton" class="form-control">SignUp</button>
	</form>
</div>
</div>
</body>
</html>