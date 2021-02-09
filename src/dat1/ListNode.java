package dat1;

/**
 * Represents a node (or entry) in a {@link LinkedList}.
 * <p>
 * Each <tt>ListNode</tt> can be linked to a next and a previous 
 * <tt>ListNode</tt>. Those are the nodes that will come immediately before
 * and after it in a <tt>LinkedList</tt>.
 * 
 * @author K. Atas
 */
public class ListNode<E> {
    private E item;
    private ListNode<E> prev;
    private ListNode<E> next;
 
    /**
     * Constructs a new <tt>ListNode</tt>.
     * 
     * @param item the data item to store in this <tt>ListNode</tt>.
     */
    public ListNode(E item) {
        this.item = item;
    }
    
    /**
     * Gets the data item contained in this <tt>ListNode</tt>.
     * 
     * @return the data item of this <tt>ListNode</tt>.
     */
    public E getItem() {
        return item;
    }
    
    /**
     * Sets the data item of this <tt>ListNode</tt>.
     * 
     * @param item the new data item to store in this <tt>ListNode</tt>.
     */
    public void setItem(E item) {
        this.item = item;
    }
    
    /**
     * Gets the <tt>ListNode</tt> that comes immediately before this one.
     * 
     * @return the previous <tt>ListNode</tt>. <tt>null</tt> if there isn't 
     *  one. 
     */
    public ListNode<E> getPrevious() {
        return prev;
    }
    
    /**
     * Sets the <tt>ListNode</tt> that will come immediately before this one.
     * 
     * @param prev the previous node in the list.
     */
    public void setPrevious(ListNode<E> prev) {
        this.prev = prev;
        if (this.prev != null) {
            this.prev.next = this;
        }
    }
    
    /**
     * Gets the <tt>ListNode</tt> that comes immediately after this one.
     * 
     * @return the next <tt>ListNode</tt>. <tt>null</tt> if there isn't one.
     */
    public ListNode<E> getNext() {
        return next;
    }
    
    /**
     * Sets the <tt>ListNode</tt> that will come immediately after this one.
     * 
     * @param next the next node in the list.
     */
    public void setNext(ListNode<E> next) {
        this.next = next;
        if (this.next != null) {
            this.next.prev = this;
        }
    }
}