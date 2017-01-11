package com.ib.stackqueue;

import java.util.Stack;

/**
 * Created by krishna.m1 on 20/12/16.
 */
public class Parenthesis {
    public int isValid(String a) {
        if (a == null || a.length() == 0) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if (ch == ')') {

                    if (stack.isEmpty()) return 0;
                    if (stack.pop() != '(') return 0;
                } else if (ch == '}') {

                    if (stack.isEmpty()) return 0;
                    if (stack.pop() != '{') return 0;

                } else if (ch == ']') {

                    if (stack.isEmpty()) return 0;
                    if (stack.pop() != '[') return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String args[]) {
        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.isValid("()[]{}"));
    }
}
