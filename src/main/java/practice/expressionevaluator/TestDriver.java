package practice.expressionevaluator;

public class TestDriver {
    /*
                &&
              /    \
             >      ==
           /   \   /   \
          4     +  3   4
              /   \
             2     5
     */
    public static void main(String[] args) {
        SyntaxTreeNode root = new SyntaxTreeNode(new LogicEvaluator("&&"));
        SyntaxTreeNode node1 = new SyntaxTreeNode(new BinaryEvaluator(">"));
        SyntaxTreeNode node2 = new SyntaxTreeNode(new BinaryEvaluator("=="));
        root.left = node1;
        root.right = node2;
        node2.left = new SyntaxTreeNode(3);
        node2.right = new SyntaxTreeNode(4);

        SyntaxTreeNode node3 = new SyntaxTreeNode(new IntEvaluator("+"));
        node1.left = new SyntaxTreeNode(4);
        node1.right = node3;
        node3.left = new SyntaxTreeNode(2);
        node3.right = new SyntaxTreeNode(5);

        System.out.println("Evaluation expresion:");
        System.out.println("4 > (2 + 5) && 3 == 4");
        System.out.println(root.eval()); // false
    }
}
