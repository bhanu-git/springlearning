<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/addEmployee">
		<input type="text" name="eid"/><br/>
		<input type="text" name="ename"/><br/>
		<input type="text" name="eage"/><br/>
		<input type="submit" value="submit"/>
	</form>
	<br/><br/>
	
	<form action="getEmployee">
		<input type="text" name="eid"/>
		<input type="submit" value="display"/>
	</form>
	<br/></br>
	
	<form action="deleteEmployee">
		<input type="text" name="eid"/>
		<input type="submit" value="delete"/>
	</form>

</body>
</html>