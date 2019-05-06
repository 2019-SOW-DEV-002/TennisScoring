package com.kata.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisScoringTest {

    private TennisScoring tennisScoring;

    @Before
    public void setUp() {
        tennisScoring = new TennisScoring("Player1");
    }

    @Test
    public void shouldAddScoreForPlayer1_When_Player1Scores1Point() {

        tennisScoring.addPointForPlayer1();

        assertEquals(1, tennisScoring.getPlayer1Score());
    }

    @Test
    public void shouldAdd1GameForPlayer1_When_Player1Scores4Point() {

        tennisScoring.addPointForPlayer1();
        tennisScoring.addPointForPlayer1();
        tennisScoring.addPointForPlayer1();
        tennisScoring.addPointForPlayer1();

        assertEquals(0, tennisScoring.getPlayer1Score());
        assertEquals(1, tennisScoring.getPlayer1GameScore());
    }
}