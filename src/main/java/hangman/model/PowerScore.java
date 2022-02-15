package hangman.model;

public class PowerScore implements  GameScore {

    /**
     * Original schema
     * @pre initial score 0 points
     * @pos score wont be higher than 500 and minor than 0
     * @param correctCount positive int that means the numbers of correct letters in the word
     * @param incorrectCount negative int that means the numbers of incorrect letters in the word
     * @throws RuntimeException when the score is negative
     * @return int that means the final score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        //initial score
        int score = 0;
        //bonification with 5^i i is the number of the letter
        for(int i = 1; i <= correctCount; i++){
            score += Math.pow(5, i);
        }
        //penalizes with 10 points per incorrect letters
        score -= incorrectCount * 8;
        //min score is 0
        if (score < 0){
            throw new RuntimeException("min score allowed is 0");
        } else if(score > 500) {
            score = 500;
        }
        return score;
    }
}
