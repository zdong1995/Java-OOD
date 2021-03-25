package practice.expressionevaluator;

public class Operand {
    private final Boolean boolRes;
    private final Integer intRes;

    public Operand(boolean boolRes) {
        this.boolRes = boolRes;
        this.intRes = null;
    }

    public Operand(int intRes) {
        this.intRes = intRes;
        this.boolRes = null;
    }

    public boolean isInt() {
        return this.intRes != null;
    }

    public boolean isBool() {
        return this.boolRes != null;
    }

    public boolean getBoolRes() {
        return boolRes;
    }

    public int getIntRes() {
        return intRes;
    }

    @Override
    public String toString() {
        return this.isInt() ? this.intRes.toString() : this.boolRes.toString();
    }
}
