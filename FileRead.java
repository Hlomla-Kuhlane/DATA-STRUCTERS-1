
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The FileRead class is responsible for reading a knowledge base from a file,
 * adding or updating statements in the knowledge base, and searching for
 * statements based on term and sentence.
 */


public class FileRead {
    
    /** Instance store maximum size of the knowledge base,array to store KB objects (statements)and size of the knowledge base array
    **/

    private static final int arrsize = 1000000; // Maximum size of the knowledge base
    private KB[] array; // Array to store KB objects (statements)
    private int size; // Current size of the knowledge base array

    /**
     * Constructs a FileRead object with an empty knowledge base array.
     * Initializes the array with a fixed size.
     */
    public FileRead() {
        array = new KB[arrsize]; // Initialize the knowledge base array
        size = 0; // Set the initial size of the knowledge base to zero
    }

    /**
     * Reads the contents of a file and populates the knowledge base array
     * with statements extracted from the file.
     *
     * @param fileName the name of the file to be read
     */
    public void readFile(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            // Read lines from the file until there are no more lines
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t"); // Split the line by tabs
                // Check if the line has three parts (term, sentence, score)
                if (parts.length == 3) {
                    String term = parts[0];
                    String sentence = parts[1];
                    double score = Double.parseDouble(parts[2]);
                    // Add or update the statement in the knowledge base
                    addOrUpdateStatement(term, sentence, score);
                }
            }
            System.out.println("Knowledge base loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Error while parsing score.");
        }
    }

    /**
     * Searches for a statement in the knowledge base based on the specified term.
     *
     * @param term the term to search for
     */
    public void searchTerm(String term) {
        // Iterate through the knowledge base array
        for (int i = 0; i < size; i++) {
            if (array[i].getTerm().equals(term)) {
                // Display the statement if the term matches
                array[i].displayStatement();
                return;
            }
        }
        System.out.println("Statement not found.");
    }

    /**
     * Searches for a statement in the knowledge base based on the specified term
     * and sentence combination.
     *
     * @param term     the term to search for
     * @param sentence the sentence to search for
     */
    public void searchTermAndSentence(String term, String sentence) {
        // Iterate through the knowledge base array
        for (int i = 0; i < size; i++) {
            // Check if the statement matches the term and sentence
            if (array[i].matches(term, sentence)) {
                // Display the statement if it matches
                array[i].displayStatement();
                return;
            }
        }
        System.out.println("Statement not found for term and sentence combination.");
    }

    /**
     * Adds or updates a statement in the knowledge base.
     * If a statement with the same term already exists, it updates the existing statement.
     * If the knowledge base is full, it displays an error message.
     *
     * @param term     the term of the statement
     * @param sentence the sentence of the statement
     * @param score    the confidence score of the statement
     */
    public void addOrUpdateStatement(String term, String sentence, double score) {
        // Search for an existing statement with the same term
        for (int i = 0; i < size; i++) {
            if (array[i].term.equals(term)) {
                // Update the existing statement if found
                array[i].updateStatement(sentence, score);
                return;
            }
        }
        // Add a new statement if the knowledge base is not full
        if (size < arrsize) {
            array[size++] = new KB(term, sentence, score);
        } else {
            System.out.println("Knowledge base is full. Cannot add new statement.");
        }
    }
}
