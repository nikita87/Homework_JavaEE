<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ include file="../index.jsp" />--%>

<html>
<head>
    <title>User Info</title>
</head>
<body>

<%@include file="index.jsp"%>

<h1>${message}</h1>

<h3>${error}</h3>
<h3>${errors}</h3>
<c:forEach var="error" items="errors">
    <c:out value="${error}">${error}</c:out>
</c:forEach>
</body>
</html>