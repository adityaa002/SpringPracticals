<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<%@include file="Header.jsp"%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h2 style="color: gray;">Login Page</h2>
			<h3 style="color: green;">${successMessage}</h3>

			<table>
				<tr>
					<th>Login Id :</th>
					<td><sf:input path="login" placeholder="enter login id" /></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><sf:input path="password" placeholder="enter password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation" value="signIn">
						<input type="submit" name="operation" value="signUp"></td>
				</tr>
			</table>
		</div>
	</sf:form>
</body>
</html>