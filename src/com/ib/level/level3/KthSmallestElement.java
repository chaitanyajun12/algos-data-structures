package com.ib.level.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by krishna.m1 on 15/12/16.
 */
public class KthSmallestElement {
    public int kthsmallest(final List<Integer> a, int k) {
        if (a == null || k > a.size()) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < a.size(); i++) {
            if (i < k) {
                queue.add(a.get(i));
            } else {
                if (queue.peek() > a.get(i)) {
                    queue.remove();
                    queue.add(a.get(i));
                }
            }
        }

        return queue.peek();
    }

    public int kthLargest(final List<Integer> a, int k) {
        if (a == null || k > a.size()) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            queue.add(a.get(i));
            if (queue.size() > k) {
                queue.remove();
            }
        }

        return queue.peek();
    }

    public static void main(String args[]) {
        KthSmallestElement kthElement = new KthSmallestElement();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        System.out.println(kthElement.kthsmallest(list, 3));
        System.out.println(kthElement.kthLargest(list, 1));
    }
}
