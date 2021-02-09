package dat1;

/**
 * Thrown to indicate that <tt>peek()</tt> or <tt>push()</tt> was invoked on an
 * empty {@link Stack}  
 * 
 * @author K. Atas
 */
public class StackEmptyException extends RuntimeException {
    /**
     * Constructs a new <tt>StackEmptyException</tt>.
     */
    public StackEmptyException() {
        super();
    }
    
    /**
     * Constructs a new <tt>StackEmptyException</tt> given the error message.
     * 
     * @param message details the error condition.
     */
    public StackEmptyException(String message) {
        super(message);
    }
}