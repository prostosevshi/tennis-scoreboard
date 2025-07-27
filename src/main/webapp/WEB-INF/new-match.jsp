<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 7/25/2025
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New match</title>
</head>
<body>
<h1>Create new match</h1>

<% if (request.getAttribute("error") != null) { %>
<p style="color:red"><%= request.getAttribute("error") %></p>
<% } %>

<form method="post" action="/new-match">
    <label>Player 1: <input type="text" name="player1"/></label><br/>
    <label>Player 2: <input type="text" name="player2"/></label><br/>
    <button type="submit">Begin match</button>
</form>
</body>
</html>
