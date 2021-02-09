package dat1;

/**
 * The <tt>Stack</tt> class implements a last-in first-out (LIFO) data 
 * structure.
 * <p>
 * Items are added to (pushed onto) the <tt>Stack</tt> using <tt>push()</tt> 
 * and removed (popped) from it using <tt>pop()</tt>. <tt>isEmpty()</tt> is 
 * provided as a means to determine whether or not the <tt>Stack</tt> is empty.
 * 
 * @author K. Atas
 */
public class Stack<E> {
    private final LinkedList<E> items;
    
    /**
     * Constructs a new <tt>Stack</tt>.
     */
    public Stack() {
        items = new LinkedList<E>();
    }
    
    /**
     * Determines whether this <tt>Stack</tt> is empty.
     * 
     * @return <tt>true</tt> if this <tt>Stack</tt> is empty, <tt>false</tt> 
     *  otherwise.
     */
    public boolean isEmpty() {
        return items.size() == 0;
    }
    
    /**
     * Determines whether this <tt>Stack</tt> contains the specified item.
     * 
     * @param item the item to look for.
     * @return <tt>true</tt> if this <tt>Stack</tt> contains the specified 
     *  item, <tt>false</tt> otherwise.
     */
    public boolean contains(E item) {
        return items.indexOf(item) >= 0;
    }
    
    /**
     * Returns the item at the top of this <tt>Stack</tt> without removing it.
     * 
     * @return the item at the top of this <tt>Stack</tt>.
     * @throws StackEmptyException if the <tt>Stack</tt> is empty.
     */
    public E peek() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return items.getLast();
    }
    
    /**
     * Removes and returns the item at the top of this <tt>Stack</tt>.
     * 
     * @return the item at the top of this <tt>Stack</tt>.
     * @throws StackEmptyException if the <tt>Stack</tt> is empty.
     */
    public E pop() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return items.removeLast();
    }
    
    /**
     * Adds the specified item to the top of this <tt>Stack</tt>. 
     * 
     * @param item the item to push onto this <tt>Stack</tt>.
     */
    public void push(E item) {
        items.addLast(item);
    }
    
    /**
     * Returns a string representation of this <tt>Stack</tt>.
     */
    public String toString() {
        return items.toString();
    }
}