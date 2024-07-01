import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The GenericskbArrayApp class provides a text-based user interface for interacting with the knowledge base.
 */
 
 //The GenericskbArrayApp class provides a text-based user interface for interacting with the knowledge base.
 // Hlomla Kuhlane
 // 28 February 2023

public class GenericskbArrayApp {

    //The GenericskbArrayApp class provides a text-based user interface for interacting with the knowledge base.
 
    /**
     * The main method that serves as the entry point of the application.
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        FileRead app = new FileRead(); // Instantiate the FileRead object

        while (true) {
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Load a knowledge base from a file");
            System.out.println("2. Add a new statement to the knowledge base");
            System.out.println("3. Search for an item in the knowledge base by term");
            System.out.println("4. Search for an item in the knowledge base by term and sentence");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.print("Enter file name: ");
                    String fileName = input.nextLine();
                    app.readFile(fileName);
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Enter the term: ");
                    String term = input.nextLine();
                    System.out.print("Enter the statement: ");
                    String statement = input.nextLine();
                    System.out.print("Enter the confidence score: ");
                    double score = input.nextDouble();
                    app.addOrUpdateStatement(term, statement, score);
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Enter the term to search: ");
                    term = input.nextLine();
                    app.searchTerm(term); 
                    break;
                case 4:
                    System.out.println("");
                    System.out.print("Enter the term: ");
                    term = input.nextLine();
                    System.out.print("Enter the statement to search for: ");
                    statement = input.nextLine();
                    app.searchTermAndSentence(term, statement);
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
