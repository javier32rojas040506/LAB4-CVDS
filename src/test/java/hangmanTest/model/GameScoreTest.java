package hangmanTest.model;
import hangman.model.*;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest {
    private final GameScore originalScore = new OriginalScore();
    private final GameScore bonusScore = new BonusScore();
    private final GameScore powerScore = new PowerScore();

//Original Score
    /*
    Minimum Score
    x = 0
    */
    @Test
    public void originalScoreMinimum() {
        int score = originalScore.calculateScore(0, 11);
        Assert.assertTrue(score < 100);
    }

    /*
     0<=x<=100
     values x=0 x=100 x=101
    */

// Bonus Score
    /*
    x<0
    values x=-1
    */
    /*
    x>=0
    values x=0 x=1
    */

// Power Bonus Score
    /*
    x<0
    values x=-1
    */
    /*
    x>=0
    values x=0 x=1
    */
    /*
     x>=500
     values x=499 x=500 x=501
    */

}
