<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 7/29/2025
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add player</title>
</head>
<body>
    <h2>Add player</h2>
    <form action="add-player" method="post">
        Name: <input type="text" name="name" required>
        <button type="submit">Add</button>
    </form>
</body>
</html>
