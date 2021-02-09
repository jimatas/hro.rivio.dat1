package dat1;

import dat1.tests.Car;
import dat1.tests.CarTunnel;

public class TestDataStructures {

    public static void main(String[] args) {
        testTree();
        testQueue();
    }
    
    private static void testQueue() {
        CarTunnel tunnel = new CarTunnel();
        tunnel.enter(new Car("Volkswagen", "Golf GTI"));
        tunnel.enter(new Car("Ford", "Escort 1.4")); 
        
        System.out.println(tunnel.exit());
        System.out.println(tunnel.exit());
        //System.out.println(tunnel.exit()); // exception.
    }
    
    private static void testTree() {
        BinaryTree<String, String> tree = getTree();
        tree.traverse(
            TreeTraverser.inOrder(
                new TreeNodeVisitor() {
                    public void visit(TreeNode node) {
                        System.out.println(node);
                    }
                }
            )
        );
    }
    
    private static BinaryTree<String, String> getTree() {
        BinaryTree<String, String> tree = new BinaryTree<String, String>();
        tree.add("E", "E");
        tree.add("J", "J");
        tree.add("D", "D");
        tree.add("B", "B");
        tree.add("G", "G");
        tree.add("F", "F");
        tree.add("A", "A");
        tree.add("H", "H");
        tree.add("C", "C");
        tree.add("I", "I");
        return tree;
    }
}