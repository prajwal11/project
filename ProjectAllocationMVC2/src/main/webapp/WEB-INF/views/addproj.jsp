<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>ADD PROJECT</title>
<script type="text/javascript">
	function popup() {
		window.alert("Details Added Successfully");
	}
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h2>Enter Project Details:</h2>
	<form:form action="/ProjectAllocationMVC/addprojval" method="GET"
		commandName="projdetails">
		<table>
			<tr>
				<td>Project Id:</td>
				<td><form:input type="text" path="projectId" /></td>
				<td><form:errors path="projectId" cssClass="errorblock" /></td>
			</tr>
			<tr>
				<td>Project Name:</td>
				<td><form:input type="text" path="projectName" /></td>
				<td><form:errors path="projectName" cssClass="errorblock" /></td>
			</tr>
		</table>
		<h4>${message}</h4>
		<input type="submit" name="Submit"></input>
		<input type="reset" name="reset"></input>
	</form:form>
</body>
</html>