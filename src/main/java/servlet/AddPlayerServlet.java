package servlet;

import dao.PlayerDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Player;

import java.io.IOException;

@WebServlet("/add-player")
public class AddPlayerServlet extends HttpServlet {

    private final PlayerDAO playerDAO = new PlayerDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");

        if (name != null && name.isBlank()) {
            Player player = new Player();
            player.setName(name);

            try {
                playerDAO.save(player);
                response.sendRedirect("add-player.jsp");
            } catch (Exception e) {
                response.getWriter().write("Error: name is already in use");
            }
        } else {
            response.getWriter().write("Error: name must not blank");
        }
    }
}
