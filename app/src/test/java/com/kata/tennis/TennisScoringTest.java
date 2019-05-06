package com.kata.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisScoringTest {

    @Test
    public void shouldAddScoreForPlayer1_When_Player1Scores1Point() {
        TennisScoring tennisScoring = new TennisScoring("Player1");

        tennisScoring.addPointForPlayer1();

        assertEquals(1, tennisScoring.getPlayer1Score());
    }
}