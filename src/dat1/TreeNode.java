package dat1;

/**
 * Represents a node in a {@link BinaryTree}. A <tt>TreeNode</tt> contains a 
 * lookup key and the value that is to be associated with it. 
 * <p>
 * A <tt>BinaryTree</tt> retrieves a requested value by searching for the 
 * <tt>TreeNode</tt> containing the lookup key that was specified. It is the 
 * value of this <tt>TreeNode</tt>, if found, that is returned.
 * 
 * @author K. Atas
 */
public class TreeNode<K extends Comparable<? super K>, V> {
    private final K key;
    private V value;
    
    private TreeNode<K, V> parent;
    private TreeNode<K, V> leftChild;
    private TreeNode<K, V> rightChild;
    
    /**
     * Constructs a new <tt>TreeNode</tt>.
     * 
     * @param key the key of this <tt>TreeNode</tt>.
     * @param value the value of this <tt>TreeNode</tt>.
     */
    public TreeNode(K key, V value) {
        this(key, value, null);
    }
    
    /**
     * Constructs a new <tt>TreeNode</tt> with the specified parent.
     * 
     * @param key the key of this <tt>TreeNode</tt>.
     * @param value the value of this <tt>TreeNode</tt>.
     * @param parent the parent of this <tt>TreeNode</tt>.
     */
    public TreeNode(K key, V value, TreeNode<K, V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }
    
    /**
     * Returns a copy of this <tt>TreeNode</tt> that is detached from its 
     * parent.
     * 
     * @return a copy of this <tt>TreeNode</tt> that can be used as the root 
     *  node in a {@link BinaryTree}.
     */
    public TreeNode<K, V> asRoot() {
        TreeNode<K, V> root = new TreeNode<K, V>(key, value);
        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        return root;
    }
    
    /**
     * Gets the key of this <tt>TreeNode</tt>.
     * 
     * @return the key of this <tt>TreeNode</tt>.
     */
    public K getKey() {
        return key;
    }
    
    /**
     * Gets the value of this <tt>TreeNode</tt>.
     * 
     * @return the value of this <tt>TreeNode</tt>.
     */
    public V getValue() {
        return value;
    }
    
    /**
     * Sets a new value for this <tt>TreeNode</tt>.
     * 
     * @param value the new value of this <tt>TreeNode</tt>.
     */
    public void setValue(V value) {
        this.value = value;
    }
    
    /**
     * Gets the parent of this <tt>TreeNode</tt>.
     * 
     * @return the parent of this <tt>TreeNode</tt>. <tt>null</tt> if this is 
     *  a root node.
     */
    public TreeNode<K, V> getParent() {
        return parent;
    }
    
    /**
     * Counts the children of this <tt>TreeNode</tt>.
     * 
     * @return either zero, one or two.
     */
    public int countChildren() {
        int i = 0;
        if (leftChild != null) {
            i++;
        }
        if (rightChild != null) {
            i++;
        }
        return i;
    }
    
    /**
     * Gets the left child of this <tt>TreeNode</tt>.
     * 
     * @return the left child of this <tt>TreeNode</tt>. <tt>null</tt> if it 
     *  does not have one.
     */
    public TreeNode<K, V> getLeftChild() {
        return leftChild;
    }
    
    /**
     * Sets the left child of this <tt>TreeNode</tt>. The child will 
     * automatically have this <tt>TreeNode</tt> set as its parent.
     * 
     * @param leftChild the left child of this <tt>TreeNode</tt>.
     */
    public void setLeftChild(TreeNode<K, V> leftChild) {
        this.leftChild = leftChild;
        if (this.leftChild != null) {
            this.leftChild.parent = this;
        }
    }
    
    /**
     * Gets the right child of this <tt>TreeNode</tt>.
     * 
     * @return the right child of this <tt>TreeNode</tt>. <tt>null</tt> if it 
     *  does not have one.
     */
    public TreeNode<K, V> getRightChild() {
        return rightChild;
    }
    
    /**
     * Sets the right child of this <tt>TreeNode</tt>. The child will 
     * automatically have this <tt>TreeNode</tt> set as its parent.
     * 
     * @param rightChild the right child of this <tt>TreeNode</tt>.
     */
    public void setRightChild(TreeNode<K, V> rightChild) {
        this.rightChild = rightChild;
        if (this.rightChild != null) {
            this.rightChild.parent = this;
        }
    }

    /**
     * Returns a string representation of this <tt>TreeNode</tt>.
     */
    public String toString() {
        return String.format("TreeNode[key: %s, value: %s]", key, value);
    }
}