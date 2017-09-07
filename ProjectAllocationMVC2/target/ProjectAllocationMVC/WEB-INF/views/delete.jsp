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
			<td>Employee Id:<br /></td>
			<form action="/ProjectAllocationMVC/deleteval" method="GET">
				<td><input type="text" name="empid"></input><br /></td>
		</tr>
		<tr>
			<td>Project Id:<br /></td>
			<td><input type="text" name="projid"></input><br /></td>
		</tr>
	</table>
	<br />
	<input type="submit" name="Submit"></input>
	<input type="reset" name="reset"></input>
	</form>
</body>
</html>