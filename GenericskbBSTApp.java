import java.util.Scanner;

/**
 * This class represents an application for interacting with a Binary Search Tree (BST) storing knowledge base.
 * It allows users to load knowledge from a file, add new statements, search for statements by term or term and sentence,
 * and quit the application.
 */
public class GenericskbBSTApp {
    /**
     * The main method of the application.
     * @param args The command-line arguments passed to the program.
     */
       
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Create an instance of BST to manage the knowledge base
        BST app = new BST();

        int choice;
        // Menu loop
        do {
            // Display menu options
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Load a knowledge base from a file");
            System.out.println("2. Add a new statement to the knowledge base");
            System.out.println("3. Search for an item in the knowledge base by term");
            System.out.println("4. Search for an item in the knowledge base by term and sentence");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Load knowledge base from a file
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    app.readFile(fileName);
                    break;
                case 2: // Add a new statement to the knowledge base
                    System.out.print("Enter the term: ");
                    String term = scanner.nextLine();
                    System.out.print("Enter the statement: ");
                    String statement = scanner.nextLine();
                    System.out.print("Enter the confidence score: ");
                    double score = scanner.nextDouble();
                    scanner.nextLine(); // newline
                    app.addOrUpdateStatement(term, statement, score);
                    break;
                case 3: // Search for an item in the knowledge base by term
                    System.out.print("Enter the term to search: ");
                    String termToSearch = scanner.nextLine();
                    Node foundNode = app.searchT(termToSearch);
                    if (foundNode != null) {
                        System.out.println("Statement found: " + foundNode.sentence +
                                " (Confidence score: " + foundNode.score + ")");
                    } else {
                        System.out.println("Statement not found.");
                    }
                    break;
                case 4: // Search for an item in the knowledge base by term and sentence
                    System.out.print("Enter the term: ");
                    String termForSearch = scanner.nextLine();
                    System.out.print("Enter the statement to search for: ");
                    String statementForSearch = scanner.nextLine();
                    double confidence = app.searchTermandSentence(termForSearch, statementForSearch);
                    if (confidence != -1) {
                        System.out.println("The statement was found and has a confidence score of " + confidence + ".");
                    } else {
                        System.out.println("Statement not found.");
                    }
                    break;
                case 5: // Quit 
                    System.out.println("Quit");
                    break;
                default: // Handle invalid choice
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5); // Continue until user chooses to quit

        // Close the scanner to release resources
        scanner.close();
    }
}
