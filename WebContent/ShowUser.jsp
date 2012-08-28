<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${requestScope.status eq 'success'}">
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Email</th>
			<th>City</th>
		</tr>
		<tr>
			<td>${requestScope.fname}</td>
			<td>${requestScope.lname}</td>
			<td>${requestScope.age}</td>
			<td>${requestScope.email}</td>
			<td>${requestScope.city}</td>
		</tr>
	</table>
	</c:if>
	<c:if test="${requestScope.status eq 'notfound'}">
		<h1>No Record Found!</h1>
		<a href="search.html">Back</a>
	</c:if>
</body>
</html>