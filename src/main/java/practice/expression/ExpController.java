package practice.expression;

public class ExpController {
    public Operand eval(SyntaxTreeNode root) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) { // leaf node, val
            return new Operand(root.getVal());
        }
        // recursion to eval left and right subtree
        Operand left = eval(root.left);
        Operand right = eval(root.right);
        return root.eval(left, right);
    }
}
