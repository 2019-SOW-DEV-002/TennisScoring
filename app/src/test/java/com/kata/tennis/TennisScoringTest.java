package com.kata.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisScoringTest {

    private final String player1 = "Player1";
    private final String player2 = "Player2";
    private TennisScoring tennisScoring;

    //possible outcomes
    private final String FIFTEEN_LOVE = "1, 0";
    private final String LOVE_FIFTEEN = "0, 1";

    @Before
    public void setUp() {
        tennisScoring = new TennisScoring(player1, player2);
    }

    @Test
    public void shouldAddScoreForPlayer1_When_Player1ScoresPoint() {

        tennisScoring.addPoint(player1);

        assertEquals(FIFTEEN_LOVE, tennisScoring.getScore());
    }

    @Test
    public void shouldAddScoreForPlayer2_When_Player2ScoresPoint() {

        tennisScoring.addPoint(player2);

        assertEquals(LOVE_FIFTEEN, tennisScoring.getScore());
    }

    @Test
    public void shouldAdd1GameForPlayer1_When_Player1Scores4Point() {

        tennisScoring.addPoint(player1);
        tennisScoring.addPoint(player1);
        tennisScoring.addPoint(player1);
        tennisScoring.addPoint(player1);

        assertEquals(0, tennisScoring.getPlayer1Score());
        assertEquals(1, tennisScoring.getPlayer1GameScore());
    }

    @Test
    public void shouldNotAddPointForPlayer1_When_Player2ScoresPoint() {

        tennisScoring.addPoint(player2);

        assertEquals(0, tennisScoring.getPlayer1Score());
    }


}