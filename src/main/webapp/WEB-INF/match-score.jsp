<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 7/28/2025
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Match, model.MatchScoreModel" %>
<%
    Match match = (Match) request.getAttribute("match");
    MatchScoreModel score = (MatchScoreModel) request.getAttribute("score");
    String uuid = (String) request.getAttribute("uuid");
%>
<html>
<head>
    <title>Match score</title>
</head>
<body>
<h1>Match: <%= match.getPlayer1().getName() %> vs <%= match.getPlayer2().getName() %></h1>

<table border="1">
    <tr><th></th><th>Sets</th><th>Games</th><th>Points</th></tr>
    <tr>
        <td><%= match.getPlayer1().getName() %></td>
        <td><%= score.getSetsPlayer1() %></td>
        <td><%= score.getGamesPlayer1() %></td>
        <td><%= score.getPointsPlayer1() %></td>
    </tr>
    <tr>
        <td><%= match.getPlayer2().getName() %></td>
        <td><%= score.getSetsPlayer2() %></td>
        <td><%= score.getGamesPlayer2() %></td>
        <td><%= score.getPointsPlayer2() %></td>
    </tr>
</table>

<% if (!score.isFinished()) { %>
<form method="post" action="/match-score?uuid=<%= uuid %>">
    <button type="submit" name="winner" value="1">Очко игроку 1</button>
    <button type="submit" name="winner" value="2">Очко игроку 2</button>
</form>
<% } else { %>
<h2>Winner: <%= score.getWinner().getName() %></h2>
<% } %>

</body>
</html>