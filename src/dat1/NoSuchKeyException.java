package dat1;

/**
 * Thrown to indicate that a key-value mapping was not found in a 
 * {@link BinaryTree}.
 * 
 * @author K. Atas
 */
public class NoSuchKeyException extends RuntimeException {
    /**
     * Constructs a new <tt>NoSuchKeyException</tt>.
     */
    public NoSuchKeyException() {
        super();
    }
    
    /**
     * Constructs a new <tt>NoSuchKeyException</tt> with a detail message.
     * 
     * @param message details the error condition.
     */
    public NoSuchKeyException(String message) {
        super(message);
    }
}
