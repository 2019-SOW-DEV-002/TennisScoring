package com.kata.tennis;

import com.kata.tennis.domain.Player;

public class TennisScoring {
    private Player player1;
    private Player player2;

    public TennisScoring(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public int getPlayer1Score() {
        return player1.getPoint();
    }

    public int getPlayer1GameScore() {
        return player1.getGamesWon();
    }

    public void addPoint(String player) {
        if(player1.getName().equalsIgnoreCase(player)) {
            addPointForPlayer1();
        } else if (player2.getName().equalsIgnoreCase(player)) {
            addPointForPlayer2();
        }
    }

    private void addPointForPlayer1() {
        player1.setPoint(player1.getPoint()+1);
    }

    private void addPointForPlayer2() {
        player2.setPoint(player2.getPoint()+1);
    }
}
