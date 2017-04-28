<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Costumer Manager Home</title>
    </head>
    <body>
    
  You are logged as Employee.
    
    	<div align="center">
	        <h1>Costumer List</h1>
	        <h3><a href="newCostumer">New Costumer</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Email</th>
	        	<th>Address</th>
	        	<th>Telephone</th>
	        	<th>Action</th>
	        	
				<c:forEach var="costumer" items="${listCostumer}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${costumer.name}</td>
					<td>${costumer.email}</td>
					<td>${costumer.address}</td>
					<td>${costumer.telephone}</td>
					<td>
						<a href="editCostumer?id=${costumer.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteCostumer?id=${costumer.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
			
			<a href="/SpringMvcJdbcTemplate/listAccount">See Accounts</a>
			
			<a href="/SpringMvcJdbcTemplate/newTransaction">Make Transaction</a>
			
			<form action="/SpringMvcJdbcTemplate/home">
        <input type="submit" value="Logout"/>
    </form>
    	</div>
    </body>
</html>
