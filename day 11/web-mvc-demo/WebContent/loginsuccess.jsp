<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to Login Success Page</h3>
	<p>Id: ${userKey.userId}, Name : ${userKey.name}, Phone: ${userKey.phone}</p>
	<hr>
	<a href = "createuser.html">Create User</a>
	<a href = "updatephone.html">Update Phone Number</a>
	<a href = "updatepassword.html">Update Password</a>
</body>
</html>