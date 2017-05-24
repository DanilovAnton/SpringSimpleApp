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
<a href="meals?action=create">
    <button class="btn">Добавить</button>
</a>

<div>
    <table>
        <thead>
        <tr>
            <th>Дата</th>
            <th>Описание</th>
            <th>Калории</th>
            <th>Обновить</th>
            <th>Удалить</th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
        <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
            <td>${fn:replace(meal.dateTime, 'T', ' ') }</td>
            <td>${ meal.description }</td>
            <td>${ meal.calories }</td>
            <td><a href="meals?action=update&id=${ meal.id }">update</a></td>
            <td><a href="meals?action=delete&id=${ meal.id }">delete</a></td>
        </tr>
        </c:forEach>
</div>
</table>
</body>
</html>
