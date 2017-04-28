<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Account</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Account</h1>
		<form:form action="saveAccount" method="post" modelAttribute="account" commandName="account">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Balance:</td>
				<td><form:input path="balance" /></td>
			</tr>
			<tr>
				<td>Date (YYYY-MM-DD):</td>
				<td><form:input path="creationDate" readonly="true" value="${account.currentDate}"/></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><form action="">
  					<input type="radio" name="type" value="credit" checked="checked"> Credit<br>
  					<input type="radio" name="type" value="debit"> Debit<br>
  					
					</form></td>
				 
			</tr>
			<tr>
				<td>Costumer's ID:</td>
				<td><form:input path="idCostumer" /></td>
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