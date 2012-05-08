<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h2> Sign In Page</h2>
		<form action="/signIn" method="post">
			<div>
				<input name="username" type="text" class="input-medium" placeholder="Username">
			</div>
			<div>
				<input name="password" type="password" class="input-medium" placeholder="Password">
			</div>
			<div class="controls">
				<select name="role">
					<option value="default">Select a role</option>
					<option value="ADMIN">Admin</option>
					<option value="STUDENT">Student</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Sign In</button>
		</form>
	</div>
</body>
</html>