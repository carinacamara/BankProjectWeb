<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Manager Home</title>
    </head>
    <body>
    
        You are logged as Employee.
    
   
    	<div align="center">
	        <h1>Account List</h1>
	        <h3><a href="newAccount">New Account</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Balance</th>
	        	<th>Creation Date</th>
	        	<th>Type</th>
	        	<th>ID Costumer</th>
	        	<th>Action</th>
	        	
				<c:forEach var="account" items="${listAccount}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${account.balance}</td>
					<td>${account.creationDate}</td>
					<td>${account.type}</td>
					<td>${account.idCostumer}</td>
					<td>
						<a href="editAccount?id=${account.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteAccount?id=${account.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
			<a href="/SpringMvcJdbcTemplate/homeEmployee">See Costumers</a>
			
			<a href="/SpringMvcJdbcTemplate/newTransaction">Make Transaction</a>
			
			<form action="/SpringMvcJdbcTemplate/home">
        <input type="submit" value="Logout"/>
    </form>
    	</div>
    </body>
</html>
