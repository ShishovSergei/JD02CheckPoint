<%@ page import="by.itacademy.FilmTitleServlet" %><%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 19.01.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
  /**/
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Omg, it works</title>
</head>
<body>
<%= request.getAttribute("filmtitle") %>
</body>
</html>
