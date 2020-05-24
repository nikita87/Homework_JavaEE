<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PC GAMES Catalogue</title>
</head>
<body>
<%@include file="../../index.jsp"%>
<br/>
<form action="/perform_login" method="post">
    Username:<br><input type="text" name="username" data-validate = "Username is required"/><br/><br/>
    Password:<br><input type="password" name="password" data-validate = "Password is required"/><br/><br/>
    <input type="submit" value="Sign in"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
