package dat1;

/**
 * A data structure consisting of nodes that can each have either zero, one, 
 * or at most, two children (child nodes). The topmost node is called the root 
 * node. The nodes in a <tt>BinaryTree</tt> are represented by objects of type 
 * {@link TreeNode}.
 * <p>
 * The <tt>BinaryTree</tt> associates a value with a lookup key in its 
 * <tt>add()</tt> method. This key-value mapping can later be retrieved, 
 * changed or removed by specifying the lookup key to the relevant method. 
 * 
 * @author K. Atas 
 */
public class BinaryTree<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;
    private int size;
    
    /**
     * Constructs a new <tt>BinaryTree</tt>.
     */
    public BinaryTree() {
        root = null;
        size = 0;
    }
    
    /**
     * Gets the size of this <tt>BinaryTree</tt>.
     * 
     * @return the number of key-value mappings in this <tt>BinaryTree</tt>.
     */
    public int size() {
        return size;
    }
    
    /**
     * Adds a new key-value pair to this <tt>BinaryTree</tt>. If <tt>key</tt>
     * identifies an existing mapping, the value is replaced.
     * 
     * @param key the lookup key.
     * @param value the value to associate with <tt>key</tt>.
     * @return the value that was previously associated with <tt>key</tt>, 
     *  otherwise <tt>null</tt>.
     */
    public V add(K key, V value) {
        if (root == null) {
            root = new TreeNode<K, V>(key, value);
            size++;
            return null;
        }
        TreeNode<K, V> node = root;
        while (true) {
            int sortOrder = compare(key, node.getKey());
            if (sortOrder < 0) {
                if (node.getLeftChild() != null) {
                    node = node.getLeftChild();
                    continue;
                }
                node.setLeftChild(new TreeNode<K, V>(key, value));
                size++;
                return null;
            }
            if (sortOrder > 0) {
                if (node.getRightChild() != null) {
                    node = node.getRightChild();
                    continue;
                }
                node.setRightChild(new TreeNode<K, V>(key, value));
                size++;
                return null;
            }
            V oldValue = node.getValue();
            node.setValue(value);
            return oldValue;
        }
    }
    
    /**
     * Gets the value associated with the specified key.
     * 
     * @param key the lookup key.
     * @return the value that <tt>key</tt> maps to.
     * @throws NoSuchKeyException if the key-value mapping is not found. 
     */
    public V get(K key) {
        return findNode(key).getValue();
    }
    
    /**
     * Replaces the value associated with the specified key by a new value.
     * 
     * @param key the lookup key.
     * @param value a new value to associate with <tt>key</tt>.
     * @return the previous value.
     * @throws NoSuchKeyException if the key-value mapping is not found.
     */
    public V set(K key, V value) {
        TreeNode<K, V> node = findNode(key);
        V oldValue = node.getValue();
        node.setValue(value);
        return oldValue;
    }

    /**
     * Removes a key and its associated value from this <tt>BinaryTree</tt>.
     * 
     * @param key the lookup key.
     * @return the value that was removed.
     * @throws NoSuchKeyException if the key-value mapping is not found.
     */
    public V remove(K key) {
        TreeNode<K, V> node = findNode(key);
        switch (node.countChildren()) {
            case 0:
                removeLeafNode(node);
                break;
            case 1:
                removeNodeWithOneChild(node);
                break;
            case 2:
                removeNodeWithTwoChildren(node);
                break;
        }
        size--;
        return node.getValue();
    }

    /**
     * Has the specified {@link TreeTraverser} traverse this 
     * <tt>BinaryTree</tt>. 
     * 
     * @param traverser will traverse this <tt>BinaryTree</tt> node by node.
     */
    public void traverse(TreeTraverser traverser) {
        traverser.traverse(root);
    }
    
    /**
     * Returns the contents of this <tt>BinaryTree</tt> as a {@link LinkedList}.
     * 
     * @return a {@link LinkedList} containing the items in this 
     *  <tt>BinaryTree</tt>.
     */
    @SuppressWarnings({"hiding", "unchecked"})
    public <E extends V> LinkedList<E> asList() {
        final LinkedList<E> list = new LinkedList<E>();
        traverse(TreeTraverser.inOrder(
            new TreeNodeVisitor() {
                public <K extends Comparable<K>, V> void visit(TreeNode<K, V> node) {
                    list.addLast((E)node.getValue());
                }
            }
        ));
        return list;
    }
    
    /**
     * Returns a string representation of this <tt>BinaryTree</tt>.
     */
    public String toString() {
        final StringBuffer str = new StringBuffer();
        traverse(TreeTraverser.inOrder(
            new TreeNodeVisitor() {
                public void visit(TreeNode node) {
                    if (str.length() != 0) {
                        str.append(", ");
                    }
                    str.append(node.getValue());
                }
            }
        ));
        return String.format("[%s]", str);
    }
    
    /**
     * Removes a {@link TreeNode} with no children.
     * 
     * @param node a {@link TreeNode} without children.
     */
    private void removeLeafNode(TreeNode<K, V> node) {
        if (node.getParent() != null) {
            if (compare(node.getKey(), node.getParent().getKey()) < 0) {
                node.getParent().setLeftChild(null);
            } else {
                node.getParent().setRightChild(null);
            }
        } else {
            root = null;
        }
    }
    
    /**
     * Removes a {@link TreeNode} with one, either left or right, child.
     * 
     * @param node a {@link TreeNode} with a single child.
     */
    private void removeNodeWithOneChild(TreeNode<K, V> node) {
        TreeNode<K, V> child = node.getLeftChild();
        if (child == null) {
            child = node.getRightChild();
        }
        if (node.getParent() != null) {
            if (compare(node.getKey(), node.getParent().getKey()) < 0) {
                node.getParent().setLeftChild(child);
            } else {
                node.getParent().setRightChild(child);
            }
        } else {
            root = child.asRoot();
        }
    }
    
    /**
     * Removes a {@link TreeNode} with two children.
     * 
     * @param node a {@link TreeNode} with two children.
     */
    private void removeNodeWithTwoChildren(TreeNode<K, V> node) {
        TreeNode<K, V> successor = node.getRightChild();
        int depth = 1;
        while (successor.getLeftChild() != null) {
            successor = successor.getLeftChild();
            depth++;
        }
        if (depth > 1) {
            successor.getParent().setLeftChild(successor.getRightChild());
        }
        successor.setLeftChild(node.getLeftChild());
        if (depth > 1) {
            successor.setRightChild(node.getRightChild());
        }
        if (node.getParent() != null) {
            if (compare(node.getKey(), node.getParent().getKey()) < 0) {
                node.getParent().setLeftChild(successor);
            } else {
                node.getParent().setRightChild(successor);
            }
        } else {
            root = successor.asRoot();
        }
    }
    
    /**
     * Finds the {@link TreeNode} with the specified lookup key.
     * 
     * @param key the lookup key.
     * @return the {@link TreeNode} with the specified key. 
     * @throws NoSuchKeyException if no such {@link TreeNode} is found in this 
     *  <tt>BinaryTree</tt>.
     */
    private TreeNode<K, V> findNode(K key) {
        TreeNode<K, V> node = root;
        while (node != null) {
            int sortOrder = compare(key, node.getKey());
            if (sortOrder < 0) {
                node = node.getLeftChild();
            } else if (sortOrder > 0) {
                node = node.getRightChild();
            } else {
                break;
            }
        }
        if (node == null) {
            throw new NoSuchKeyException(String.valueOf(key));
        }
        return node;
    }
    
    /**
     * Compares the specified lookup keys <tt>x</tt> and <tt>y</tt> for order.
     * 
     * @param x the first key.
     * @param y the second key.
     * @return a negative integer, zero, or a positive integer as <tt>x</tt> is
     *  less than, equal to, or greater than <tt>y</tt>.
     * @see Comparable#compareTo(T)
     */
    private int compare(K x, K y) {
        if (x == null || y == null) { // handle null keys
            if (x == y) { // both null
                return 0; // two nulls are equal
            }
            return x == null ? -1 : 1; // null < anything else
        }
        return ((Comparable<K>)x).compareTo(y);
    }
}