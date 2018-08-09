<%@ page import="by.itacademy.old.FilmServlet" %><%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 19.01.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
  /**/
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Omg, it works</title>
</head>
<body>
${requestScope.film}
<form action="" method="post">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="inputState">Name</label>
            <select id="inputState" class="form-control" name ="name">
                <option selected>Brad</option>
                <option>Matthew</option>
                <option>Alex</option>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label for="inputState">Surname</label>
            <select id="inputState2" class="form-control" name ="surname">
                <option selected>Pitt</option>
                <option>Andrews</option>
                <option>Miles</option>
            </select>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Отправить</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td>Larry</td>
        <td>the Bird</td>
        <td>@twitter</td>
    </tr>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>
</body>
</html>

