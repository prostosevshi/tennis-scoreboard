package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Match;
import model.MatchScoreModel;
import service.FinishedMatchesPersistenceService;
import service.MatchScoreCalculationService;
import service.OngoingMatchesService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {
    private final Map<UUID, MatchScoreModel> scores = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID uuid = UUID.fromString(request.getParameter("uuid"));
        Match match = OngoingMatchesService.getMatch(uuid);
        MatchScoreModel score = scores.computeIfAbsent(uuid, k -> new MatchScoreModel());

        request.setAttribute("match", match);
        request.setAttribute("score", score);
        request.setAttribute("uuid", uuid.toString());
        request.getRequestDispatcher("/WEB-INF/match-score.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID uuid = UUID.fromString(request.getParameter("uuid"));
        Match match = OngoingMatchesService.getMatch(uuid);
        MatchScoreModel score = scores.computeIfAbsent(uuid, k -> new MatchScoreModel());

        String winner = request.getParameter("winner");

        if ("1".equals(winner)) {
            MatchScoreCalculationService.pointWonBy(match, score, match.getPlayer1());
        } else if ("2".equals(winner)) {
            MatchScoreCalculationService.pointWonBy(match, score, match.getPlayer2());
        }

        if (score.isFinished()) {
            FinishedMatchesPersistenceService.save(match, score.getWinner());
            OngoingMatchesService.removeMatch(uuid);
            scores.remove(uuid);
        }

        response.sendRedirect("/match-score?uuid=" + uuid);
    }
}
