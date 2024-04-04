<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

		<thead>
			<tr>

				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Price</th>

			</tr>
		</thead>

		<tbody>

			<c:forEach items="${books}" var="book">

				<tr>
					<td>${book.bookId}</td>
					<td>${book.bookName}</td>
					<td>${book.bookPrice}</td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>