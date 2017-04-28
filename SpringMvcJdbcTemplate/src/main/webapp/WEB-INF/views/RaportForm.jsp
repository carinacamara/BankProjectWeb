<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Find Report</title>
</head>
<body>
<div align="center">
	<h1>New Report</h1>
    <form:form action="/SpringMvcJdbcTemplate/listRaport" method="POST">
    
    <table>
    <tr>
     <td>  Start Date (YYYY-MM-DD):
       <input name="creationDateOne" type="text" /><form:errors path="creationDateOne" ></form:errors>
       </td>
       </tr>
     
     <tr>
     <td>  
        End Date (YYYY-MM-DD): 
        <input name="creationDateTwo" type="text" /> <form:errors path="creationDateTwo" ></form:errors>
       </td>
       </tr>  
       
       <tr>
     <td>  
        Employee's ID : 
        <input name="idEmployee" type="text" /> <form:errors path="idEmployee" ></form:errors>
        
          </td>
       </tr> 
         <tr>
     <td> 
        <input type="submit" value="Find"/>
         </td>
       </tr> 
        
         </table>
    </form:form>
    
    
    
     <form action="/SpringMvcJdbcTemplate/home">
        <input type="submit" value="Logout"/>
    </form>
    </div>
</body>
</html>