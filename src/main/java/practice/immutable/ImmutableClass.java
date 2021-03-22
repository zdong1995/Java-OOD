package practice.immutable;
/*
 * Design an immutable class, key point:
 * 1. Read-only (No setter)
 * 2. Create a new instance when modify
 */
public final class ImmutableClass {
    private final int index;
    private final String content;
    private final boolean flag;

    public ImmutableClass(int index, String content, boolean flag) {
        this.index = index;
        this.content = content;
        this.flag = flag;
    }

    public int getIndex() {
        return index;
    }

    public String getContent() {
        return content;
    }

    public boolean isFlag() {
        return flag;
    }
}
