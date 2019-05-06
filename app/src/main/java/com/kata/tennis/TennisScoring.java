package com.kata.tennis;

import com.kata.tennis.domain.Player;

public class TennisScoring {
    private Player player1;

    public TennisScoring(String player1Name) {
        this.player1 = new Player(player1Name);
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
}
