/**
 * This class represents a node in a binary search tree (BST) for storing knowledge base entries.
 * It extends the KB class to inherit properties such as term, sentence, and confidence score.
 */
public class Node extends KB {
    // References to the left and right child nodes
    Node left;
    Node right;
    
    /**
     * Constructs a Node with the given term, sentence, confidence score, and child nodes.
     * @param term The term associated with the node.
     * @param sentence The sentence associated with the term.
     * @param confidence The confidence score of the statement.
     * @param left The left child node.
     * @param right The right child node.
     */
    public Node(String term, String sentence, double confidence, Node left, Node right) {
        // Call the constructor of the KB class to initialize term, sentence, and confidence score
        super(term, sentence, confidence);
        // Initialize left and right child nodes
        this.left = null;
        this.right = null;
    }
}
