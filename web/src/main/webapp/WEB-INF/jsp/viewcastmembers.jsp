<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>castmembers</title>
</head>
<body>
<table>
    <tr>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Пол</td>
        <td>День рождения</td>
    </tr>
    <c:forEach var="castmember" items="${requestScope.castmembers}" >
        <tr>
            <td>${castmember.name}</td>
            <td>${castmember.surname}</td>
            <td>${castmember.gender}</td>
            <td>${castmember.birthday}</td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr><p>
        <c:forEach begin="1" end="${requestScope.pages}" varStatus="loop">
            <a href="${pageContext.request.contextPath}/viewcastmembers?page=${loop.index}">${loop.index}</a>
        </c:forEach></p>
        <td></td>
    </tr>
</table>

</body>
</html>
