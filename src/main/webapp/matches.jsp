<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 7/30/2025
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.MatchDAO, model.Match, java.util.List" %>
<%
    MatchDAO dao = new MatchDAO();
    List<Match> matches = dao.findAll();
%>
<html>
<head>
    <title>Matches</title>
</head>
<body>
<h2>Matches list</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Player 1</th>
        <th>Player 2</th>
        <th>Points</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    <% for (Match m : matches) { %>
    <tr>
        <td><%= m.getId() %></td>
        <td><%= m.getPlayer1().getName() %></td>
        <td><%= m.getPlayer2().getName() %></td>
        <td><%= m.getScore() != null ? m.getScore() : "-" %></td>
        <td><%= m.getStatus() %></td>
        <td>
            <a href="match?id=<%= m.getId() %>">Open</a>
        </td>
    </tr>
    <% } %>
</table>

<p><a href="new-match">+ New match</a></p>
<p><a href="players">← Players</a></p>
</body>
</html>
