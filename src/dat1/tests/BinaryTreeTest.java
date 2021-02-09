package dat1.tests;

import junit.framework.TestCase;
import dat1.BinaryTree;

public class BinaryTreeTest extends TestCase {

    private BinaryTree<String, String> tree;
    
    protected void setUp() throws Exception {
        super.setUp();
        tree = new BinaryTree<String, String>();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        tree = null;
    }

    protected void testAddToBinaryTree() {
        tree.add("A", "A");
    }
}
