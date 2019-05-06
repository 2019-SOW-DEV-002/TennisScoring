package com.kata.tennis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static com.kata.tennis.TennisScoring.ADVANTAGE;
import static com.kata.tennis.TennisScoring.ALL;
import static com.kata.tennis.TennisScoring.DEUCE;
import static com.kata.tennis.TennisScoring.FIFTEEN;
import static com.kata.tennis.TennisScoring.LOVE;
import static com.kata.tennis.TennisScoring.WINS;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TennisScoringTest {

    private final String namePlayer1 = "Player1";
    private final String namePlayer2 = "Player2";
    private TennisScoring tennisScoring;

    //possible outcomes
    private final String SPACE = " ";
    private final String LOVE_ALL = LOVE + ALL;
    private final String LOVE_FIFTEEN = LOVE + SPACE + FIFTEEN;
    private final String FIFTEEN_LOVE = FIFTEEN + SPACE + LOVE;
    private final String PLAYER_1_WIN = namePlayer1 + WINS;
    private final String PLAYER_2_WIN = namePlayer2 + WINS;
    private final String PLAYER_1_ADVANTAGE = ADVANTAGE + namePlayer1;
    private final String PLAYER_2_ADVANTAGE = ADVANTAGE + namePlayer2;
    private final String FIFTEEN_ALL = FIFTEEN + ALL;

    @Before
    public void setUp() {
        tennisScoring = new TennisScoring(namePlayer1, namePlayer2);
    }

    @Test
    public void shouldSetScoreAsLoveAll_At_Start() {

        assertEquals(LOVE_ALL, tennisScoring.getScore());
    }

    @Test
    public void shouldAddScoreForPlayer1_When_Player1ScoresPoint() {

       stubScore(1, 0);

        assertEquals(FIFTEEN_LOVE, tennisScoring.getScore());
    }

    @Test
    public void shouldAddScoreForPlayer2_When_Player2ScoresPoint() {

        stubScore(0, 1);

        assertEquals(LOVE_FIFTEEN, tennisScoring.getScore());
    }

    @Test
    public void player1WinsGame_When_Player1Scores4Points() {

        stubScore(4, 0);

        assertEquals(PLAYER_1_WIN, tennisScoring.getScore());
    }

    @Test
    public void player2WinsGame_When_Player2Scores4Points() {

        stubScore(0, 4);

        assertEquals(PLAYER_2_WIN, tennisScoring.getScore());
    }

    @Test
    public void shouldSetScoreAsDeuce_When_BothPlayerHave3Points() {

        stubScore(3, 3);

        assertEquals(DEUCE, tennisScoring.getScore());
    }

    @Test
    public void shouldSetScoreAsPlayer1Advantage_When_BothPlayerHave3Points_And_Player1Scores1Point() {

        stubScore(4, 3);

        assertEquals(PLAYER_1_ADVANTAGE, tennisScoring.getScore());
    }

    @Test
    public void shouldSetScoreAsPlayer2Advantage_When_BothPlayerHave3Points_And_Player2Scores1Point() {

        stubScore(3, 4);

        assertEquals(PLAYER_2_ADVANTAGE, tennisScoring.getScore());
    }

    @Test
    public void shouldSetScoreAsDeuce_When_Player1HadAdvantage_And_Player2Scores1Point() {

        stubScore(4, 4);

        assertEquals(DEUCE, tennisScoring.getScore());
    }

    @Test
    public void shouldSetPlayer1AsWinner_When_Player1HadAdvantage_And_Player1Scores1Point() {

        stubScore(5, 3);

        assertEquals(PLAYER_1_WIN, tennisScoring.getScore());
    }

    @Test
    public void shouldSetPlayer2AsWinner_When_Player2HadAdvantage_And_Player2Scores1Point() {

        stubScore(3, 5);

        assertEquals(PLAYER_2_WIN, tennisScoring.getScore());
    }

    @Test
    @Parameters(method = "tennisScoreScenarios")
    public void testTennisScoring(int pointsPlayer1, int pointsPlayer2, String expectedScore) {

        stubScore(pointsPlayer1, pointsPlayer2);

        assertEquals(expectedScore, tennisScoring.getScore());
    }
    private Object tennisScoreScenarios() {
        return new Object[] {
                new Object[]{0, 0, LOVE_ALL},
                new Object[]{0, 1, LOVE_FIFTEEN},
                new Object[]{1, 0, FIFTEEN_LOVE},
                new Object[]{1, 1, FIFTEEN_ALL}
        };
    }

    private void stubScore(int pointsPlayer1, int pointsPlayer2) {
        for (int i = 0; i < pointsPlayer1; i++) {
            tennisScoring.addPoint(namePlayer1);
        }
        for (int i = 0; i < pointsPlayer2; i++) {
            tennisScoring.addPoint(namePlayer2);
        }
    }
}