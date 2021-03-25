package practice.expression;

/**
 * Evaluator for + - * / to Integer
 */
public class IntEvaluator extends ExpEvaluator {
    public IntEvaluator(String operator) {
        super(operator);
    }

    @Override
    public Operand eval(Operand o1, Operand o2) {
        if (!o1.isInt() || !o2.isInt()) {
            throw new UnsupportedOperationException("Unsupported Operand Type");
        }
        int val1 = o1.getIntRes(), val2 = o2.getIntRes();
        if (this.operator.equals("+")) {
            return new Operand(val1 + val2);
        } else if (this.operator.equals("-")) {
            return new Operand(val1 - val2);
        } else if (this.operator.equals("*")) {
            return new Operand(val1 * val2);
        } else if (this.operator.equals("/")) {
            return new Operand(val1 / val2);
        } else {
            throw new UnsupportedOperationException("Unsupported Operation");
        }
    }
}
