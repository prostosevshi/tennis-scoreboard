package model;

import java.io.Serializable;
import java.util.Objects;

public class MatchScoreModel implements Serializable {
    private int setsPlayer1 = 0;
    private int setsPlayer2 = 0;

    private int gamesPlayer1 = 0;
    private int gamesPlayer2 = 0;

    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;

    private boolean tiebreak = false;
    private boolean finished = false;

    private Player winner;

    public int getSetsPlayer1() {
        return setsPlayer1;
    }

    public void setSetsPlayer1(int setsPlayer1) {
        this.setsPlayer1 = setsPlayer1;
    }

    public int getSetsPlayer2() {
        return setsPlayer2;
    }

    public void setSetsPlayer2(int setsPlayer2) {
        this.setsPlayer2 = setsPlayer2;
    }

    public int getGamesPlayer1() {
        return gamesPlayer1;
    }

    public void setGamesPlayer1(int gamesPlayer1) {
        this.gamesPlayer1 = gamesPlayer1;
    }

    public int getGamesPlayer2() {
        return gamesPlayer2;
    }

    public void setGamesPlayer2(int gamesPlayer2) {
        this.gamesPlayer2 = gamesPlayer2;
    }

    public int getPointsPlayer1() {
        return pointsPlayer1;
    }

    public void setPointsPlayer1(int pointsPlayer1) {
        this.pointsPlayer1 = pointsPlayer1;
    }

    public int getPointsPlayer2() {
        return pointsPlayer2;
    }

    public void setPointsPlayer2(int pointsPlayer2) {
        this.pointsPlayer2 = pointsPlayer2;
    }

    public boolean isTiebreak() {
        return tiebreak;
    }

    public void setTiebreak(boolean tiebreak) {
        this.tiebreak = tiebreak;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatchScoreModel that = (MatchScoreModel) o;
        return setsPlayer1 == that.setsPlayer1 && setsPlayer2 == that.setsPlayer2 && gamesPlayer1 == that.gamesPlayer1 && gamesPlayer2 == that.gamesPlayer2 && pointsPlayer1 == that.pointsPlayer1 && pointsPlayer2 == that.pointsPlayer2 && tiebreak == that.tiebreak && finished == that.finished && Objects.equals(winner, that.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setsPlayer1, setsPlayer2, gamesPlayer1, gamesPlayer2, pointsPlayer1, pointsPlayer2, tiebreak, finished, winner);
    }
}
