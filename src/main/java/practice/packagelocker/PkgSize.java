package practice.packagelocker;

public enum PkgSize {
    SMALL(0), MEDIUM(1), LARGE(2);

    private int val;

    private PkgSize(int value) {
        this.val = value;
    }

    public int getValue() {
        return this.val;
    }
}
