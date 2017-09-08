<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>View</title>
</head>
<body>
	<%@include file="menu.jsp"%>

	<c:if test="${empty empList }">
		<h3>No Data Available</h3>
	</c:if>
	<h2>The Employee Details</h2>

	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Total Workload Percentage</th>
		</tr>
		<c:forEach items="${employeelist }" var="Employee">
			<tr>
				<td>${Employee.employeeId}</td>
				<td>${Employee.employeeName}</td>
				<td>${Employee.workload }</td>
			</tr>
		</c:forEach>

	</table>

	<h2>The Project Details</h2>
	<table border="1">
		<tr>
			<th>Project Id</th>
			<th>Project Name</th>
		</tr>
		<c:forEach items="${projlist }" var="Project">
			<tr>
				<td>${Project.projectId}</td>
				<td>${Project.projectName}</td>
			</tr>
		</c:forEach>

	</table>
	<br />
	<br />
	<h2>The Project Allocation Details</h2>
	<c:if test="${not empty empList }">
		<table border="1">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Project Id</th>
				<th>Project Name</th>
				<th>Project Workload</th>
				<th>Total Workload Percentage</th>
			</tr>
			<c:forEach items="${empList }" var="Employee">
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

</body>
</html>