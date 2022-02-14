package hangman.model;

public interface GameScore{
    /**
     * @param correctCount
     * @param incorrectCount
     * @throws
     * @return
     */
    public int calculateScore(int correctCount, int incorrectCount);
}
