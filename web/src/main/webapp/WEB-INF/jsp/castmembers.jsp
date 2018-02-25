<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 14.02.2018
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-chained/1.0.1/jquery.chained.min.js"></script>
</head>
<body>
<div>
    <form  name="test" method="post" action="${pageContext.request.contextPath}/selectcastmembers" >
       <b>Имя</b>
            <select id="name" name="name" required>
                <option value="brad">Brad</option>
                <option value="andrew">Andrew</option>
            </select>
        <b>Фамилия</b>
            <select id="surname" name="surname" required>
                <option value="pitt" class="brad">Pitt</option>
                <option value="mcdonald" class="andrew">Mcdonald</option>
            </select>

        <b>Пол:</b>
        <select name="gender" required>
            <option value="man">МУЖСКОЙ</option>
            <option value="woman">ЖЕНСКИЙ</option>
        </select>

        <p>Отображать на странице:</p>
        <select name="limit" required>
            <option value="2">2</option>
            <option value="4">4</option>
        </select>
        </p>
        <p><input type="submit" value="Отправить">
            <input type="reset" value="Очистить"></p>
    </form>
</div>
</body>
</html>
