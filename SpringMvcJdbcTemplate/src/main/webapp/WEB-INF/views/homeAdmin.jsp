<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager Home</title>
    </head>
    <body>
    
    You are logged as Admin.
    
    	<div align="center">
	        <h1>Employee List</h1>
	        <h3><a href="newEmployee">New Employee</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Username</th>
	        	<th>Password</th>
	        	<th>Email</th>
	        	<th>Action</th>
	        	
				<c:forEach var="employee" items="${listEmployee}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${employee.name}</td>
					<td>${employee.username}</td>
					<td>${employee.password}</td>
					<td>${employee.email}</td>
					<td>
						<a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteEmployee?id=${employee.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
			
			<a href="/SpringMvcJdbcTemplate/newRaport">See Transaction</a>
			
			<form action="/SpringMvcJdbcTemplate/home">
        <input type="submit" value="Logout"/>
    </form>
    
    	</div>
    </body>
</html>