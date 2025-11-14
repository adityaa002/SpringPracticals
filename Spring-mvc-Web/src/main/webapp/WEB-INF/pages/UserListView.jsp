<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<%@include file="Header.jsp"%>


	<sf:form method="post" methodParam="form">
		<div align="center">
			<h2 style="color: gray;">User List</h2>

			<table style="width: 100%" border="1">
				<tr>
					<th>Select</th>
					<th>S no.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>DOB</th>
					<th>Address</th>
				</tr>

				<c:forEach items="${list}" var="user">
					<tr>
						<td><sf:checkbox path="ids" value="${user.id}" /></td>
						<td><c:out value="${user.id }"></c:out></td>

					</tr>

				</c:forEach>

				<tr>
				</tr>
			</table>

		</div>
	</sf:form>

</body>
</html>