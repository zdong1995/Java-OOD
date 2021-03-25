package practice.expressionevaluator;

public class SyntaxTreeNode {
    private final BaseEvaluator evaluator;
    private final Integer val;
    public SyntaxTreeNode left;
    public SyntaxTreeNode right;

    public SyntaxTreeNode(BaseEvaluator evaluator) {
        this.evaluator = evaluator;
        this.val = null;
    }

    public SyntaxTreeNode(int val) {
        this.val = val;
        this.evaluator = null;
    }

    public Integer getVal() {
        return val;
    }

    public boolean isEvaluator() {
        return this.evaluator != null;
    }

    public Operand eval() {
        // case 1: leaf node are all values
        if (!this.isEvaluator()) {
            return new Operand(this.getVal());
        }
        // case 2: evaluator node
        Operand left = this.left.eval();
        Operand right = this.right.eval();
        return this.evaluator.eval(left, right);
    }
}
