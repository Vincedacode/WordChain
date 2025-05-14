package WordChain;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        Word_Chain wordChain = new Word_Chain(new ArrayList<>(), new HashSet<>(), new Stack<>());
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add new word");
            System.out.println("2. Undo last word");
            System.out.println("3. Display Words - Forward");
            System.out.println("4. Display Words - Backward");
            System.out.println("5. Save session to file");
            System.out.println("6. Load session from file");
            System.out.println("7. Clear Session");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = myscanner.nextInt();
                myscanner.nextLine();

                switch (choice) {
                    case 1:
                        wordChain.addNewWord();
                        break;
                    case 2:
                        wordChain.undoLastWord();
                        break;
                    case 3:
                        wordChain.displayWordsForwardOrder();
                        break;
                    case 4:
                        wordChain.displayWordsBackwardOrder();
                        break;
                    case 5:
                        wordChain.saveToFile();
                        break;
                    case 6:
                        wordChain.loadfromFile();
                        break;
                    case 7:
                       wordChain.clearSession();
                    case 8:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                myscanner.nextLine();
            }
        }
        myscanner.close();
    }
}