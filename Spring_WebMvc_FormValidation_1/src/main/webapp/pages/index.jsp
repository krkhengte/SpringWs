<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<h3>User Registration Form</h3>
	<form:form action="UserInfo" modelAttribute="user" method="POST">
		<table>

			<tr>
				<td>User Id</td>
				<td><form:input path="userId" /> <form:errors path="userId"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><form:input path="userName" /> <form:errors
						path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Pwd</td>
				<td><form:password path="userPassword" /> <form:errors
						path="userPassword" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="userGmail" /> <form:errors
						path="userGmail" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Age</td>
				<td><form:input path="userAge" /> <form:errors path="userAge"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>


