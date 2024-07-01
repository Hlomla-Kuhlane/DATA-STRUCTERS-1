import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Binary Search Tree (BST) implementation for storing terms, sentences, and scores.
 * Each node in the BST contains a term, a sentence associated with the term, and a score.
 */
public class BST {
    private Node root;

    /**
     * Constructs an empty Binary Search Tree.
     */
    public BST() {
        root = null;
    }

    /**
     * Searches for a term in the BST.
     * @param term The term to search for.
     * @return The node containing the term if found, otherwise returns null.
     */
    public Node searchT(String term) {
        return searchTR(root, term);
    }

    /**
     * Recursive helper method to search for a term in the BST.
     * @param root The root of the subtree to search.
     * @param term The term to search for.
     * @return The node containing the term if found, otherwise returns null.
     */
    private Node searchTR(Node root, String term) {
        if (root == null) {
            return null;
        } else if (root.term.equalsIgnoreCase(term)) {
            return root;
        } else if (term.compareToIgnoreCase(root.term) < 0) {
            return searchTR(root.left, term);
        } else {
            return searchTR(root.right, term);
        }
    }

    /**
     * Adds or updates a statement in the BST.
     * @param term The term associated with the statement.
     * @param sentence The sentence to add or update.
     * @param score The score of the statement.
     */
    public void addOrUpdateStatement(String term, String sentence, double score) {
        root = addOrUpdateStatementR(root, term, sentence, score);
    }

    /**
     * Recursive helper method to add or update a statement in the BST.
     * @param root The root of the subtree to add or update the statement.
     * @param term The term associated with the statement.
     * @param sentence The sentence to add or update.
     * @param score The score of the statement.
     * @return The root of the updated subtree.
     */
    private Node addOrUpdateStatementR(Node root, String term, String sentence, double score) {
        if (root == null) {
            return new Node(term, sentence, score, null, null);
        } else if (term.compareToIgnoreCase(root.term) < 0) {
            root.left = addOrUpdateStatementR(root.left, term, sentence, score);
        } else if (term.compareToIgnoreCase(root.term) > 0) {
            root.right = addOrUpdateStatementR(root.right, term, sentence, score);
        } else if (score > root.score) {
            System.out.println("Statement for term " + term + " has been updated.");
            root.sentence = sentence;
            root.score = score;
        }
        return root;
    }

    /**
     * Deletes a term and its associated statement from the BST.
     * @param term The term to delete.
     */
    public void deleteTerm(String term) {
        root = deleteTermR(root, term);
    }

    /**
     * Recursive helper method to delete a term from the BST.
     * @param root The root of the subtree to delete the term from.
     * @param term The term to delete.
     * @return The root of the updated subtree.
     */
    private Node deleteTermR(Node root, String term) {
        if (root == null) {
            return root;
        }
        if (term.compareToIgnoreCase(root.term) < 0) {
            root.left = deleteTermR(root.left, term);
        } else if (term.compareToIgnoreCase(root.term) > 0) {
            root.right = deleteTermR(root.right, term);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.term = minValue(root.right).term;
            root.right = deleteTermR(root.right, root.term);
        }
        return root;
    }

    /**
     * Finds the node with the minimum value in a given subtree.
     * @param node The root of the subtree.
     * @return The node with the minimum value.
     */
    private Node minValue(Node node) {
        Node present = node;
        while (present.left != null) {
            present = present.left;
        }
        return present;
    }

    /**
     * Traverses the BST in in-order traversal and prints each node.
     */
    public void traverseTree() {
        traverseTreeR(root);
    }

    /**
     * Recursive helper method to traverse the BST in in-order traversal.
     * @param root The root of the subtree to traverse.
     */
    private void traverseTreeR(Node root) {
        if (root != null) {
            traverseTreeR(root.left);
            System.out.println("Term: " + root.term + ", Sentence: " + root.sentence + ", Score: " + root.score);
            traverseTreeR(root.right);
        }
    }

    /**
     * Reads data from a file and populates the BST with terms, sentences, and scores.
     * The file should have each line formatted as "term\tsentence\tscore".
     * @param fileName The name of the file to read from.
     */
    public void readFile(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    String term = parts[0];
                    String sentence = parts[1];
                    double score = Double.parseDouble(parts[2]);
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
     * Searches for a term and a sentence in the BST and returns the associated score.
     * @param term The term to search for.
     * @param sentence The sentence to search for.
     * @return The score associated with the term and sentence if found, otherwise returns -1.
     */
    public double searchTermandSentence(String term, String sentence) {
        return searchTermandSentenceR(root, term, sentence);
    }

    /**
     * Recursive helper method to search for a term and a sentence in the BST.
     * @param root The root of the subtree to search.
     * @param term The term to search for.
     * @param sentence The sentence to search for.
     * @return The score associated with the term and sentence if found, otherwise returns -1.
     */

private double searchTermandSentenceR(Node root, String term, String sentence) {
    if (root == null) {
        return -1; 
    }
    
        int termComparison = term.compareToIgnoreCase(root.term);
    int sentenceComparison = sentence.compareToIgnoreCase(root.sentence);

    if (termComparison == 0 && sentenceComparison == 0) {
        
        return root.score;
    } else if (termComparison < 0) {
                return searchTermandSentenceR(root.left, term, sentence);
    } else if (termComparison > 0 || (termComparison == 0 && sentenceComparison > 0)) {
       
        return searchTermandSentenceR(root.right, term, sentence);
    } else {
               return -1;
    }
}
}
