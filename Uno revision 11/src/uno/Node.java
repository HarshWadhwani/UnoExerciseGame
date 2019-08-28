package uno;

/**
 * Holds pointers and data for each Card node in the Doubly Linked List.
 * @author harshwadhwani, aaronramirez
 */
public class Node {
    Card data;
    Node prev;
    Node next;
    
    /**
     * Initializes a node with given Card Object.
     * @param card Card object to be stored in the node. 
     */
    Node (Card card){
        data = card;
        prev = null;
        next = null;
    }
    
    /**
     * Default constructor.
     */
    Node(){
        data = null;
        prev = null;
        next = null;
    } 
}
