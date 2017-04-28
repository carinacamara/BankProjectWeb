<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Transaction</title>
</head>
<body>


	<div align="center">
		<h1>New Transaction</h1>
		<form:form action="saveTransaction" method="post" modelAttribute="transaction" commandName="transaction">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Amount:</td>
				<td><form:input path="amount" /></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><form action="">
  					<input type="radio" name="type" value="Pay Bill" checked="checked"> Pay Bill<br>
  					<input type="radio" name="type" value="Transfer"> Transfer Money<br>
  					
					</form></td>
			</tr>
			<tr>
				<td>Creation Date (YYYY-MM-DD):</td>
				<td><form:input path="creationDate" readonly="true" value="${transaction.currentDate}"/></td>
			</tr>
			<tr>
				<td>Employee's ID:</td>
				<td><form:input path="idEmployee" readonly="true" value="${idStandard}"/><form:errors path="idEmployee" ></form:errors></td>
			</tr>
			<tr>
				<td>Account From:</td>
				<td><form:input path="idAccountFrom" /></td>
			</tr>
			<tr>
				<td>Account To:</td>
				<td><form:input path="idAccountTo" /></td>
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