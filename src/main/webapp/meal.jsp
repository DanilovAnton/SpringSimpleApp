<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.action == 'create'? 'Add Meal': 'Update Meal'}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2 class="title">${param.action == 'create' ? 'Добавить' : 'Обновить'}</h2>
<div class="form">
    <form method="post" action="meals">
        <input type="hidden" name="id" value="${meal.id}">
        <br>
        <label>Дата и время: <input type="datetime-local" name="dateTime" value="${meal.dateTime}"></label>
        <br><br>
        <label>Описание: <input type="text" name="description" value="${meal.description}"></label>
        <br><br>
        <label>Калории: <input type="number" name="calories" value="${meal.calories}"></label>
        <br><br>
        <button onclick="window.history.back()" class="btn">Назад</button>
        <button class="btn" type="submit">${param.action == 'create' ? 'Добавить' : 'Обновить'}</button>
    </form>
    </div>
</body>
</html>
