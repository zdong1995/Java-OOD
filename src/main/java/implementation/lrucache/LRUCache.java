package implementation.lrucache;

import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;

    private final Map<K, Node<K, V>> map; // <key = key of cache, value = Node reference>
    private final Node<K, V> head; // Most Recent Used
    private final Node<K, V> tail; // Least Recent Used

    private static class Node<K, V> {
        private final K key;
        private V val;
        private Node<K, V> prev;
        private Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public void update(V val) {
            this.val = val;
        }
    }

    /*
     * initialization: dummy node for head and tail
     * Null <- Node(0) <-> Node(0) -> Null
     *          head        tail
     */
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;

        head = new Node<K, V>(null, null);
        tail = new Node<K, V>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        // Case 1: if not in the cache, nothing to do
        if (node == null) {
            return null;
        }
        // Case 2: if in the cache, get the cache and reorder
        remove(node);
        addToTail(node);
        return node.val;
    }

    public void put(K key, V value) {
        Node<K, V> node = null;
        // Case 1: if in the cache, update the cache and reorder
        if (map.containsKey(key)) {
            node = map.get(key);
            node.update(value); // update record
            remove(node);
        } else {
            // Case 2: if not in the cache, add to map and reorder
            node = new Node<K, V>(key, value);
            map.put(key, node);
            if (this.map.size() > capacity) { // Case 2.2: cache is full
                // remove the lease recent used
                Node<K, V> toDel = head.next;
                map.remove(toDel.key);
                remove(toDel);
            }
        }
        addToTail(node); // reorder
    }

    /*
     * prev <-> tail <-> null
     * prev <-> node <-> tail <-> null
     */
    private void addToTail(Node<K, V> node) {
        Node<K, V> prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    /*
     * prev <-> node <-> next
     * prev <-> next
     */
    private void remove(Node<K, V> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
    }
}
