<!DOCTYPE html>
<html>
<head>
<title>add</title>
<script type="text/javascript">
	function popup() {
		window.alert("Details Added Successfully");
	}
</script>
</head>
<body>
<%@include file="menu.jsp" %>
	<center>
		<h2>Enter the details</h2>
	</center>
	<form action="/ProjectAllocationMVC/updateval" method="GET">
		<table>
			<tr>
				<td>Employee Id:<br /></td>
				<td><input type="text" name="empid" required></input><br /></td>
			</tr>
			<br />
			<tr>
				<td>Project Id:</td>
				<td><input type="text" name="projid" required></input></td>
			</tr>
			<tr>
				<td>Project Name:</td>
				<td><input type="text" name="projname"></input></td>
			</tr>
		</table>
		<br /> <input type="submit" name="Submit" onClick="popup()"></input>
		<input type="reset" name="reset"></input>
	</form>
</body>
</html>