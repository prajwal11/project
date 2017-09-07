<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>searchview</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<c:if test="${not empty Employee }">
		<h2>The Project Allocation Details of the Requested Employee</h2>
		<br />
		<table border="1">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Project Id</th>
				<th>Project Name</th>
				<th>Project Workload</th>
				<th>Total Workload Percentage</th>
			</tr>
			<c:forEach items="${Employee }" var="Employee">
				<tr>
					<td>${Employee.employee.employeeId}</td>
					<td>${Employee.employee.employeeName}</td>
					<td>${Employee.project.projectId }</td>
					<td>${Employee.project.projectName }</td>
					<td>${Employee.workload }</td>
					<td>${Employee.employee.workload }</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	<c:if test="${empty Employee }">
		<h3>Search Not Found</h3>
	</c:if>

	<br />
	<br />
	<br />

</body>
</html>