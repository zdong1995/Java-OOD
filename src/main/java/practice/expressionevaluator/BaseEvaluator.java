package practice.expressionevaluator;

public abstract class BaseEvaluator {
    protected final String operator;

    public BaseEvaluator(String operator) {
        this.operator = operator;
    }

    public abstract Operand eval(Operand val1, Operand val2);

    @Override
    public String toString() {
        return this.operator;
    }
}
