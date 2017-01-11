package com.ib.stackqueue;

/**
 * Created by krishna.m1 on 20/12/16.
 */
public class MinStack {

    class Element {
        int value;
        int minValue;
        Element next;

        Element(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }

    public class MinStackImpl {
        private Element top;

        public void push(int x) {
            if (top == null) {
                top = new Element(x, x);
            } else {
                Element ele = new Element(x, Math.min(x, top.minValue));
                ele.next = top;
                top = ele;
            }
        }

        public void pop() {
            if (top == null) {
                return;
            }
            Element ele = top;
            top = top.next;
            ele.next = null;
        }

        public int top() {
            return top == null ? -1 : top.value;
        }

        public int getMin() {
            return top == null ? -1 : top.minValue;
        }
    }

    public static void main(String args[]) {

    }
}
