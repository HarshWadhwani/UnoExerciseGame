package uno;
/**
 * Holds information about each card and what they do.
 * @author harshwadhwani, aaronramirez
 */
public class Card {

    private int number;
    private String color;
    private String action;
    private String special;
    
    /**
     * Creates number cards.
     * @param color Color of the card (Yellow, Red, Green, Blue).
     * @param number Number of the card (0-9).
     */
    public Card(String color, int number){
        this.color = color;
        this.number = number;
        this.action = "nothing";
        this.special = "nothing";
    }
    
    /**
     * Creates special cards.
     * @param special Defines Wild or Wild Draw 4 
     */
    public Card(String special){
        this.color = "black";
        this.number = 99;
        this.action = "nothing";
        this.special = special;                   
    }
    
    /**
     * Creates action cards.
     * @param color Color of the card (Yellow, Red, Green, Blue).
     * @param action Action of the card (Skip, Draw 2, Reverse).
     */
    public Card(String color, String action){
        this.color = color;
        this.number = 99;
        this.action = action;
        this.special = "nothing;";
    }
    
    /**
     * 
     * @return Number of the card.
     */
    public int getnumber(){
        return number;
    }
    
    /**
     * 
     * @return Color of the card.
     */
    public String getcolor(){
        return color;
    }
    
    /**
     * 
     * @return Action of the card. 
     */
    public String getaction(){
        return action;
    }
    
    /**
     * 
     * @return Special action of the card.
     */
    public String getspecial(){
        return special;
    }
}