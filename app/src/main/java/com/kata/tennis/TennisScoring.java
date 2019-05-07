package com.kata.tennis;

import com.kata.tennis.domain.Player;

public class TennisScoring {

    static final String ALL = " all";
    static final String LOVE = "Love";
    static final String FIFTEEN = "Fifteen";
    static final String THIRTY = "Thirty";
    static final String FORTY = "Forty";
    static final String DEUCE = "Deuce";
    static final String ADVANTAGE = "Advantage ";
    static final String WINS = " wins";

    private Player player1;
    private Player player2;

    private String currentScore;

    public TennisScoring(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.currentScore = LOVE + ALL;
    }

    public void addPoint(String player) {

        Player playerWhoScoredPoint;

        if(player1.getName().equalsIgnoreCase(player)) {
            playerWhoScoredPoint = player1;
        } else if (player2.getName().equalsIgnoreCase(player)) {
            playerWhoScoredPoint = player2;
        } else {
            throw new IllegalArgumentException("This player is not in the game");
        }

        if (noWinnerFound()) {
            playerWhoScoredPoint.addOnePoint();
        }
        this.currentScore = getLatestScore();
    }

    public String getScore() {
        return this.currentScore;
    }

    private String getLatestScore() {
        int pointsPlayer1 = player1.getPoint();
        int pointsPlayer2 = player2.getPoint();

        if(isAfterDeuce()) {
            return getScoreAfterDeuce(pointsPlayer1, pointsPlayer2);
        } else {
            return getScoreBeforeDeuce(pointsPlayer1, pointsPlayer2);
        }
    }

    private String getScoreAfterDeuce(int pointsPlayer1, int pointsPlayer2) {
        int pointDiff = pointsPlayer1 - pointsPlayer2;
        if (pointDiff == 0) {
            return DEUCE;

        } else if (Math.abs(pointDiff) == 1) {
            return ADVANTAGE + getPlayerNameWithMorePoints(pointsPlayer1, pointsPlayer2);

        } else {
            return getPlayerNameWithMorePoints(pointsPlayer1, pointsPlayer2) + WINS;
        }
    }

    private String getScoreBeforeDeuce(int pointsPlayer1, int pointsPlayer2) {
        if (pointsPlayer1 == pointsPlayer2) {
            return getPlayer1Score() + ALL;

        } else if (pointsPlayer2 > 3) {
            return player2.getName() + WINS;

        } else if (pointsPlayer1 > 3) {
            return player1.getName() + WINS;

        } else {
            return getPlayer1Score() + " " + getPlayer2Score();
        }
    }

    private String getPlayerNameWithMorePoints(int pointsPlayer1, int pointsPlayer2) {
        if(pointsPlayer1 > pointsPlayer2) {
            return player1.getName();
        } else {
            return player2.getName();
        }
    }

    private boolean isAfterDeuce() {
        return player1.getPoint() > 2 && player2.getPoint() > 2;
    }

    private boolean noWinnerFound() {
        int pointDiff = player1.getPoint() - player2.getPoint();
        if(isAfterDeuce()) {
            return Math.abs(pointDiff) < 2;
        } else {
            return player1.getPoint() <= 3 || player2.getPoint() <= 3;
        }
    }

    private String getPlayer1Score() {
        return getDisplayPointsFor(player1.getPoint());
    }

    private String getPlayer2Score() {
        return getDisplayPointsFor(player2.getPoint());
    }

    private String getDisplayPointsFor(int score) {
        switch (score) {
            case 3:
                return FORTY;
            case 2:
                return THIRTY;
            case 1:
                return FIFTEEN;
            case 0:
                return LOVE;
            default:
                throw new IllegalArgumentException("Cannot score so high");
        }
    }
}
