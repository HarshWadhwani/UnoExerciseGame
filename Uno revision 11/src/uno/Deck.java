package uno;

import java.util.Collections;
import java.util.ArrayList;
/**
 * Creates a shuffled deck of cards from the card class.
 * @author harshwadhwani, aaronramirez
 */
public class Deck {
    private ArrayList<Card> Card_arrList = new ArrayList<Card>();
    private ArrayList<Card> card_list = new ArrayList<Card>();
    private ArrayList<Card> final_deck = new ArrayList<Card>();
    private ArrayList<Card> discard = new ArrayList<Card>();
    private int deck_number; 
    
    /**
     * Sets the number of decks provided by the user.
     * @param num Number of decks to be used. 
     */
    public void SetDeckNumber(int num) {
        this.deck_number = num;
    }
    
    /**
     * Returns the final deck after desired shuffle method
     * @return Final shuffled deck
     */
    public ArrayList GetFinalDeck() {
        return final_deck;
    }
    
    /**
     * Places the correct number of cards for each color, number, action and, special
     * card into an un-shuffled deck.
     */
    public void setcard(){
        int color_index = 0;
        int number_index = 0;
        int action_index = 0;
        int counter = 0;
        
        String color_array[] = {"Yellow", "Red", "Green", "Blue"};
        String action_array[] = {"Skip", "Draw 2", "Reverse"};
        String special_array[] = {"Wild", "Wild draw 4"};

        for(int card_index = 0; card_index < 100; card_index++){
            if ((counter % 25 == 0) && (counter != 0)){
                color_index += 1;}
            
            if(counter == 19){
                action_index = 0;}
            if(counter == 21){
                action_index = 1;}
            if(counter == 23){
                action_index = 2;}
            
            if(counter == 0){
                Card_arrList.add(new Card(color_array[color_index], number_index));
                counter++;
                number_index++;
            }
            
            else if(counter < 19){
                if (counter % 2 != 0){
                    Card_arrList.add(new Card(color_array[color_index], number_index));
                    counter++;
                    continue;
                }
                else {
                    Card_arrList.add(new Card(color_array[color_index], number_index));
                    counter++;
                    number_index++;
                }
            }
            
            else if(counter < 25){
                if (counter % 2 != 0){
                    Card_arrList.add(new Card(color_array[color_index], action_array[action_index]));
                    counter++;
                    continue;
                }
                else {
                    Card_arrList.add(new Card(color_array[color_index], action_array[action_index]));
                    counter++;
                }
            }
            
            else{
                counter = 0;
                number_index = 0;
                card_index -= 1;
            }   
        }
        
        for(int Card_index = 100; Card_index < 108; Card_index++){
            if(Card_index < 104){
                Card_arrList.add(new Card(special_array[0]));                        
            }
            else{
                Card_arrList.add(new Card(special_array[1]));
            }
        }
    }
    
    /**
     * Adds the un-shuffled decks to the final deck and shuffles the final deck.
     */
    public void AddThenShuffle() {
        for (int index = 0; index < deck_number; index++) {
            final_deck.addAll(Card_arrList);
        }
        Collections.shuffle(final_deck);
    }
    
    /**
     * Shuffles each un-shuffled deck and adds them to the final deck.
     */
    public void ShufflethenAdd() {
        for (int index = 0; index < deck_number; index++) {
            final_deck.addAll(shuffle_deck());
            card_list.clear();
        }
    }
    
    /**
     * Shuffles the un-shuffled deck.
     * @return single shuffled deck
     */
    private ArrayList shuffle_deck(){
        for(int index = 0; index < 108; index++){
            card_list.add(Card_arrList.get(index));
        }
        Collections.shuffle(card_list);
        return card_list;
    }
    
    /**
     * Adds the given card to the discard pile.
     * @param myCard Card that needs to be added to discard pile
     */
    public void push_into_discard(Card myCard){
        discard.add(myCard);    
    }
    /**
     * test feature.
     */
     /*public ArrayList display_discard(){
        return discard;
    }*/
}