<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="product" modelAttribute="product" method="POST">

		<table>

			<tr>

				<td>Product Id</td>
				<td><form:input path="productId"/>
			</tr>

			<tr>

				<td>Product Name</td>
				<td><form:input path="productName" />
			</tr>


			<tr>

				<td>Product Price</td>
				<td><form:input path="productPrice" />
			</tr>

			<tr>

				<td><input type="submit" value="Submit" /></td>

			</tr>


		</table>



	</form:form>

</body>
</html>