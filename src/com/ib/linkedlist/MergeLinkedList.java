package com.ib.linkedlist;

/**
 * Created by krishna.m1 on 19/12/16.
 */
public class MergeLinkedList {

    class ListNode{
        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (a == null) {
            return a;
        }

        ListNode start = null, itrNode = null;
        while (a != null && b != null) {

            if (a.val > b.val) {
                if (start == null) {
                    start = b;
                    itrNode = b;
                } else {
                    itrNode.next = b;
                    itrNode = itrNode.next;
                }

                b = b.next;

            } else if (a.val < b.val) {
                if (start == null) {
                    start = a;
                    itrNode = a;
                } else {
                    itrNode.next = a;
                    itrNode= itrNode.next;
                }

                a = a.next;

            } else {
                if (start == null) {
                    start = a;
                    itrNode = a;
                    itrNode.next = b;
                } else {
                    itrNode.next = a;
                    itrNode = itrNode.next;
                    itrNode.next = b;
                }

                itrNode = itrNode.next;
                a = a.next;
                b = b.next;
            }
        }

        if (a == null && b == null) {
            itrNode.next = null;
        } else if (b == null) {
            itrNode.next = a;
        } else if (a == null) {
            itrNode.next = b;
        }

        return start;
    }


    public ListNode mergeLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.val < b.val) {
            a.next = mergeLists(a.next, b);
            return a;
        } else {
            b.next = mergeLists(a, b.next);
            return b;
        }
    }

    public static void main(String args[]) {

    }
}
