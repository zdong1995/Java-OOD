package practice.immutable;

import java.util.*;
import java.util.stream.Collectors;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("TEST 1: immutable class test");
        ImmutableClass immutableClass = new ImmutableClass(0, "Hello", true);
        System.out.println(immutableClass.getContent());
        System.out.println(immutableClass.isFlag());
        System.out.println(immutableClass.getIndex() + "\n");

        int[] arr = new int[] {1, 2, 3, 4};
        // Array.asList() is backed by the input array, return a fixed-size view

        System.out.println("TEST 2: mutable list");
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("Original list: " + list);

        MutableList<Integer> mutableList = new MutableList<>(list);
        System.out.println("get(2): " + mutableList.get(2));
        System.out.println("size(): " + mutableList.size());
        List<Integer> mList = mutableList.getList();
        mList.add(5); // modify list
        System.out.println("Modified original list: " + list); // also modify the original list
        System.out.println("Modified mutableList: " + mutableList.getList() + "\n");

        System.out.println("TEST 3: mutable list");
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("Original list: " + list);

        ImmutableList<Integer> immutableList = new ImmutableList<>(list);
        System.out.println("get(2): " + immutableList.get(2));
        System.out.println("size(): " + immutableList.size());
        List<Integer> imList = immutableList.getList();
        try {
            imList.add(3);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }
}
