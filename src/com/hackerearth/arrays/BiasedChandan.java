package com.hackerearth.arrays;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class BiasedChandan {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int arr[] = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        long sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            if((i + 1) < N && arr[i + 1] == 0) {
                sum -= arr[i];
                i += 1;
            }
        }

        System.out.println(sum);
    }

    private static void anotherWay() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            if(n == 0) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(n);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);

    }

}
