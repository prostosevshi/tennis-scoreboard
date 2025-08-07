package servlet;

import dao.MatchDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Match;

import java.io.IOException;

@WebServlet("/match")
public class MatchServlet extends HttpServlet {

    private final MatchDAO dao = new MatchDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/match.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Match match = dao.findById(id);

        if (request.getParameter("action") != null && request.getParameter("action").equals("finish")) {
            match.setStatus("FINISHED");
        } else {
            String winner = request.getParameter("winner");
            updateScore(match, winner);
        }

        dao.update(match);
        response.sendRedirect("match?id=" + id);
    }

    private void updateScore(Match match, String winner) {
        String[] score = (match.getScore() !=null ? match.getScore():"0-0").split("-");
        int p1 = Integer.parseInt(score[0]);
        int p2 = Integer.parseInt(score[1]);

        if ("1".equals(winner)) p1++;
        else if ("2".equals(winner)) p2++;

        match.setScore(p1 + "-" + p2);
    }
}
