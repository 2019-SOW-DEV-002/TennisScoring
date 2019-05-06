package com.kata.tennis;

import com.kata.tennis.domain.Player;

public class TennisScoring {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Advantage ";
    public static final String WINS = " wins";

    private Player player1;
    private Player player2;

    public TennisScoring(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void addPoint(String player) {
        int player1Point = player1.getPoint();
        int player2Point = player2.getPoint();

        if(player1.getName().equalsIgnoreCase(player)) {
            addPointForPlayer1(player1Point + 1);
        } else if (player2.getName().equalsIgnoreCase(player)) {
            addPointForPlayer2(player2Point + 1);
        }
    }

    public String getScore() {
        int pointsPlayer1 = player1.getPoint();
        int pointsPlayer2 = player2.getPoint();
        int pointDiff = pointsPlayer1 - pointsPlayer2;

        if(isBothPlayersPast2points()) {

            if (Math.abs(pointDiff) == 1) {
                if (pointDiff == 1) {
                    return ADVANTAGE + player1.getName();
                } else {
                    return ADVANTAGE + player2.getName();
                }
            } else if (pointDiff == 0) {
                return DEUCE;
            } else {
                if(pointsPlayer1 > pointsPlayer2) {
                    return player1.getName() + WINS;
                } else {
                    return player2.getName() + WINS;
                }
            }
        } else {
            if (pointsPlayer1 == 4) {
                return player1.getName() + WINS;
            } else if (pointsPlayer2 == 4) {
                return player2.getName() + WINS;
            } else {
                return getPlayer1Score() + ", " + getPlayer2Score();
            }
        }
    }

    private boolean isBothPlayersPast2points() {
        return player1.getPoint() > 2 && player2.getPoint() > 2;
    }

    private void addPointForPlayer1(int point) {
        player1.setPoint(point);
    }

    private void addPointForPlayer2(int point) {
        player2.setPoint(point);
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
            default:
                return LOVE;
        }
    }
}
