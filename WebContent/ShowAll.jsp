<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Users</title>
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
			<c:forEach items="${requestScope.users}" var="user">
				<tr>
					<td>${user.fname}</td>
					<td>${user.lname}</td>
					<td>${user.age}</td>
					<td>${user.email}</td>
					<td>${user.city}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>