package practice.immutable;

import java.util.Collections;
import java.util.List;

public final class MutableList<T> {
    private final List<T> list;

    public MutableList(List<T> e) {
        this.list = e;
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
