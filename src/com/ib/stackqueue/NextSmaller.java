package com.ib.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by krishna.m1 on 22/12/16.
 */
public class NextSmaller {
    public ArrayList<Integer> prevSmaller1(ArrayList<Integer> arr) {
        if (arr == null) {
            return null;
        }

        int N = arr.size();
        int result[] = new int[N];
        int i;

        for (i = N - 1; i >= 0; i--) {
            int minTillNow = arr.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j) < minTillNow) {
                    minTillNow = arr.get(j);
                    break;
                }
            }

            if (minTillNow == arr.get(i)) {
                minTillNow = -1;
            }

            result[i] = minTillNow;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (i = 0; i < N; i++) {
            res.add(result[i]);
        }

        return res;
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        if (arr == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int N = arr.size();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) stack.pop();
            if (stack.isEmpty()) result.add(-1);
            else result.add(stack.peek());

            stack.push(arr.get(i));
        }

        return result;
    }

    public static void main(String args[]) {
        NextSmaller nextSmaller = new NextSmaller();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(35);
        list.add(27);
        list.add(42);
        list.add(5);
        list.add(28);
        list.add(39);
        list.add(20);
        list.add(28);

        System.out.println(nextSmaller.prevSmaller(list));
    }
}
