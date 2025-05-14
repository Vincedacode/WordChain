package WordChain;
import java.io.*;
import java.util.*;

public class Word_Chain {
    private Scanner myscanner = new Scanner(System.in);
    private ArrayList<String> wordList;       // Stores words in order
    private HashSet<String> wordSet;        // Ensures uniqueness
    private Stack<String> wordStack;    // Helps with undo

    public Word_Chain(ArrayList<String> wordList, HashSet<String> wordSet, Stack<String> wordStack) {
        this.wordList = wordList != null ? wordList : new ArrayList<>();
        this.wordSet = wordSet != null ? wordSet : new HashSet<>();
        this.wordStack = wordStack != null ? wordStack : new Stack<>();
    }

    public void addNewWord() {
        try {
            System.out.print("Enter word: ");
            String newWord = myscanner.nextLine().trim().toLowerCase();

            if (newWord.isEmpty()) {
                System.out.println("Word cannot be empty!");
                return;
            }


            if (wordSet.contains(newWord)) {
                System.out.println("The word already exists!");
                return;
            }


            if (!wordList.isEmpty()) {
                String lastWord = wordList.get(wordList.size() - 1);
                if (newWord.charAt(0) != lastWord.charAt(lastWord.length() - 1)) {
                    System.out.println("Word must start with '" + lastWord.charAt(lastWord.length() - 1) + "'!");
                    return;
                }
            }


            wordList.add(newWord);
            wordSet.add(newWord);
            wordStack.push(newWord);
            System.out.println("'" + newWord + "'" + "has been successfully added.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void undoLastWord() {
        try{
            if(wordStack.isEmpty()){
                System.out.println("No words to undo!");
                return;
            }
            String lastword = wordList.get(wordStack.size() - 1);
            System.out.println("Are you sure you want to undo " + "'" + lastword + "'");
            System.out.println("Enter 'Y/N'");
            String choice= myscanner.nextLine().toLowerCase();
            if(choice.equals("y")){
                wordStack.pop();
                wordList.remove(wordList.size() - 1);
                wordSet.remove(wordSet.size() - 1);
                System.out.println("Undo was successful");
            } else if (choice.equals("n")) {
                System.out.println("Undo operation cancelled!");
            } else{
                System.out.println("Please pick either 'Y/N'");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void displayWordsForwardOrder() {
       try{
           if (wordList.isEmpty()) {
               System.out.println("No words in the chain!");
           } else {
               System.out.println(wordStack);
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    public void displayWordsBackwardOrder() {
        try {
            if (wordList.isEmpty()) {
                System.out.println("No words in the chain!");
            } else {
                System.out.println(wordStack.reversed());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void saveToFile() {
        if (wordStack.isEmpty()) {
            System.out.println("No words to save!");
            return;
        }

        try (BufferedWriter savefile = new BufferedWriter(new FileWriter("wordchain.txt"))) {
            for (String word : wordStack) {
                savefile.write(word);
                savefile.newLine();
            }
            System.out.println("Words successfully saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void loadfromFile(){
        try{
            BufferedReader loadfile = new BufferedReader(new FileReader("wordchain.txt"));
                String word;
                while ((word = loadfile.readLine()) != null){
                    System.out.println(word);
                }

           loadfile.close();
        }
        catch (IOException e){
            System.out.println("Error loading from file: " + e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}