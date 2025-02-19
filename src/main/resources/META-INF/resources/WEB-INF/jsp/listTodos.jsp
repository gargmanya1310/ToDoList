<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>List to dos page </title>
    </head>
    <body>
    <div>Welcome ${name}</div>
    <hr>
    <h1>Your Todos </h1>
    <table class="table">
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Done</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>

            </tr>
        </thead>
        <tbody>
        <c:forEach items ="${todos}" var = "todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE </a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/css/jquery.min.js"></script>

    </body>
</html>