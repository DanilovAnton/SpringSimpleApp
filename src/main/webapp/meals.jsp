<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Calorie Accounting</title>

</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<hr>
<div class="form">
    <form method="post" action="add">
        <br>
        <label>Дата и время: <input type="datetime-local" name="dateTime"></label>
        <br>
        <label>Описание: <input type="text" name="description" value="Описание"></label>
        <br>
        <label>Калории: <input type="number" name="calories" value="0"></label>
        <br>
        <button class="btn" type="submit">Добавить</button>
    </form>
</div>
<div>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Дата</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    </thead>
    <c:forEach items="${meals}" var="meal">
        <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
            <td>${ meal.id }</td>
            <td>${fn:replace(meal.dateTime, 'T', ' ') }</td>
            <td>${ meal.description }</td>
            <td>${ meal.calories }</td>
        </tr>
    </c:forEach>
</div>
</table>



</body>
</html>
