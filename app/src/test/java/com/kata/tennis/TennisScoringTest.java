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
import static com.kata.tennis.TennisScoring.FORTY;
import static com.kata.tennis.TennisScoring.LOVE;
import static com.kata.tennis.TennisScoring.THIRTY;
import static com.kata.tennis.TennisScoring.WINS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class TennisScoringTest {

    private final String namePlayer1 = "Player1";
    private final String namePlayer2 = "Player2";
    private TennisScoring tennisScoring;

    @Before
    public void setUp() {
        tennisScoring = new TennisScoring(namePlayer1, namePlayer2);
    }

    @Test
    @Parameters(method = "tennisScoreScenarios")
    public void testTennisScoring(int pointsPlayer1, int pointsPlayer2, String expectedScore) {
        assertNotNull(tennisScoreScenarios()); //for lint error; as method is used via reflection
        stubScore(pointsPlayer1, pointsPlayer2);

        assertEquals(expectedScore, tennisScoring.getScore());
    }
    private Object tennisScoreScenarios() {
        String SPACE = " ";
        return new Object[] {
                new Object[]{0, 0, LOVE + ALL},
                new Object[]{0, 1, LOVE + SPACE + FIFTEEN},
                new Object[]{0, 2, LOVE + SPACE + THIRTY},
                new Object[]{0, 3, LOVE + SPACE + FORTY},
                new Object[]{0, 4, namePlayer2 + WINS},

                new Object[]{1, 0, FIFTEEN + SPACE + LOVE},
                new Object[]{1, 1, FIFTEEN + ALL},
                new Object[]{1, 2, FIFTEEN + SPACE + THIRTY},
                new Object[]{1, 3, FIFTEEN + SPACE + FORTY},
                new Object[]{1, 4, namePlayer2 + WINS},

                new Object[]{2, 0, THIRTY + SPACE + LOVE},
                new Object[]{2, 1, THIRTY + SPACE + FIFTEEN},
                new Object[]{2, 2, THIRTY + ALL},
                new Object[]{2, 3, THIRTY + SPACE + FORTY},
                new Object[]{2, 4, namePlayer2 + WINS},

                new Object[]{3, 0, FORTY + SPACE + LOVE},
                new Object[]{3, 1, FORTY + SPACE + FIFTEEN},
                new Object[]{3, 2, FORTY + SPACE + THIRTY},
                new Object[]{3, 3, DEUCE},
                new Object[]{3, 4, ADVANTAGE + namePlayer2},
                new Object[]{3, 5, namePlayer2 + WINS},

                new Object[]{4, 0, namePlayer1 + WINS},
                new Object[]{4, 1, namePlayer1 + WINS},
                new Object[]{4, 2, namePlayer1 + WINS},
                new Object[]{4, 3, ADVANTAGE + namePlayer1},
                new Object[]{4, 4, DEUCE},
                new Object[]{4, 5, ADVANTAGE + namePlayer2},
                new Object[]{4, 6, namePlayer2 + WINS},

                new Object[]{5, 3, namePlayer1 + WINS},
                new Object[]{5, 4, ADVANTAGE + namePlayer1},
                new Object[]{5, 5, DEUCE},
                new Object[]{5, 6, ADVANTAGE + namePlayer2},
                new Object[]{5, 7, namePlayer2 + WINS},

                new Object[]{6, 4, namePlayer1 + WINS},
                new Object[]{6, 5, ADVANTAGE + namePlayer1},
                new Object[]{6, 6, DEUCE},
                new Object[]{6, 7, ADVANTAGE + namePlayer2},
                new Object[]{6, 8, namePlayer2 + WINS},
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