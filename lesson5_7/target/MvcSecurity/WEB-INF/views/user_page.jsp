<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>PC GAMES Catalogue</title>
</head>
<body>
<h3>PC Games Catalogue</h3>
<br>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Publisher</th>
    </tr>
<c:forEach var="pcgame" items="${pcgames}">
    <tr>
        <td>${pcgame.id}</td>
        <td>${pcgame.title}</td>
        <td>${pcgame.genre}</td>
        <td>${pcgame.publisher}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
