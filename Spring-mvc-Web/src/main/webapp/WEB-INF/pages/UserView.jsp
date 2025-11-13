<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div align="center">
		<sf:form method="post" modelAttribute="form">
			<div align="center">
				<h1 style="color: gray;">Add User</h1>
				<h2 style="color: green;">${successMessage}</h2>
				<h2 style="color: red;">${successMessage}</h2>
			</div>

			<table>
				<tr>
					<th>First Name :</th>
					<td><sf:input path="firstName" placeholder="Enter First Name" /></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><sf:input path="lastName" placeholder="Enter Last Name" /></td>
				</tr>
				<tr>
					<th>Login :</th>
					<td><sf:input path="login" placeholder="Enter Login" /></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><sf:input path="password" placeholder="Enter Password" /></td>
				</tr>
				<tr>
					<th>Address :</th>
					<td><sf:input path="address" placeholder="Enter address" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" name="operation" value="save">
					<input type="submit" name="operation" value="reset">
					</td>
				</tr>
			</table>

		</sf:form>
	</div>
</body>
</html>