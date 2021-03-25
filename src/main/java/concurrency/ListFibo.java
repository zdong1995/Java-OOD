package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ListFibo {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void fiboList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) { // fibo index = 0 || 0, 1
            return;
        }
        // assumption: length of linked list > 2
        int len = getLen(head);
        List<Integer> idxs = getFibo(len); // [1, 2, 3, 5, 8, 13, ...]
        System.out.println("Fibo index: " + idxs);
        int fiboIdx = 2; // start fibo index is 2, which is 3-th node
        int lastIdx = idxs.get(idxs.size() - 1);

        ListNode cur = head.next.next; // start from 2-th node in linked list
        ListNode tail = cur; // use to add fibo-indexed node to the tail of dummy
        for (int i = 2; i <= lastIdx; i++) { // index of linked list
            if (i == idxs.get(fiboIdx)) {
                tail.next = cur;
                tail = tail.next;
                fiboIdx++;
            }
            cur = cur.next;
        }
        tail.next = null; // delink
    }

    private static int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private static List<Integer> getFibo(int n) {
        List<Integer> fibo = new ArrayList<>();
        fibo.add(1);
        fibo.add(2);
        while (fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2) <= n) {
            int prev2 = fibo.get(fibo.size() - 2);
            int prev1 = fibo.get(fibo.size() - 1);
            // fibo[n] = fibo[n - 2] + fibo[n - 1]
            fibo.add(prev1 + prev2);
        }
        return fibo;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 15; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println("Original Linked List:");
        printList(head);
        System.out.println("Modified Linked List:");
        fiboList(head);
        printList(head);
        /*
         * Sample output:
         * Original Linked List:
         * 0->1->2->3->4->5->6->7->8->9->10->11->12->13->14
         * Modified Linked List:
         * Fibo index: [1, 2, 3, 5, 8, 13]
         * 0->1->2->3->5->8->13
         */
    }

    private static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val); // last node
    }
}
