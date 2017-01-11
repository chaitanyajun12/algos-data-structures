package com.ib.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by krishna.m1 on 21/12/16.
 */
public class EvaluateExpression {
    public int evalRPN(ArrayList<String> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int N = a.size();

        for (int i = 0; i < N; i++) {
            if (!isOperator(a.get(i))) {
                stack.add(Integer.parseInt(a.get(i)));
            } else {
                int opr2 = stack.pop();
                int opr1 = stack.pop();
                stack.push(compute(opr1, opr2, a.get(i)));
            }
        }

        return stack.pop();
    }

    public int compute(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        }

        return 0;
    }

    public boolean isOperator(String str) {
        if (str.equals("+")
                || str.equals("-")
                || str.equals("*")
                || str.equals("/"))
            return true;
        return false;
    }


    public static void main(String args[]) {
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        ArrayList<String> list = new ArrayList<>();
        list.add("4");
        list.add("13");
        list.add("5");
        list.add("/");
        list.add("+");

        System.out.println(evaluateExpression.evalRPN(list));
    }
}
