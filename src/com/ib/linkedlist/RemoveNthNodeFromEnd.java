package com.ib.linkedlist;

/**
 * Created by krishna.m1 on 19/12/16.
 */
public class RemoveNthNodeFromEnd {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    int getLength(ListNode node) {
        if (node == null) {
            return 0;
        }
        return getLength(node.next) + 1;
    }

    ListNode removeListHead(ListNode node) {
        if (node == null) {
            return null;
        }

        ListNode head = node.next;
        node.next = null;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode a, int b) {
        if (a == null) {
            return null;
        }

        int N = getLength(a);
        if (b >= N) {
            return removeListHead(a);
        }

        int count = 1;
        ListNode start = a;
        while (count < (N - b)) {
            a = a.next;
            count += 1;
        }

        ListNode node = a.next.next;
        a.next = node;
        return start;
    }

    public static void main(String args[]) {

    }
}
