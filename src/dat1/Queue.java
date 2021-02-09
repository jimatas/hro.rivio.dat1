package dat1;

/**
 * The <tt>Queue</tt> class implements a first-in first-out (FIFO) data 
 * structure.
 * <p>
 * Items are added to (enqueued in) the <tt>Queue</tt> using <tt>enqueue()</tt> 
 * and removed (dequeued) from it using <tt>dequeue()</tt>. <tt>isEmpty()</tt> 
 * is provided as a means to determine whether or not the <tt>Queue</tt> is 
 * empty.
 * 
 * @author K. Atas
 */
public class Queue<E> {
    private final LinkedList<E> items;
    
    /**
     * Constructs a new <tt>Queue</tt>.
     */
    public Queue() {
        items = new LinkedList<E>();
    }
    
    /**
     * Determines whether this <tt>Queue</tt> is empty.
     * 
     * @return <tt>true</tt> if this <tt>Queue</tt> is empty, <tt>false</tt>
     *  otherwise.
     */
    public boolean isEmpty() {
        return items.size() == 0;
    }
    
    /**
     * Determines whether this <tt>Queue</tt> contains the specified item.
     * 
     * @param item the item to look for.
     * @return <tt>true</tt> if this <tt>Queue</tt> contains the specified 
     *  item, <tt>false</tt> otherwise.
     */
    public boolean contains(E item) {
        return items.indexOf(item) >= 0;
    }
    
    /**
     * Returns the item at the head of this <tt>Queue</tt> without removing it.
     * 
     * @return the item at the head of this <tt>Queue</tt>.
     * @throws QueueEmptyException if the <tt>Queue</tt> is empty.
     */
    public E peek() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return items.getFirst();
    }
    
    /**
     * Removes and returns the item at the head of this <tt>Queue</tt>.
     * 
     * @return the item at the head of this <tt>Queue</tt>.
     * @throws QueueEmptyException if the <tt>Queue</tt> is empty.
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return items.removeFirst();
    }
    
    /**
     * Adds the specified item to the end of this <tt>Queue</tt>.
     * 
     * @param item the item to place in this <tt>Queue</tt>.
     */
    public void enqueue(E item) {
        items.addLast(item);
    }
    
    /**
     * Returns a string representation of this <tt>Queue</tt>.
     */
    public String toString() {
        return items.toString();
    }
}