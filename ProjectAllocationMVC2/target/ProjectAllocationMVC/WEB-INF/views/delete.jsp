<!DOCTYPE html>
<html>
<head>
<title>delete</title>
<script type="text/javascript">
	function popup() {
		window.alert("Details Deleted Successfully");
	}
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h2>Delete Page</h2>
	</center>
	<br />
	<table>
		<tr>
			<td>Employee Name:<br /></td>
			<form action="/ProjectAllocationMVC/deleteval" method="GET">
				<td><input type="text" name="employeeName"></input><br /></td>
		</tr>
		<tr>
			<td>Project Name:<br /></td>
			<td><input type="text" name="projectName"></input><br /></td>
		</tr>
	</table>
	<br />
	<h4>${employeeName}${message}${projectName}</h4>
	<input type="submit" name="Submit"></input>
	<input type="reset" name="reset"></input>
	</form>
</body>
</html>