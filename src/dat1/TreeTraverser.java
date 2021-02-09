package dat1;

/**
 * Traverses a {@link BinaryTree} in either pre-, in- or post-order fashion.
 * <p>
 * The {@link TreeNodeVisitor} object that is supplied to the relevant 
 * traversal method, is called upon to visit each {@link TreeNode} during the 
 * traversal. Any required functionality is implemented in this visitor. 
 * <p>
 * The following example prints out all the nodes in the {@link BinaryTree} 
 * <tt>tree</tt>, in ascending order:
 * <pre>
 *   tree.traverse(TreeTraverser.inOrder(
 *     new TreeNodeVisitor() { // anonymous inner class implementation.
 *       public void visit(TreeNode node) {
 *         System.out.println(node.toString());
 *       }
 *     }
 *   ));
 * </pre>
 * 
 * @author K. Atas
 */
public abstract class TreeTraverser {
    private final TreeNodeVisitor visitor;
   
    /**
     * Constructs a new <tt>TreeTraverser</tt>.
     * 
     * @param visitor asked to visit each {@link TreeNode} in the traversal.
     */
    protected TreeTraverser(TreeNodeVisitor visitor) {
        this.visitor = visitor;
    }
    
    /**
     * Traverses a {@link BinaryTree} node by node starting at the specified, 
     * root node.
     * 
     * @param root the root {@link TreeNode}. <tt>null</tt> if the tree to 
     * traverse is empty.
     */
    public <K extends Comparable<K>, V> void traverse(TreeNode<K, V> root) {
        if (root != null) {
            traversing(root);
        }
    }
    
    /**
     * Invokes <tt>visiting()</tt> for each distinctive {@link TreeNode} along 
     * the way. 
     * 
     * @param node the current <tt>TreeNode</tt>.
     */
    protected abstract <K extends Comparable<K>, V> void traversing(TreeNode<K, V> node);
    
    /**
     * Delegates the call to this traverser's {@link TeeNodeVisitor}.
     * 
     * @param node the current {@link TreeNode}.
     */
    protected <K extends Comparable<K>, V> void visiting(TreeNode<K, V> node) {
        visitor.visit(node);
    }
    
    /**
     * Returns a <tt>TreeTraverser</tt> that performs a pre-order traversal of
     * a {@link BinaryTree}. 
     * <p> 
     * Looks at the root node first, then the left subtree, then the right 
     * subtree.
     * 
     * @param visitor called upon to visit each <tt>TreeNode</tt> during the 
     *  traversal.
     * @return a <tt>TreeTraverser</tt> object.
     */
    public static TreeTraverser preOrder(TreeNodeVisitor visitor) {
        return new TreeTraverser(visitor) {
            protected <K extends Comparable<K>, V> void traversing(TreeNode<K, V> node) {
                visiting(node);
                if (node.getLeftChild() != null) {
                    traversing(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    traversing(node.getRightChild());
                }
            }
        };
    }
    
    /**
     * Returns a <tt>TreeTraverser</tt> that performs an in-order traversal of
     * a {@link BinaryTree}.
     * <p> 
     * Looks at the the left subtree first, then the root node, then the right 
     * subtree.
     *  
     * @param visitor called upon to visit each <tt>TreeNode</tt> during the 
     *  traversal.
     * @return a <tt>TreeTraverser</tt> object.
     */
    public static TreeTraverser inOrder(TreeNodeVisitor visitor) {
        return new TreeTraverser(visitor) {
            protected <K extends Comparable<K>, V> void traversing(TreeNode<K, V> node) {
                if (node.getLeftChild() != null) {
                    traversing(node.getLeftChild());
                }
                visiting(node);
                if (node.getRightChild() != null) {
                    traversing(node.getRightChild());
                }
            }
        };
    }
        
    /**
     * Returns a <tt>TreeTraverser</tt> that performs a post-order traversal 
     * of a {@link BinaryTree}.
     * <p> 
     * Looks at the the left subtree first, then the right subtree, then the 
     * root node.
     * 
     * @param visitor called upon to visit each <tt>TreeNode</tt> during the 
     *  traversal.
     * @return a <tt>TreeTraverser</tt> object.
     */
    public static TreeTraverser postOrder(TreeNodeVisitor visitor) {
        return new TreeTraverser(visitor) {
            protected <K extends Comparable<K>, V> void traversing(TreeNode<K, V> node) {
                if (node.getLeftChild() != null) {
                    traversing(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    traversing(node.getRightChild());
                }
                visiting(node);
            }
        };
    }
}