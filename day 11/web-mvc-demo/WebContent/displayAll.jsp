<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.hsbc.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>All the Users</h3>
	${listKey}
	<h3>We are using JSTL</h3><hr />
	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
	<ol>
		<core:forEach items="${listKey}" var="u">
			<li>Id = ${u.userId}, Name = ${u.name}, Phone = ${u.phone}</li>
		</core:forEach>
	</ol>
	<hr>
	<table border="1px solid black";">
	<tr>
		<th>User Id</th>
		<th>Name</th>
		<th>Phone Nunber</th>
	</tr>
      <% 
      List<User> userList = (List<User>)session.getAttribute("listKey");
      
      for(User user : userList){
    	  
    	  out.println("<tr><td>"+user.getUserId()+"</td><td>"+user.getUsername()+"</td><td>"+user.getPhone()+"</td></tr>");
      }
    	  
    	%>
    	</table><br>
</body>
</html>