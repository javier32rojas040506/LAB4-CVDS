package hangmanTest.model;
import hangman.model.*;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest {
    private final GameScore originalScore = new OriginalScore();
    private final GameScore bonusScore = new BonusScore();
    private final GameScore powerScore = new PowerScore();

//Original Score
    /* start score is 100 */
    //CorrectCount = 0 incorrectCount = 0, x = 100
    @Test
    public void originalScoreStartScore() {
        int score = originalScore.calculateScore(0, 0);
        Assert.assertEquals(100, score);
    }

    /* No bonus per correct letters */
    //CorrectCount = 1 incorrectCount = 0, x = 100
    @Test
    public void originalScoreNoBonus() {
        int score = originalScore.calculateScore(1, 0);
        Assert.assertEquals(100, score);
    }

    /* penalize per incorrect letter */
    //CorrectCount = 0 incorrectCount = 1, x = 90
    @Test
    public void originalScorePenalizeInorrect() {
        int score = originalScore.calculateScore(0, 1);
        Assert.assertEquals(90, score);
    }

    /* x<0 values x=-10 x=0 x=10 */
    //CorrectCount = 0 incorrectCount = 11, x = -10
    @Test
    public void originalScoreMinimumAllowed() {
        try {
            int score = originalScore.calculateScore(0, 11);
        }catch (RuntimeException e)
        {
            Assert.assertEquals("min score allowed is 0", e.getMessage());
        }
    }
    //CorrectCount = 0 incorrectCount = 10, x = 0
    @Test
    public void originalScoreMinimum0() {
        int score = originalScore.calculateScore(0, 10);
        Assert.assertEquals(0, score);
    }
    //CorrectCount = 0 incorrectCount = 90, x = 10
    @Test
    public void originalScoreMinimum10() {
        int score = originalScore.calculateScore(0, 9);
        Assert.assertEquals(10, score);
    }


// Bonus Score
    /* start score is 0 */
    //CorrectCount = 0 incorrectCount = 0, x = 0
    @Test
    public void BonusScoreStartScore() {
        int score = bonusScore.calculateScore(0, 0);
        Assert.assertEquals(0, score);
    }
    /* 10 points bonus per correct letters */
    //CorrectCount = 1 incorrectCount = 0, x = 10
    @Test
    public void BonusScoreBonus() {
        int score = bonusScore.calculateScore(1, 0);
        Assert.assertEquals(10, score);
    }
    /* Penalize with 5 points per incorrect letter */
    //CorrectCount = 2 incorrectCount = 2, x = 15
    @Test
    public void BonusScorePenalizeInorrect() {
        int score = bonusScore.calculateScore(2, 1);
        Assert.assertEquals(15, score);
    }
    /* x<=0 values  x=-5 */
    //CorrectCount = 0 incorrectCount = 1, x = -5
    @Test
    public void BonusScoreMinimumAllowed() {
        try{
            int score = bonusScore.calculateScore(0, 1);
        }catch (RuntimeException e){
            Assert.assertEquals("min score allowed is 0",e.getMessage());
        }
    }


// Power Bonus Score
/* start score is 0 */
   //CorrectCount = 0 incorrectCount = 0, x = 0
    @Test
    public void PowerScoreStartScore() {
        int score = powerScore.calculateScore(0, 0);
        Assert.assertEquals(0, score);
    }
    /* 5^i points bonus per correct letters */
    //CorrectCount = 3 incorrectCount = 0, x = 155
    @Test
    public void PowerScoreBonus() {
        int score = powerScore.calculateScore(3, 0);
        Assert.assertEquals(155, score);
    }
    /* Penalize with 8 points per incorrect letter */
    //CorrectCount = 2 incorrectCount = 1, x = 22
    @Test
    public void PowerScorePenalizeInorrect() {
        int score = powerScore.calculateScore(2, 1);
        Assert.assertEquals(22, score);
    }
    /* x<=0 values  x=-5 */
    //CorrectCount = 0 incorrectCount = 1, x = -8
    @Test
    public void PowerScoreMinimumAllowed() {
        try{
            int score = powerScore.calculateScore(0, 1);
        }catch (RuntimeException e){
            Assert.assertEquals("min score allowed is 0",e.getMessage());
        }
    }

    /* x>=500 values x=499 x=500  */
    //CorrectCount = 4 incorrectCount = 36, x = 492
    @Test
    public void PowerScoreMaximumAllowed492() {
        int score = powerScore.calculateScore(4, 36);
        Assert.assertEquals(492, score);
    }
    //CorrectCount = 4 incorrectCount = 37, x = 500
    @Test
    public void PowerScoreMaximumAllowed500() {
        int score = powerScore.calculateScore(4, 35);
        Assert.assertEquals(500, score);
    }
}
