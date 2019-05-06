package com.kata.tennis;

import com.kata.tennis.domain.Player;

public class TennisScoring {
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
        if(player1.getPoint() == 4) {
            return player1.getName() + " wins";
        }
        return getPlayer1Score() + ", " + getPlayer2Score();
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
                return "Forty";
            case 2:
                return "Thirty";
            case 1:
                return "Fifteen";
            case 0:
            default:
                return "Love";
        }
    }
}
