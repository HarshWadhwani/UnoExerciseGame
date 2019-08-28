package uno;

import java.util.ArrayList;
/**
 * Holds methods for queuing Deck class.
 * @author Harsh
 */
public class Queue {
    
    private int last;
    private ArrayList<Card> mylist;
    
    /**
     * Initializes the deck in the form of a queue
     * @param capacity Size of the queue
     * @param myList Shuffled deck
     */
    public Queue(int capacity, ArrayList<Card> myList){
        last = capacity - 1;
        this.mylist = myList;          
    }
    
    /**
     * Returns the current deck
     * @return Current deck
     */
    public ArrayList getList(){
        return mylist;
    }
    
    /**
     * Returns the number of cards in the deck
     * @return the size of the queue plus one
     */
    public int getLast(){
        return last+1;
    }
    
    /**
     * Pushes the given card to the bottom of the deck
     * @param card1 Card to be pushed 
     */
    public void push(Card card1){
        last += 1;
        mylist.add(0, card1); 
    }
        
    /**
     * Pops the card on the top of the deck
     * @return Card on the top of the queue 
     */
    public Card pop(){
        if (last == -1){
            return null;
        }
        Card mycard = mylist.get(last);
        mylist.remove(last);
        mylist.trimToSize();
        last -=1;
        
        return mycard;
    } 
    
    /**
     * Returns number of cards in the deck
     * @return queue size 
     */
    /*public int mySize(){
        return mylist.size();
    }*/
}
