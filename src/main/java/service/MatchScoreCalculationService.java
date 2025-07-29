package service;

import model.Match;
import model.MatchScoreModel;
import model.Player;

public class MatchScoreCalculationService {
    public static void pointWonBy(Match match, MatchScoreModel score, Player winner) {
        if (score.isFinished()) return;

        boolean isPlayer1 = match.getPlayer1().equals(winner);
        int p1Points = score.getPointsPlayer1();
        int p2Points = score.getPointsPlayer2();

        if (!score.isTiebreak()) {
            if (isPlayer1) p1Points++;
            else p2Points++;

            if (p1Points >= 4 || p2Points >= 4) {
                if (Math.abs(p1Points - p2Points) >= 2) {
                    if (isPlayer1) score.setGamesPlayer1(score.getGamesPlayer1() + 1);
                    else score.setGamesPlayer2(score.getGamesPlayer2() + 1);
                    p1Points = 0;
                    p2Points = 0;
                }
            }
        } else {
            if (isPlayer1) p1Points++;
            else p2Points++;
            if ((p1Points >= 7 || p2Points >= 7) && Math.abs(p1Points - p2Points) >= 2) {
                if (isPlayer1) score.setGamesPlayer1(score.getGamesPlayer1() + 1);
                else score.setGamesPlayer2(score.getGamesPlayer2() + 1);
                p1Points = 0;
                p2Points = 0;
            }
        }

        score.setPointsPlayer1(p1Points);
        score.setPointsPlayer2(p2Points);

        if (!score.isTiebreak() && score.getGamesPlayer1() == 6 && score.getGamesPlayer2() == 6) {
            score.setTiebreak(true);
        }

        if (!score.isTiebreak()) {
            if (score.getGamesPlayer1() > 6 && score.getGamesPlayer1() - score.getGamesPlayer2() >= 2) {
                score.setSetsPlayer1(score.getSetsPlayer1() + 1);
                score.setGamesPlayer1(0);
                score.setGamesPlayer2(0);
            } else if (score.getGamesPlayer2() > 6 && score.getGamesPlayer2() - score.getGamesPlayer1() >= 2) {
                score.setSetsPlayer2(score.getSetsPlayer2() + 1);
                score.setGamesPlayer1(0);
                score.setGamesPlayer2(0);
            }
        } else {
            score.setTiebreak(false);
        }

        if (score.getSetsPlayer1() == 2 || score.getSetsPlayer2() == 2) {
            score.setFinished(true);
            score.setWinner(score.getSetsPlayer1() == 2 ? match.getPlayer1() : match.getPlayer2());
        }
    }
}