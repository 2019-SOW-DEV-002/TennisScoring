package com.kata.tennis.domain;

public class Player {
    private String name;
    private int point;

    public Player(String name) {
        this.name = name;
        this.point = 0;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
