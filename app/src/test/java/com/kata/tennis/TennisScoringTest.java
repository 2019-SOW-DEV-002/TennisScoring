package com.kata.tennis;

import org.junit.Before;
import org.junit.Test;

import static com.kata.tennis.TennisScoring.ADVANTAGE;
import static com.kata.tennis.TennisScoring.DEUCE;
import static org.junit.Assert.assertEquals;

public class TennisScoringTest {

    private final String namePlayer1 = "Player1";
    private final String namePlayer2 = "Player2";
    private TennisScoring tennisScoring;

    //possible outcomes
    private final String LOVE_FIFTEEN = "Love, Fifteen";
    private final String FIFTEEN_LOVE = "Fifteen, Love";
    private final String PLAYER_1_WIN = namePlayer1 + " wins";
    private final String PLAYER_2_WIN = namePlayer2 + " wins";
    private final String PLAYER_1_ADVANTAGE = ADVANTAGE + namePlayer1;
    private final String PLAYER_2_ADVANTAGE = ADVANTAGE + namePlayer2;

    @Before
    public void setUp() {
        tennisScoring = new TennisScoring(namePlayer1, namePlayer2);
    }

    @Test
    public void shouldAddScoreForPlayer1_When_Player1ScoresPoint() {

        tennisScoring.addPoint(namePlayer1);

        assertEquals(FIFTEEN_LOVE, tennisScoring.getScore());
    }

    @Test
    public void shouldAddScoreForPlayer2_When_Player2ScoresPoint() {

        tennisScoring.addPoint(namePlayer2);

        assertEquals(LOVE_FIFTEEN, tennisScoring.getScore());
    }

    @Test
    public void player1WinsGame_When_Player1Scores4Points() {

        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer1);

        assertEquals(PLAYER_1_WIN, tennisScoring.getScore());
    }

    @Test
    public void player2WinsGame_When_Player2Scores4Points() {

        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer2);

        assertEquals(PLAYER_2_WIN, tennisScoring.getScore());
    }

    @Test
    public void shouldSetScoreAsDeuce_When_BothPlayerHave3Points() {

        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);

        assertEquals(DEUCE, tennisScoring.getScore());
    }

    @Test
    public void shouldSetScoreAsPlayer1Advantage_When_BothPlayerHave3Points_And_Player1Scores1Point() {

        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);

        assertEquals(DEUCE, tennisScoring.getScore());

        tennisScoring.addPoint(namePlayer1);
        assertEquals(PLAYER_1_ADVANTAGE, tennisScoring.getScore());
    }

    @Test
    public void shouldSetScoreAsPlayer2Advantage_When_BothPlayerHave3Points_And_Player2Scores1Point() {

        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);
        tennisScoring.addPoint(namePlayer2);
        tennisScoring.addPoint(namePlayer1);

        assertEquals(DEUCE, tennisScoring.getScore());

        tennisScoring.addPoint(namePlayer2);
        assertEquals(PLAYER_2_ADVANTAGE, tennisScoring.getScore());
    }
}