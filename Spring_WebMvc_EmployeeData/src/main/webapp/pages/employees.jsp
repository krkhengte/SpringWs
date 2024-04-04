<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ taglib uri="http://www.springframework.org/tags" prefix="" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>

		<thead>

			<tr>

				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Salary</th>

			</tr>


		</thead>

		<tbody>

			<c:forEach items="${employees }" var=employee>
				<tr>

					<td>${employee.empId}</td>
					<td>${employee.empName}</td>
					<td>${employee.empSalary}</td>

				</tr>
			</c:forEach>

		</tbody>


	</table>


</body>
</html>