<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<h3>Users List</h3>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Action</th>
    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>
            <a href="${pageContext.request.contextPath }/admin_pcgame_info/${user.id }" onclick="return confirm('Are you sure?')">Delete</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
