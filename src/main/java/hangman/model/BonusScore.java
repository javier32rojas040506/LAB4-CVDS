package hangman.model;

public class BonusScore implements GameScore {

    /**
     * Bonus schema
     * @pre initial score 0 points
     * @param correctCount positive int that means the numbers of correct letters in the word
     * @param incorrectCount negative int that means the numbers of incorrect letters in the word
     * @throws RuntimeException when the score is negative
     * @return int that means the final score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        //initial score
        int score = 0;
        //bonification with 10 per correct letters
        score += correctCount * 10;
        //penalizes with 10 points per incorrect letters
        score -= incorrectCount * 5;
        //min score is 0
        if (score < 0){
            throw new RuntimeException("min score allowed is 0");
        }
        return score;
    }
}
