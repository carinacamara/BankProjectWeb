<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Costumer</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Costumer</h1>
		<form:form action="saveCostumer" method="post" modelAttribute="costumer" commandName="costumer">
		
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /><form:errors path="name" ></form:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /><form:errors path="email" ></form:errors></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /><form:errors path="address" ></form:errors></td>
			</tr>
			<tr>
				<td>Telephone:</td>
				<td><form:input path="telephone" /> <form:errors path="telephone" ></form:errors>
				</td> 
				
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