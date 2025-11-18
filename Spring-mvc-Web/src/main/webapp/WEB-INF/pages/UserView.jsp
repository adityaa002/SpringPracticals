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

				<c:if test="${form.id > 0}">
					<h1 style="color: gray;">Update User</h1>
				</c:if>

				<c:if test="${form.id ==0}">
					<h1 style="color: gray;">Add User</h1>
				</c:if>

				<h2 style="color: green;">${successMessage}</h2>
				<h2 style="color: red;">${errorMessage}</h2>
			</div>

			<table>
				<tr>
					<th>First Name :</th>
					<td><sf:input path="firstName" placeholder="Enter First Name" /></td>
					<td style="color: red"><sf:errors path="firstName" /></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><sf:input path="lastName" placeholder="Enter Last Name" /></td>
					<td style="color: red"><sf:errors path="lastName" /></td>
				</tr>
				<tr>
					<th>Login :</th>
					<td><sf:input path="login" placeholder="Enter Login" /></td>
					<td style="color: red"><sf:errors path="login" /></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><sf:input path="password" placeholder="Enter Password" /></td>
					<td style="color: red"><sf:errors path="password" /></td>
				</tr>
				<tr>
					<th>Address :</th>
					<td><sf:input path="address" placeholder="Enter address" /></td>
					<td style="color: red"><sf:errors path="address" /></td>
				</tr>

				<tr>
					<c:if test="${form.id == null || form.id == 0}">
						<td><input type="submit" name="operation" value="save">
							<input type="submit" name="operation" value="reset"></td>
					</c:if>


					<c:if test="${form.id > 0 }">
						<td></td>

						<td><input type="submit" name="operation" value="update"></td>
						<td><input type="submit" name="operation" value="cancel"></td>
					</c:if>

				</tr>
			</table>

		</sf:form>
	</div>
</body>
</html>