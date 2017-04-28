<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Login</title>
</head>
<body>

    <p><font color="red">${errorMessage}</font></p>
    <form action="/SpringMvcJdbcTemplate/home${user}" method="POST">
        Username : <input name="username" type="text" /> 
        Password : <input name="password" type="password" /> 
        <input type="submit" value="Login"/>
    </form>
</body>
</html>