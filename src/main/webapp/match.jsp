<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 7/30/2025
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.MatchDAO, dao.PlayerDAO, model.Match" %>
<%
    Long id = Long.parseLong(request.getParameter("id"));
    MatchDAO dao = new MatchDAO();
    Match match = dao.findById(id);
%>
<html>
<head>
    <title>Match #<%= match.getId() %></title>
</head>
<body>
<h2>Match between <%= match.getPlayer1().getName() %> and <%= match.getPlayer2().getName() %></h2>

<p>Points: <%= match.getScore() != null ? match.getScore() : "0-0" %></p>
<p>Status: <%= match.getStatus() %></p>

<form method="post" action="match">
    <input type="hidden" name="id" value="<%= match.getId() %>" />
    <button type="submit" name="winner" value="1">Points to player 1</button>
    <button type="submit" name="winner" value="2">Points to player 2</button>
    <button type="submit" name="action" value="finish">End match</button>
</form>

<p><a href="matches">← Back to the list of matches</a></p>
</body>
</html>
