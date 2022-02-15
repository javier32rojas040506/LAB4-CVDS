package hangman.model;

public interface GameScore{
    /**
     * @param correctCount
     * @param incorrectCount
     * @throws RuntimeException when the score is negative
     * @return int that means the final score
     */
    public int calculateScore(int correctCount, int incorrectCount);
}
