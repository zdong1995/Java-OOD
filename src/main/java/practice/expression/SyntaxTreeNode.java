package practice.expression;

public class SyntaxTreeNode {
    private ExpEvaluator expEvaluator;
    private Integer val;
    public SyntaxTreeNode left;
    public SyntaxTreeNode right;

    public SyntaxTreeNode(ExpEvaluator expEvaluator) {
        this.expEvaluator = expEvaluator;
        this.val = null;
    }

    public SyntaxTreeNode(int val) {
        this.val = val;
        this.expEvaluator = null;
    }

    public Integer getVal() {
        return val;
    }

    public boolean isEvaluator() {
        return this.expEvaluator != null;
    }

    public Operand eval(Operand res1, Operand res2) {
        return this.expEvaluator.eval(res1, res2);
    }
}
