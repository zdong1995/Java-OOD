package concurrency;

import java.util.*;

public class LRUCache {
    private static class DLL {
        private DLL prev;
        private DLL next;
        private int val; // cache
        private int key;
        public DLL(int val, int key) {//你没有pass key 进去
            prev = null;
            next = null;
            this.val = val;
            this.key = key;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
    private int capacity;

    // 所有data都存在head和tail之间，head和tail是用来O(1)定位的
    // head前和tail后不存东西
    private DLL head; // dummy node, most recent
    private DLL tail; // dummy node, least recent
    private Map<Integer, DLL> map;
    // <key: cache key, value: reference of DLL to store the cache>
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // null <- head <-> tail -> null
        //        dummy0    dummy0
        // dummy 的 prev 和 next 初始化都是 null，只是把两个 dummy 连起来了而已
        head = new DLL(0, 0);
        tail = new DLL(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    // 先把 addKey() 和 get() 两个 function signature 写了
    public int get(int key) {
        if (map.containsKey(key)) {
            DLL cur = map.get(key);
            // 这里因为 hit 了 cache 一次，需要 reorder
            // 这里你说考虑了下，不论是 get 还是 addKey 时都会有 remove 和 addToTail 的操作，因此我考虑 abstract 出来进行 code reuse
            remove(cur); // helper method (可以先写TODO，然后最后implement)
            addToTail(cur); // helper method， TODO
            return cur.val;
        } else {
            return -1; // 问他 return special value 还是 exception
        }
    }
    // cache the newer version cache content
    // 是只有getKey的时候才算用一次吗，addKey不算？？
    // 你问他 addKey 算不算 cache hit，这样才知道是否需要 reorder
    // 每次先加到最低的 priority 的位置，直到被 get hit cache 了才 reorder 到 MRU
    public void addKey(int key, int value) {
        if (map.containsKey(key)) {
            DLL cur = map.get(key);
            cur.val = value;
        } else {
            DLL cur = new DLL(value, key);
            map.put(key, cur);
            addToTail(cur); // MRU
            if (map.size() > capacity) { // 前面已经 put 过了，这里应该 strictyly 大于
                DLL toRemove = head.next; // real head
                map.remove(toRemove.key);
                remove(toRemove);
            }
        }
    }

    private void addToTail(DLL node) {
        DLL prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        prev.next = node;
        node.prev = prev;
    }

    private void remove(DLL node) {
        DLL prev = node.prev;
        DLL next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    @Override
    public String toString() {
        return this.map.toString();
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(3);
        test.addKey(1, 10);
        test.addKey(2, 20);
        test.addKey(3, 30);
        System.out.println(test); // {1=10, 2=20, 3=30}
        test.addKey(4, 40);
        System.out.println(test); // {2=20, 3=30, 4=40}
    }
}
