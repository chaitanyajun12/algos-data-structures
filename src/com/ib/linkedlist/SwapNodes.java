package com.ib.linkedlist;

import java.util.List;

/**
 * Created by krishna.m1 on 23/12/16.
 */
public class SwapNodes {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        ListNode head = null;
        ListNode prev = null;

        while (a != null) {
            if (prev != null) {
                if (a.next != null) {
                    prev.next = a.next;
                } else {
                    break;
                }
            }

            if (a.next != null) {
                ListNode nextNode = a.next;
                a.next = nextNode.next;
                if (head == null) {
                    head = nextNode;
                }
                nextNode.next = a;
            }

            prev = a;
            a = a.next;
        }

        return head;
    }

    public static void main(String args[]) {

        ListNode node1 = new ListNode(1);


        ListNode start = new SwapNodes().swapPairs(node1);
        while (start != null) {
            System.out.print(start.val + " -> ");
            start = start.next;
        }
    }
}
