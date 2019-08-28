package uno;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.io.PrintStream;
/**
 * Holds methods to draw, sort and count from the Doubly Linked List.
 * @author Harsh
 */
public class Hand {
    private ArrayList<Card> myList;
    private Queue myQueue;
    private Deck myDeck = new Deck();
    private Doublylinkedlist myhandlist = new Doublylinkedlist();
    private static final int seven = 7;
    private HashMap<String, Integer> finalList = new HashMap();
    private HashMap<String, Integer> finalSkippedList = new HashMap();
    private int shuffleMethod;
    private String removeString;
    
    private String color_array[] = {"Yellow", "Red", "Green", "Blue"};
    private String action_array[] = {"Skip", "Draw 2", "Reverse"};
    private int number_array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    /**
     * Initialized the hand and sets the total exercise repetitions to zero. 
     */
    public Hand() {
        int squats = 0;
        finalList.put("Yellow", squats);
        finalSkippedList.put("Yellow", squats);
        
        Integer sitUps = 0;
        finalList.put("Red", sitUps);
        finalSkippedList.put("Red", sitUps);
        
        Integer lunges = 0;
        finalList.put("Green", lunges);      
        finalSkippedList.put("Green", lunges);
        
        Integer pushUps = 0;
        finalList.put("Blue", pushUps);
        finalSkippedList.put("Blue", pushUps);
        
        int burpees = 0;
        finalList.put("Black", burpees);
    }
    
    /**
     * Sets the shuffle method for the final deck to be used.
     * @param num shuffle method number
     */
    public void SetShuffleMethod(int num) {
        this.shuffleMethod = num;
    }
    
    /**
     * Sets the string for the remove card method's functionality
     * @param str string of numbers
     * @see #RemoveCards(java.lang.String)
     */
    public void SetRemoveString(String str) {
        this.removeString = str;
    }
    
    /**
     * Sets the number of decks
     * @param num number of decks to be used
     */
    public void SetDeck(int num) {
        myDeck.SetDeckNumber(num);
    }
    
    /**
     * Removes the action cards that the user specifies
     * @param num string of numbers for the corresponding card to be removed 
     */
    public void RemoveCards(String num) {
        
        if (num.contains("1")){
            for (int index = 0; index < myList.size(); index++){
                if (myList.get(index).getaction().compareTo("Skip") == 0){
                    myList.remove(myList.get(index));
                    index -= 1;
                }
            }
        }
        if (num.contains("2")){
            for (int index = 0; index < myList.size(); index++){
                if (myList.get(index).getaction().compareTo("Draw 2") == 0){
                    myList.remove(myList.get(index));
                    index -= 1;
                }
            }
        }
        if (num.contains("3")){
            for (int index = 0; index < myList.size(); index++){
                if (myList.get(index).getaction().compareTo("Reverse") == 0){
                    myList.remove(myList.get(index));
                    index -= 1;
                }
            }
        }
        if (num.contains("4")){
            for (int index = 0; index < myList.size(); index++){
                if (myList.get(index).getcolor().compareTo("black") == 0){
                    myList.remove(myList.get(index));
                    index -= 1;
                }
            }
        }
    }
    
    /**
     * Shuffles and puts the Deck in a queue 
     */
    public void InitializeDeck() {
        myDeck.setcard();
        
        if (shuffleMethod == 1) {
            myDeck.AddThenShuffle();
        }
        else if (shuffleMethod == 2) {
            myDeck.ShufflethenAdd();
        }
        myList = myDeck.GetFinalDeck();
        
        RemoveCards(removeString);
        
        myQueue = new Queue(myList.size(), myList);
    }
    
    /**
     * Draws seven or less card from the deck for the round
     */
    public void DrawSevenCards() {
        Card myCard;
        int fluff = myQueue.getLast();

        if(myQueue.getLast() >= seven){
            for(int index = 0; index < 7; index++){
                myCard = myQueue.pop();
                myhandlist.push(myCard);
            }
        }
        else{
            for(int index = 0; index < fluff; index++){
                
                myCard = myQueue.pop();
                myhandlist.push(myCard);

            }             
        }        
    }        
    
