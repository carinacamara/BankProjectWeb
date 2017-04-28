<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Employee</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Employee</h1>
		<form:form action="saveEmployee" method="post" modelAttribute="employee" commandName="employee">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /><form:errors path="name" ></form:errors></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><form:input path="username" /><form:errors path="username" ></form:errors></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" type="password"/><form:errors path="password" ></form:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /><form:errors path="email" ></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
		
		<form action="/SpringMvcJdbcTemplate/home">
        <input type="submit" value="Logout"/>
    </form>
	</div>
</body>
</html>