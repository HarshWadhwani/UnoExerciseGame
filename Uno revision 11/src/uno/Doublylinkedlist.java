package uno;

import java.io.PrintStream;
/**
 * Holds methods for Doubly Linked List used in Hand class.
 * @author aaronramirez
 */
public class Doublylinkedlist {
    private Node head;
    private Node tail;
    private Card mycard;
    
    /**
     * Creates a doubly linked list with null pointers.
     */
    public Doublylinkedlist(){
        head = null;
        tail = null;
    }    
    
    /**
     * Returns head pointer
     * @return Head pointer
     */
    public Node gethead(){
        return head;
    }
    
    /**
     * Sets head to the desired node
     * @param myNode Node that the head needs to point to 
     */
    public void sethead(Node myNode){
        this.head = myNode;
    }
    
    /**
     * Returns tail pointer
     * @return Tail pointer
     */
    public Node gettail(){
        return tail;
    }
    
    /**
     * Pushes a new card to the end of the doubly linked list
     * @param new_card Card to be pushed in the doubly linked list 
     */
    public void push(Card new_card){
        Node new_node = new Node(new_card);
        if(tail == null || head == null){
            head = new_node;
            tail = new_node;
            new_node.prev = null;
            new_node.next = null;
        }
        else{
            tail.next = new_node;
            new_node.next = null;
            new_node.prev = tail;
            tail = new_node;    
        }
    }
    
    /**
     * Pops the card at the end of the doubly linked list
     * @return Card at the end of the doubly linked list 
     */
    public Card pop() {
        Card myCard;
        myCard = tail.data;
        tail = tail.prev;
        return myCard;
    }
    
    /**
     * Removes the desired card from the doubly linked list
     * @param temp Pointer pointing to the node to be removed
     * @return Card removed
     */
    public Card remove(Node temp){
        Card myCard;
        myCard = temp.data;
        if(temp.prev == null && temp.next == null){
            this.head = temp.next;
            this.tail = temp.prev;
        }
        else if(temp.prev == null){
           this.head = temp.next;
           temp.next.prev = null;
        }
        else if(temp.next == null){
            this.tail = temp.prev;
            temp.prev.next = null;
        }
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        
        temp.prev = null;
        temp.next = null;
        return myCard;   
    }
        
    /**
     * Moves the card to the end of the doubly linked list
     * @param temp Pointer pointing to the node 
     */
    public void move_to_end(Node temp){
        
        mycard = temp.data;
        while(temp.next != null){
            temp = temp.next;
            temp.prev.data = temp.data;
        }
        temp.data = mycard;
    }
    
    /**
     * Moves the desired card to the specified position after the card.
     * @param temp Pointer pointing to the node
     * @param temptail Pointer pointing to the last node
     */
    public void move_to_end(Node temp, Node temptail){
        
        mycard = temp.data;
        while(temp != temptail){
            temp = temp.next;
            temp.prev.data = temp.data;
        }
        temp.data = mycard;
    }
    
    /**
     * Prints each card in the doubly linked list to the console
     * @param output prints to the text file
     * @param userInput checks if output needs to be printed in text file
     */
    public void display(PrintStream output, PrintStream output2, int userInput){
        Node temp = head;
        while(temp != null){
            mycard = temp.data;
            if (userInput == 1) {
                output.println(mycard.getnumber()+ " " +mycard.getcolor()+ " " +mycard.getaction()+ " " +mycard.getspecial());
            }
            else if (userInput == 3) {
                output2.println(mycard.getnumber()+ " " +mycard.getcolor()+ " " +mycard.getaction()+ " " +mycard.getspecial() + "<br>");
            }
            System.out.println(mycard.getnumber()+ " " +mycard.getcolor()+ " " +mycard.getaction()+ " " +mycard.getspecial());
            temp = temp.next;
        }         
    }
}