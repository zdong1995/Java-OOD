package practice.immutable;

import java.util.*;

public final class ImmutableList<T> {
    private final List<T> list;

    public ImmutableList(List<T> e) {
        this.list = Collections.unmodifiableList(e);
    }

    public T get(int i) {
        return this.list.get(i);
    }

    public int size() {
        return this.list.size();
    }

    public List<T> getList() {
        return this.list;
    }
}
