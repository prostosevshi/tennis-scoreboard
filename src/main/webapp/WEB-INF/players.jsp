<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 7/30/2025
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Player, java.util.List" %>
<%
    List<Player> players = (List<Player>) request.getAttribute("players");
%>
<html>
<head>
    <title>List of players</title>
</head>
<body>
    <h2>All players</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th></tr>
        <% for (Player p : players) { %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
        </tr>
        <% } %>
    </table>
    <a href="add-player.jsp">Add new player</a>
</body>
</html>
