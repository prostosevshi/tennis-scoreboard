package servlet;

import dao.MatchDAO;
import dao.PlayerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Match;
import model.Player;

import java.io.IOException;

@WebServlet("/create-match")
public class CreateMatchServlet extends HttpServlet {

    private final PlayerDAO playerDAO = new PlayerDAO();
    private final MatchDAO matchDAO = new MatchDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long player1Id = Long.parseLong(request.getParameter("player1Id"));
        long player2Id = Long.parseLong(request.getParameter("player2Id"));

        if (player1Id == player2Id) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Can't play alone");
            return;
        }

        Player player1 = playerDAO.findById((int)player1Id);
        Player player2 = playerDAO.findById((int)player2Id);

        Match match = new Match();
        match.setPlayer1(player1);
        match.setPlayer2(player2);
        match.setStatus("ONGOING");

        matchDAO.save(match);

        response.sendRedirect("matches");
    }
}