    /**
     * Displays each card in hand to the console or to the text file 
     * @param output prints to the text file
     * @param userInput checks if output needs to be printed in text file 
     */
    public void DisplayCard(PrintStream output, PrintStream output2, int userInput){
        myhandlist.display(output, output2, userInput);
        CountExcercises(output, output2, userInput);
        if (userInput == 1) {
            output.println("final: " + "Squats: " + finalList.get("Yellow") + " Sit Ups: " + finalList.get("Red") + " Lunges: " + finalList.get("Green") + " Push Ups: " + finalList.get("Blue") + " Black: " + finalList.get("Black"));
            output.println("final skipped: " + "Squats: " + finalSkippedList.get("Yellow") + " Sit Ups: " + finalSkippedList.get("Red") + " Lunges: " + finalSkippedList.get("Green") + " Push Ups: " + finalSkippedList.get("Blue"));
        }
        else if (userInput == 3) {
            output2.println("final: " + "Squats: " + finalList.get("Yellow") + " Sit Ups: " + finalList.get("Red") + " Lunges: " + finalList.get("Green") + " Push Ups: " + finalList.get("Blue") + " Black: " + finalList.get("Black") + "<br>");
            output2.println("final skipped: " + "Squats: " + finalSkippedList.get("Yellow") + " Sit Ups: " + finalSkippedList.get("Red") + " Lunges: " + finalSkippedList.get("Green") + " Push Ups: " + finalSkippedList.get("Blue") + "<br>");
        }
        System.out.println("final: " + "Squats: " + finalList.get("Yellow") + " Sit Ups: " + finalList.get("Red") + " Lunges: " + finalList.get("Green") + " Push Ups: " + finalList.get("Blue") + " Black: " + finalList.get("Black"));
        System.out.println("final skipped: " + "Squats: " + finalSkippedList.get("Yellow") + " Sit Ups: " + finalSkippedList.get("Red") + " Lunges: " + finalSkippedList.get("Green") + " Push Ups: " + finalSkippedList.get("Blue"));
    }
    
    
    /*public void DisplayDiscard(){
       ArrayList<Card> Discard = myDeck.display_discard(); 
       Card myCard = new Card("foo");
       int index = 0;
       while(index != Discard.size()){
           myCard = Discard.get(index);
           index ++;
           System.out.println(myCard.getnumber()+ " " +myCard.getcolor()+ " " +myCard.getaction()+ " " +myCard.getspecial());
       }
    }*/
    
    /**
     * Removes all the cards from the hand
     */
    public void EmptyHand() {
        Card myCard;
        while(myhandlist.gettail() != null){
            myCard = myhandlist.pop();
            myDeck.push_into_discard(myCard);                
        }
    }
    
    /**
     * Returns the deck
     * @return queue
     */
    public Queue getQueue(){
        return myQueue;
    }
    
