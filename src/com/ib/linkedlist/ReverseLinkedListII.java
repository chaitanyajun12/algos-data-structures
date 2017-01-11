package com.ib.linkedlist;

/**
 * Created by krishna.m1 on 23/12/16.
 */
public class ReverseLinkedListII {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode a, int m, int n) {
        if (a == null || m == n) {
            return a;
        }

        ListNode slowPtr = null, fastPtr = a;
        ListNode head = null;

        int count = m - 1;
        while (count > 0) {
            if (count - 1 == 0) {
                slowPtr = fastPtr;
            }

            fastPtr = fastPtr.next;
            count -= 1;
        }

        if (slowPtr != null) {
            head = a;
        }

        count = n - m;
        ListNode nextNode = null, prevNode = null;

        while (count >= 0) {
            if (fastPtr != null) {
                nextNode = fastPtr.next;
                fastPtr.next = prevNode;
                prevNode = fastPtr;
                fastPtr = nextNode;
            }

            count -= 1;
        }

        if (slowPtr != null) {
            ListNode tmp = slowPtr.next;
            tmp.next = nextNode;
            slowPtr.next = prevNode;
        } else {
            head = prevNode;
            a.next = nextNode;
        }

        return head;
    }

    public static void main(String args[]) {

    }
}
