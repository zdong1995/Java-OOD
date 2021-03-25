package concurrency;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class MeanSlidingWindow {
    Deque<Integer> window;
    private final int capacity;
    private int sum;

    public MeanSlidingWindow(int capacity) {
        this.capacity = capacity;
        window = new LinkedList<>();
    }

    public void put(int element) {
        window.offerLast(element);
        sum += element;
        if (window.size() > capacity) {
            int toRemove = window.removeFirst();
            sum -= toRemove;
        }
    }

    public double getMean() {
        return (double) sum / window.size();
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println(map);
    }
}
