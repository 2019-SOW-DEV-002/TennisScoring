package com.kata.tennis.domain;

public class Player {
    private String name;
    private int point;
    private int gamesWon;

    public Player(String name) {
        this.name = name;
        this.point = 0;
        this.gamesWon = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
        if(this.point > 3) {
            this.point = 0;
            this.gamesWon++;
        }
    }

    public int getGamesWon() {
        return gamesWon;
    }
}
