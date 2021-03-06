<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Raport</title>
    </head>
    <body>
    
    You are logged as Admin.
    
    	<div align="center">
	        <h1>Transaction List</h1>
	        <table border="1">
	        	<th>No</th>
	        	<th>Amount</th>
	        	<th>Type</th>
	        	<th>Creation Date</th>
	        	<th>Employee's ID</th>
	        	<th>Account From</th>
	        	<th>Account To</th>
	        	
	        	
				<c:forEach var="transaction" items="${listRaport}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.type}</td>
					<td>${transaction.creationDate}</td>
					<td>${transaction.idEmployee}</td>
					<td>${transaction.idAccountFrom}</td>
					<td>${transaction.idAccountTo}</td>
					
							
	        	</tr>
				</c:forEach>	        	
			</table>
			
			<a href="/SpringMvcJdbcTemplate/homeAdmin">See Employees</a>
			
			<form action="/SpringMvcJdbcTemplate/home">
        <input type="submit" value="Logout"/>
    </form>
    	</div>
    </body>
</html>