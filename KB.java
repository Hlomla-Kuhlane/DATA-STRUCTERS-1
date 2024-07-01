/**
 * This class represents a knowledge base entry containing a term, a sentence associated with the term, and a confidence score.
 */
public class KB {
/**This class represents a knowledge base entry containing a term, a sentence associated with the term, and a confidence score.
**/
    /** Term associated with the statement
    **/
    public String term; 
    /**Sentence associated with the term
    **/
    public String sentence; 
    /** Confidence score of the statement
    **/

    public double score;    
     /**
     * Constructs a KB object with the given term, sentence, and score.
     * @param term The term associated with the statement.
     * @param sentence The sentence associated with the term.
     * @param score The confidence score of the statement.
     */
    public KB(String term, String sentence, double score) {
        this.term = term;
        this.sentence = sentence;
        this.score = score;
    }

    /**
     * Sets the term of the KB entry.
     * @param term The term to set.
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Sets the sentence of the KB entry.
     * @param sentence The sentence to set.
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Sets the confidence score of the KB entry.
     * @param score The confidence score to set.
     */
    public void setConfidence(double score) {
        this.score = score;
    }

    /**
     * Returns a string representation of the KB entry.
     * @return A string representation of the KB entry.
     */
    public String toString() {
        return term + " " + sentence + " " + score;
    }

    /**
     * Gets the term of the KB entry.
     * @return The term of the KB entry.
     */
    public String getTerm() {
        return term;
    }

    /**
     * Gets the sentence of the KB entry.
     * @return The sentence of the KB entry.
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Gets the confidence score of the KB entry.
     * @return The confidence score of the KB entry.
     */
    public double getConfidence() {
        return score;
    }

    /**
     * Updates the statement of the KB entry with the given sentence and score if the new score is higher.
     * @param sentence The new sentence to update.
     * @param score The new confidence score to update.
     */
    public void updateStatement(String sentence, double score) {
    // Validate input parameters
    if (sentence == null || sentence.isEmpty()) {
        System.out.println("Sentence cannot be null or empty.");
    }
    if (score < 0 || score > 1.0) {
       System.out.println("Score must be between 0 and 1 (inclusive).");
    }
    else {
    
    // Update statement if score is higher
    if (score > this.score) {
        this.sentence = sentence;
        this.score = score;
        System.out.println("Statement for term " + term + " has been updated.");
    } 
    else {
        System.out.println("New statement has lower confidence score, not updating.");
    }
    }
}   
   /**
     * Displays the statement associated with the KB entry along with its confidence score.
     */
    public void displayStatement() {
        System.out.println("Statement found: " + sentence + " (Confidence score: " + score + ")");
    }

    /**
     * Checks if the given term and sentence match the term and sentence of the KB entry.
     * @param term The term to match.
     * @param sentence The sentence to match.
     * @return True if the term and sentence match, otherwise false.
     */
    public boolean matches(String term, String sentence) {
        return this.term.equals(term) && this.sentence.equals(sentence);
    }
}
