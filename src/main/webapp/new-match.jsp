<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 7/25/2025
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.PlayerDAO, model.Player, java.util.List" %>
<%
    PlayerDAO dao = new PlayerDAO();
    List<Player> players = dao.findAll();
%>
<html>
<head>
    <title>New match</title>
</head>
<body>
<h2>Create new match</h2>
<form action="create-match" method="post">
    <label>Player 1:</label>
    <select name="player1Id">
        <% for (Player p : players) { %>
        <option value="<%= p.getId() %>"><%= p.getName() %></option>
        <% } %>
    </select>
    <br><br>
    <label>Player 2:</label>
    <select name="player2Id">
        <% for (Player p : players) { %>
        <option value="<%= p.getId() %>"><%= p.getName() %></option>
        <% } %>
    </select>
    <br><br>
    <input type="submit" value="Начать матч">
</form>

<p><a href="players">← Back to players</a></p>
</body>
</html>
