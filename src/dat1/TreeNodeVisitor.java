package dat1;

/**
 * Instances of <tt>TreeNodeVisitor</tt> are supplied to {@link TreeTraverser}
 * objects.  
 * <p>
 * A <tt>TreeTraverser</tt> will call <tt>visit()</tt> for each {@link TreeNode}
 * that it comes across during the traversal of a {@link BinaryTree}. Any 
 * functionality that is required of a traversal, is therefore best implemented 
 * in the <tt>visit()</tt> method.
 * 
 * @see TreeTraverser 
 * @author K. Atas
 */
public interface TreeNodeVisitor {
    /**
     * Called for each {@link TreeNode} that is visited during the traversal of
     * a {@link BinaryTree}.
     * 
     * @param node the current {@link TreeNode} to visit.
     */
    <K extends Comparable<K>, V> void visit(TreeNode<K, V> node);
}