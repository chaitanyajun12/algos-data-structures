package com.ib.linkedlist;

import java.util.List;

/**
 * Created by krishna.m1 on 24/12/16.
 */
public class AddNumbersAsList {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count += 1;
        }

        return count;
    }

    private void addSuffixZeros(ListNode num1, ListNode num2) {
        int nL1 = getLength(num1);
        int nL2 = getLength(num2);

        if (nL1 == nL2) return;

        int offsetZeros = 0;
        if (nL1 > nL2) {
            offsetZeros = nL1 - nL2;
            while (num2.next != null) num2 = num2.next;
            while (offsetZeros-- > 0) {
                ListNode node = new ListNode(0);
                num2.next = node;
                num2 = node;
            }

        } else {
            offsetZeros = nL2 - nL1;
            while (num1.next != null) num1 = num1.next;
            while (offsetZeros-- > 0) {
                ListNode node = new ListNode(0);
                num1.next = node;
                num1 = num1.next;
            }
        }
    }

    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        if (num1 == null) return num2;
        else if (num2 == null) return num1;

        addSuffixZeros(num1, num2);

        int carry = 0;
        ListNode resultPtr = null, sumNode = null, node;
        int sum;

        while (num1 != null) {
            sum = num1.val + num2.val + carry;
            if (sum > 9) {
                carry = 1;
                node = new ListNode(sum - 10);
            } else {
                carry = 0;
                node = new ListNode(sum);
            }

            if (sumNode == null) {
                sumNode = node;
                resultPtr = node;
            } else {
                resultPtr.next = node;
                resultPtr = resultPtr.next;
            }

            num1 = num1.next;
            num2 = num2.next;
        }

        if (carry > 0) {
            resultPtr.next = new ListNode(carry);
        }

        return sumNode;
    }

    public static void main(String args[]) {

        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);

        AddNumbersAsList addNumbersAsList = new AddNumbersAsList();
        ListNode node = addNumbersAsList.addTwoNumbers(node1, node4);

        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
