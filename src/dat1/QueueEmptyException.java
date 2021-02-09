package dat1;

/**
 * Thrown to indicate that <tt>peek()</tt> or <tt>dequeue()</tt> was invoked on 
 * an empty {@link Queue}.
 * 
 * @author K. Atas
 */
public class QueueEmptyException extends RuntimeException {
    /**
     * Constructs a new <tt>QueueEmptyException</tt>.
     */
    public QueueEmptyException() {
        super();
    }
    
    /**
     * Constructs a new <tt>QueueEmptyException</tt> given the error message.
     * 
     * @param message details the error condition.
     */
    public QueueEmptyException(String message) {
        super(message);
    }
}