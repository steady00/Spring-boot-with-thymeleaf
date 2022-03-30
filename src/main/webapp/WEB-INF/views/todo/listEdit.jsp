<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Todo List</title>
</head>
<body>
<h1>Edit Form</h1>
<form:form modelAttribute="todo" action="../update" method="post">
	<fieldset>
		<legend>Edit todo list</legend>
		<form:hidden path="id"/>
		<p>
			<label for="user">User: </label>
			<form:input id="user" path="user"/>
		</p>
		<p>
			<label for="description">Description: </label>
			<form:input id="description" path="description"/>
		</p>
		<p>
			<label for="targetDate">Target Date: </label>
			<form:input id="targetDate" path="targetDate"/>
		</p>
		<p>
			<label for="starMeter">Star Meter: </label>
			<form:input id="starMeter" path="starMeter"/>
		</p>
		<p>
			<input type="reset" id="reset" />
			<input type="submit" id="submit" value="Update Save"/>
		</p>
	</fieldset>
</form:form>
</body>
</html>