    /**
     * Uses insertion sort to sort hand by color, then by number and actions cards
     */
    public void CardSort(){
        Node temp;
        temp = myhandlist.gethead();
        int color_count = 0;
        int card_count = 0;
        int action_count = 0;
        int number_count = 0;
        Node temphead;
        Node temptail;
        ArrayList<String> new_color_array = new ArrayList();
        LinkedHashSet<String> color_noDup;
        ArrayList<String> color_noDup_arr;
        
        do{       
            if(temp.data.getcolor().compareTo(color_array[color_count])==0){
                myhandlist.move_to_end(temp);
                new_color_array.add(color_array[color_count]);
            }
            else{
                temp = temp.next;
                if(temp == null){
                    break;
                }
            }
   
            card_count++;
            
            if(card_count == 6 || temp.next == null){
                color_count +=1;
                card_count = 0;
                temp = myhandlist.gethead();
            }
           
        } 
        while(color_count != 4);
        
        color_noDup = new LinkedHashSet(new_color_array);
        color_noDup_arr = new ArrayList(color_noDup);

        color_count = 0;
        temp = myhandlist.gethead();
        temphead = myhandlist.gethead();
        temptail = myhandlist.gethead();

        do{
            if(temptail.next == null){
                break;
            }
            if(temphead.data.getcolor().compareTo(color_noDup_arr.get(color_count))==0){
                while((temptail.next != null) && (temptail.next.data.getcolor().compareTo(temptail.data.getcolor())) == 0){

                    temptail = temptail.next;
                }
            }
            else{
                temptail = temptail.next;
                temphead = temptail;
                temp = temptail;
                continue;
                
            }
            
            do{
                int counter = 0;
                if(temphead == temptail){
                    break;
                } 
                while (counter != 2){
                    if(temp.data.getnumber() == number_array[number_count]){
                        myhandlist.move_to_end(temp, temptail);
                        counter++;
                    }
                    else{
                        temp = temp.next;
                    }
                    if(temp == temptail){
                        break;
                    }
                }
                number_count++;
                temp = temphead;
            }while(number_count != 10);
            
            do{
                int counter = 0;
               
                if(temphead == temptail){
                    break;
                }
                
                while (counter != 2){
                    if(temp.data.getaction().compareTo(action_array[action_count]) == 0){
                        myhandlist.move_to_end(temp, temptail);
                        counter++;
                    }
                    else{
                        temp = temp.next;
                    }
                    if(temp == temptail){
                        break;
                    }
                }
                action_count++;
                temp = temphead;
            }while(action_count != 3);
            
           color_count++;
           action_count = 0;
           number_count = 0;
           
        }while(color_count != color_noDup_arr.size());
    }
    
