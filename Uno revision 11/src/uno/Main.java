package uno;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
/**
 * Handles all operations for the program.
 * @author Harsh
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        
        PrintStream output = new PrintStream(new File("file.txt"));
        PrintStream output2 = new PrintStream(new File("online.html"));
        Hand myHand = new Hand();
        Card myCard;
        Scanner scan = new Scanner(System.in);
        int input = 1;
        int shuffleInput = 1;
        String actionInput;
        int fileInput;
        
        do {
        System.out.print("Enter number of decks: ");
        input = scan.nextInt();
        if (input > 0 && input < 4) {
            break;
        }
        else {
            System.out.println("Please enter a number between 1 and 3");
        }
        }while(true);
        
        if (input == 1) {
        } 
        else {
            System.out.println("How would you like to shuffle the deck(s)?\n1. Shuffle together\n2. Shuffle individually");
            shuffleInput = scan.nextInt();
        }
        actionInput = scan.nextLine();
        
        System.out.println("0 = NONE 1 = SKIP, 2 = DRAW 2, 3 = REVERSE, 4 = ALL WILDS");
        System.out.println("Which actions do you want to remove?");
        actionInput = scan.nextLine();
        
        System.out.println("1. Save to file\n2. Display in console\n3. Print to HTML");
        fileInput = scan.nextInt();
        
        myHand.SetDeck(input);
        myHand.SetShuffleMethod(shuffleInput);
        myHand.SetRemoveString(actionInput);
        myHand.InitializeDeck();
        
        if (fileInput == 3) {
            output2.println("<body>");
        }
        
        while(myHand.getQueue().getLast() > 0)
        {   
            System.out.println();
            System.out.println("Deck size: " +myHand.getQueue().getLast());
            if (fileInput == 1) {
                output.println();
                output.println("Deck size: " +myHand.getQueue().getLast());
            }
            else if (fileInput == 3) {
                output2.println();
                output2.println("<p>Deck size: " +myHand.getQueue().getLast() + "<br>");
            }
            
            myHand.DrawSevenCards();
            myHand.CardSort();
            
            /*System.out.println("number sorted hand: ");
            if (fileInput == 1) {
                output.println("number sorted hand: ");
            }
            else if (fileInput == 3) {
                output2.println("number sorted hand: ");
            }*/
        
            myHand.DisplayCard(output, output2, fileInput);
            myHand.EmptyHand();
            
            System.out.println(" ");
            if (fileInput == 1) {
                output.println(" ");
            }
            else if (fileInput == 3) {
                output2.println(" ");
            }
        }
        if (fileInput == 3) {
            output2.println("</body>");
        }
    }
}
