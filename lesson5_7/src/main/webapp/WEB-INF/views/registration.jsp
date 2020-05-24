<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration user</title>
</head>
<body>
<%@include file="../../index.jsp"%>
<br/>
<form:form action="/registration" modelattribute="newUser" method="post">
    Username:<br><input type="text" name="username" data-validate="Username is required"/><br/><br/>
    Password:<br><input type="password" name="password" data-validate="Password is required"/><br/><br/>
    Name:<br><input type="text" name="name" data-validate="Name is required"/><br/><br/>
    Surname:<br><input type="text" name="surname" data-validate="Surname is required"/><br/><br/>
    <input type="submit" value="Registration"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form:form>

</body>
</html>
