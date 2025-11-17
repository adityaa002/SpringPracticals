<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty sessionScope.user }">
		<h3>Hi ${sessionScope.user.firstName },</h3>
		<a href="<c:url value = "/ctl/User"/>">Add User</a> |
		<a href="<c:url value = "/ctl/User/search"/>">User List</a> |
		<a href="<c:url value = "/Login?operation=logout"/>">Logout</a>
	</c:if>



	<c:if test="${empty sessionScope.user }">

		<h3 style="color: gray;">Hi, Guest !</h3>
		<a href="<c:url value="/WelcomeCtl" />">Welcome</a> |
		<a href="<c:url value = "/LoginCtl"/>">Login</a>
	</c:if>

	<hr>
</body>
</html>