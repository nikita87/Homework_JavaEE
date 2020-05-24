<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
    <title>PcGame Info</title>
</head>
<body>

<%--Id:<br><input id="inp" type="text"/><br/><br/>
<button id="btnDelete" type="delete">Delete pcGame</button><br/><br/>

<script>
   $('#btnDelete').click(function () {
       var pcgameid = document.getElementById('inp').value;
       $.ajax({
           method:'DELETE',
           url:'http://localhost:8080/admin_pcgame_info' + pcgameid,
           contentType:"application/json",
           dataType:'json',
           success:function(result){
               alert("record has bee deleted")
               console.log(result);
           },
           error: function (e) {
               console.log(e)
           }
       })
   });
</script>--%>

<%--@elvariable id="newPcGame" type="java"--%>
<form:form action="/admin_pcgame_info" modelAttribute="newPcGame" method="post">
    Title:<br><input type="text" name="title" data-validate="Title is required"/><br/><br/>
    Genre:<br><input type="text" name="genre" data-validate="Genre is required"/><br/><br/>
    Publisher:<br><input type="text" name="publisher" data-validate="Publisher is required"/><br/><br/>
    <input type="submit" value="Add pcGame">
</form:form>

<h3>PC Game List</h3>
<table border="1" cellpadding="2" cellspacing="2">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Publisher</th>
        <th>Action</th>
    </tr>
<c:forEach var="pcgame" items="${pcgames}">
        <tr>
            <td>${pcgame.id}</td>
            <td>${pcgame.title}</td>
            <td>${pcgame.genre}</td>
            <td>${pcgame.publisher}</td>
            <td>
                <a href="${pageContext.request.contextPath }/admin_pcgame_info/${pcgame.id }" onclick="return confirm('Are you sure?')">Delete</a>
            </td>

        </tr>
</c:forEach>
</table>
</body>
</html>