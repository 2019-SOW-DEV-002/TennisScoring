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

    public void addPointForPlayer1() {
        player1.setPoint(player1.getPoint()+1);
    }

    public int getPlayer1GameScore() {
        return player1.getGamesWon();
    }

    public void addPointForPlayer2() {
        player2.setPoint(player2.getPoint()+1);
    }
}
