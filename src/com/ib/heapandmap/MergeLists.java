package com.ib.heapandmap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by krishna.m1 on 17/12/16.
 */
public class MergeLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a != null) {
            return null;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(10);
        queue.add(20);

        queue.add(4);
        queue.add(11);
        queue.add(13);

        queue.add(3);
        queue.add(8);
        queue.add(9);

        for (int list = 0; list < a.size(); list++) {
            ListNode node = a.get(list);
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }

        ListNode startNode = new ListNode(queue.poll());
        ListNode ptrNode = startNode;
        ptrNode.next = null;

        while (!queue.isEmpty()) {
            ListNode node = new ListNode(queue.poll());
            node.next = null;
            ptrNode.next = node;
            ptrNode = ptrNode.next;
        }

        return startNode;
    }

    public static void main(String args[]) {
        MergeLists mergeLists = new MergeLists();
        ListNode node = mergeLists.mergeKLists(null);
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }
}
