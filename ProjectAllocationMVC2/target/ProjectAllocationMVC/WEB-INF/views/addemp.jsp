<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>
<script type="text/javascript">
	function popup() {
		window.alert("Details Added Successfully");
	}
</script>
</head>
<body>
<%@include file="menu.jsp" %>
	<h2>Enter Employee Details :</h2>
	<form:form modelAttribute="employeedetails"  action="/ProjectAllocationMVC/addempval" method="GET" >
		<table>
			<tr>
				<td>Employee Id:<br /></td>
				<td><form:input type="text" path="employeeId" /><br /></td>
				<td><form:errors path="employeeId" cssClass = "errorblock"/></td>
			</tr>
			<tr>
				<td>Employee Name:<br /></td>
				<td><form:input type="text" path="employeeName" /></td>
				<td><form:errors path="employeeName" cssClass = "errorblock"/></td>
			</tr>
		</table>
		<br /> <input type="submit" name="Submit"></input>
		<input type="reset" name="reset"></input>
	</form:form>
</body>
</html>