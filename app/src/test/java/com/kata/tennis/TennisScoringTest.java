package com.kata.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisScoringTest {

    private final String player1 = "Player1";
    private final String player2 = "Player2";
    private TennisScoring tennisScoring;

    //possible outcomes
    private final String LOVE_FIFTEEN = "Love, Fifteen";
    private final String FIFTEEN_LOVE = "Fifteen, Love";
    private final String PLAYER_1_WIN = "Player1 wins";
    private final String PLAYER_2_WIN = "Player2 wins";

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
    public void player1WinsGame_When_Player1Scores4Points() {

        tennisScoring.addPoint(player1);
        tennisScoring.addPoint(player1);
        tennisScoring.addPoint(player1);
        tennisScoring.addPoint(player1);

        assertEquals(PLAYER_1_WIN, tennisScoring.getScore());
    }


}