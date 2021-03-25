package practice.expressionevaluator;

/**
 * Evaluate || && to Boolean
 */
public class LogicEvaluator extends BaseEvaluator {
    public LogicEvaluator(String operator) {
        super(operator);
    }

    @Override
    public Operand eval(Operand o1, Operand o2) {
        if (!o1.isBool() || !o2.isBool()) {
            throw new UnsupportedOperationException("Unsupported Operand Type");
        }
        boolean val1 = o1.getBoolRes(), val2 = o2.getBoolRes();
        if (this.operator.equals("&&")) {
            return new Operand(val1 && val2);
        } else if (this.operator.equals("||")) {
            return new Operand(val1 || val2);
        } else {
            throw new UnsupportedOperationException("Unsupported Operation");
        }
    }
}
