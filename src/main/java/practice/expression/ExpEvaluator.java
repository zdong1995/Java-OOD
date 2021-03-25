package practice.expression;

public abstract class ExpEvaluator {
    protected final String operator;

    public ExpEvaluator(String operator) {
        this.operator = operator;
    }

    public abstract Operand eval(Operand val1, Operand val2);

    @Override
    public String toString() {
        return this.operator;
    }
}
