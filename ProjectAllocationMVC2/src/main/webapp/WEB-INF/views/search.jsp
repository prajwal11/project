<!DOCTYPE html>
<html>
<head>
<title>search</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h2>Search Page</h2>
	<br />
	<table>
		<tr>
			<td>Search Query:<br /></td>
			<form action="/ProjectAllocationMVC/searchval" method="GET">
				<td><input type="text" name="empid"></input><br /></td>
		</tr>
	</table>
	<br />
	<input type="submit" name="Submit"></input>
	<input type="reset" name="reset"></input>
	</form>
</body>
</html>