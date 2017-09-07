<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>add</title>
<script type="text/javascript">
	function popup() {
		window.alert("Details Added Successfully");
	}
</script>
<script type="text/javascript">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".selection").click(function() {
			$("#customPerc").toggle();
			console.log("Custom value : " + $("#allocpercCustom").val())
		})
	});
</script>
</head>
<body>
<%@include file="menu.jsp" %>
		<h2>Enter the details</h2>
	<form:form action="/ProjectAllocationMVC/addval" method="GET"
		modelAttribute="allocForm">
		<table>
			<tr>
				<td>Employee Id:<br /></td>
				<td><form:select path="empId">
						<form:option value="0" label="Select" />
						<form:options items="${emplist}" itemValue="employeeId"
							itemLabel="employeeName" />
					</form:select><br /></td>
			</tr>
			<br />
			<tr>
				<td>Project Id:</td>
				<td><form:select path="projId">
						<form:option value="0" label="Select" />
						<form:options items="${projlist}" itemValue="projectId"
							itemLabel="projectName" />
					</form:select></td>
			</tr>
		</table>
		<br />
		<form:radiobutton path="fullworkload" value="100"
			 label = "Full Time" checked="checked"/> 
			<form:radiobutton path="fullworkload" value="0"
			class="selection" label = "Custom" /><br />
		<br />
		<div style="display: none" id="customPerc">
			<form:input path = "customworkload" type="number" id="allocpercCustom"
				 placeholder="e.g. 50"/>
		</div>
		<br>
		<input type="submit" name="Submit" onClick="popup()"></input>
		<input type="reset" name="reset"></input>
	</form:form>
</body>
</html>