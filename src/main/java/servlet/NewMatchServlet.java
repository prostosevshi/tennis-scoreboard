package servlet;

import jakarta.servlet.annotation.WebServlet;
import model.Match;
import model.Player;
import service.OngoingMatchesService;
import service.PlayerService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    private final PlayerService playerService = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/new-match.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name1 = request.getParameter("player1");
        String name2 = request.getParameter("player2");

        if(name1 == null || name2 == null || name1.equalsIgnoreCase(name2)) {
            request.setAttribute("error", "Invalid player name entered");
            request.getRequestDispatcher("/WEB-INF/new-match.jsp").forward(request, response);
            return;
        }

        Player player1 = playerService.findOrCreatePlayer(name1);
        Player player2 = playerService.findOrCreatePlayer(name2);

        Match match = new Match();
        match.setPlayer1(player1);
        match.setPlayer2(player2);

        UUID uuid = OngoingMatchesService.createMatch(match);
        response.sendRedirect("/match-score?uuid=" + uuid);
    }
}
