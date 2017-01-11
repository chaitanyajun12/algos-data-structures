package com.ib.linkedlist;

/**
 * Created by krishna.m1 on 22/12/16.
 */
public class ListCycle {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode a) {

        ListNode startPtr = a;
        ListNode itrPtr = a;

        while (startPtr != null) {
            while (itrPtr != null) {
                if (itrPtr.next == startPtr) {
                    return startPtr;
                }
                itrPtr = itrPtr.next;
            }
            startPtr = startPtr.next;
            itrPtr = startPtr;
        }
        return null;
    }


    public ListNode detectCycle1(ListNode a) {
        if (a == null) {
            return null;
        }

        ListNode slowPtr = a;
        ListNode fastPtr = a;

        while (slowPtr != null && fastPtr != null) {
            slowPtr = slowPtr.next;
            if (fastPtr != null) {
                fastPtr = fastPtr.next;
                if (fastPtr != null) {
                    fastPtr = fastPtr.next;
                }
            }

            if (slowPtr == fastPtr && slowPtr != null) {
                fastPtr = a;
                while (fastPtr != null && fastPtr != slowPtr) {
                    fastPtr = fastPtr.next;
                    slowPtr = slowPtr.next;
                }
                return slowPtr;
            }
        }

        return null;
    }


    public static void main(String args[]) {

    }
}
