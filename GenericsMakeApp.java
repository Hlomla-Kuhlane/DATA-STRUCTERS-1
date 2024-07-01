import java.util.*;

/**
 * This class serves as the main entry point for the Generics KB (Knowledge Base) application.
 * Users can choose between using an array or a binary search tree.
 */
public class GenericsMakeApp {

   /**
    * Main method to start the Generics KB application.
    * It prompts the user to choose between an array or a binary search tree.
    * @param args Command line arguments (not used in this application)
    */
   public static void main(String[] args) {
       System.out.println("WELCOME TO GENERICS KB APP!");
       System.out.println();
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Will you be using an Array or Binary Search Tree?");
       int input = keyboard.nextInt();
       if(input == 1) {
           GenericskbArrayApp.main(args);
       } else if (input == 2) {
           GenericskbBSTApp.main(args);
       }
   }
}