    /**
     * Counts the exercises in the hand, adds them to the final count and prints them out 
     * @param output prints to the text file
     * @param userInput checks if output needs to be printed in text file 
     */
    public void CountExcercises (PrintStream output, PrintStream output2, int userInput) {
        
        HashMap<String, Integer> mapList = new HashMap();
        HashMap<String, Integer> skippedList = new HashMap();
        
        int squats = 0;
        mapList.put("Yellow", squats);
        skippedList.put("Yellow", squats);
       
        Integer sitUps = 0;
        mapList.put("Red", sitUps);
        skippedList.put("Red", sitUps);
        
        Integer lunges = 0;
        mapList.put("Green", lunges);
        skippedList.put("Green", lunges);        
        
        Integer pushUps = 0;
        mapList.put("Blue", pushUps);
        skippedList.put("Blue", pushUps);
        
        int burpees = 0;
        mapList.put("Black", burpees);
        int multiplyBy4 = 1;
        
        Node temp = myhandlist.gethead();
        
        while (temp != null){
            if (temp.data.getcolor().compareTo("black") == 0) {
                mapList.put("Black", mapList.get("Black") + 4);
                finalList.put("Black", finalList.get("Black") + 4);
                
                if (temp.data.getspecial().compareTo("Wild draw 4")==0){
                     
                    if (multiplyBy4 == 1) {
                        multiplyBy4 += 3;
                    }  
                    
                    else {
                        multiplyBy4*= 4;
                    }
                }
            }
            temp = temp.next;
        }
        
        
       
        for (int color_count = 0; color_count != 4; color_count++) {
            
            temp = myhandlist.gethead();
            
            if(temp == null){
                break;
            }
            
            while ((temp.data.getcolor().compareTo(color_array[color_count]))!=0) {
                temp = temp.next;
                if (temp == null) {
                    break;
                }
            }
            
            while ((temp != null) && (temp.data.getcolor().compareTo(color_array[color_count])) == 0) {
                if (temp.data.getnumber() != 99) {
                    mapList.put(temp.data.getcolor(), (mapList.get(temp.data.getcolor())+temp.data.getnumber()));
                    
                }
                
                else{
                    if ((temp.data.getaction().compareTo("Skip"))==0) {
                        Card myCard;
                        Node temphead, temptail, temp1;
                        
                        mapList.put(temp.data.getcolor(), 0);
                        temphead = temp;
                        temptail = temp;
                        
                        while(temphead.prev != null && temphead.prev.data.getcolor().compareTo(temp.data.getcolor()) == 0){
                            temphead = temphead.prev;        
                        }
                        
                        while(temptail.next != null && temptail.next.data.getcolor().compareTo(temp.data.getcolor()) == 0){
                            temptail = temptail.next;
                        }
                        
                        temp1 = temphead;
                        Node temp2 = new Node();
                        
                        do{
                            if(temp1 == temptail){
                                temp2.next = temp1.next;
                                myhandlist.remove(temp1);
                                temp1 = temp2;
                                break;
                            }
                            
                            else{
                                if (temp1.data.getnumber() != 99) {
                                    skippedList.put(temp1.data.getcolor(), (skippedList.get(temp1.data.getcolor()) + temp1.data.getnumber()));
                                }
                                temp2.next = temp1.next;
                                myhandlist.remove(temp1);
                                temp1 = temp2;
                                temp1 = temp1.next;
                            }
                        }
                        while(temp != temptail);
                        
                        temp = temp1;
                    }
                    
                    else if ((temp.data.getaction().compareTo("Draw 2")) == 0) {
                        mapList.put(temp.data.getcolor(), (mapList.get(temp.data.getcolor()) * 2));
                    }
                    
                    else if ((temp.data.getaction().compareTo("Reverse"))==0) {
                        Card myCard;
                        Node tempRev = temp.prev;
                        mapList.put(temp.data.getcolor(), 0);
                        
                        do{
                            if(tempRev == null || tempRev.data.getcolor().compareTo(temp.data.getcolor())!=0){
                                break;
                            }
                            
                            else{
                                myQueue.push(tempRev.data);
                                tempRev.next.prev = tempRev.prev;
                                
                                if(tempRev.prev == null){
                                    myhandlist.sethead(tempRev.next);
                                    tempRev.prev = null;
                                    tempRev.next = null;
                                }
                                
                                else{
                                    tempRev.prev.next = tempRev.next;
                                }
                                
                                tempRev = tempRev.prev;
                            }
                        }
                        while (tempRev != null && tempRev.data.getcolor().compareTo(color_array[color_count]) == 0); 
                        
                        Node temp1 = new Node();
                        temp1.next = temp.next;
                        myCard = myhandlist.remove(temp);
                        temp = temp1;
                        
                        break;
                    }
                }
                temp = temp.next;
            }
        }
        
        for (int color_count = 0; color_count != 4; color_count++) {
            mapList.put(color_array[color_count], (mapList.get(color_array[color_count]) * multiplyBy4));
            finalList.put(color_array[color_count], finalList.get(color_array[color_count]) + mapList.get(color_array[color_count]));
            finalSkippedList.put(color_array[color_count], finalSkippedList.get(color_array[color_count]) + skippedList.get(color_array[color_count]));
        }
        
        if (userInput == 1) {
            output.println("final: " + "Squats: " + finalList.get("Yellow") + " Sit Ups: " + finalList.get("Red") + " Lunges: " + finalList.get("Green") + " Push Ups: " + finalList.get("Blue") + " Black: " + finalList.get("Black"));
            output.println("final skipped: " + "Squats: " + finalSkippedList.get("Yellow") + " Sit Ups: " + finalSkippedList.get("Red") + " Lunges: " + finalSkippedList.get("Green") + " Push Ups: " + finalSkippedList.get("Blue"));
        }
        else if (userInput == 3) {
            output2.println("final: " + "Squats: " + finalList.get("Yellow") + " Sit Ups: " + finalList.get("Red") + " Lunges: " + finalList.get("Green") + " Push Ups: " + finalList.get("Blue") + " Black: " + finalList.get("Black") + "<br>");
            output2.println("final skipped: " + "Squats: " + finalSkippedList.get("Yellow") + " Sit Ups: " + finalSkippedList.get("Red") + " Lunges: " + finalSkippedList.get("Green") + " Push Ups: " + finalSkippedList.get("Blue") + "<br>");
        }
        System.out.println("Skipped: " + "Squats: " + skippedList.get("Yellow") + " Sit Ups: " + skippedList.get("Red") + " Lunges: " + skippedList.get("Green") + " Push Ups: " + skippedList.get("Blue") + " ");
        System.out.println("Round: " + "Squats: " + mapList.get("Yellow") + " Sit Ups: " + mapList.get("Red") + " Lunges: " + mapList.get("Green") + " Push Ups: " + mapList.get("Blue") + " Black: " + mapList.get("Black"));
    }
}