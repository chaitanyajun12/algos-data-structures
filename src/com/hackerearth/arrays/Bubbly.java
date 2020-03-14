package com.hackerearth.arrays;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class Bubbly {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            String word = scanner.next();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < word.length(); j++) {
                if(!stack.isEmpty()) {
                    char ch = stack.peek();
                    if(ch == word.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.push(word.charAt(j));
                    }
                } else {
                    stack.push(word.charAt(j));
                }
            }

            if(stack.isEmpty()) {
                sum += 1;
            }
        }

        System.out.println(sum);
        scanner.close();
    }
}
