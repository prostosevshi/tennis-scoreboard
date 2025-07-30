package servlet;

import dao.PlayerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Player;

import java.io.IOException;
import java.util.List;

@WebServlet("/players")
public class PlayerServlet extends HttpServlet {
    private final PlayerDAO playerDAO = new PlayerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Player> players = playerDAO.findAll();
        request.setAttribute("players", players);
        request.getRequestDispatcher("/WEB-INF/players.jsp").forward(request, response);
    }
}
