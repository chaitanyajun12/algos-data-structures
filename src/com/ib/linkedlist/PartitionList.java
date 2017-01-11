package com.ib.linkedlist;

/**
 * Created by krishna.m1 on 24/12/16.
 */
public class PartitionList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode a, int b) {
        ListNode lHead = null, gHead = null, lPtr = null, gPtr = null;
        ListNode node = a;

        while (node != null) {
            if (node.val >= b) {
                if (gHead == null) {
                    gHead = node;
                    gPtr = node;
                } else {
                    gPtr.next = node;
                    gPtr = gPtr.next;
                }

            } else {
                if (lHead == null) {
                    lHead = node;
                    lPtr = node;
                } else {
                    lPtr.next = node;
                    lPtr = lPtr.next;
                }
            }

            node = node.next;
        }

        if (lPtr != null) lPtr.next = null;
        if (gPtr != null) gPtr.next = null;

        if (lPtr != null) {
            lPtr.next = gHead;
            return lPtr;
        }

        return gHead;
    }

    public static void main(String args[]) {

    }
}
