package com.hackerearth.arrays;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class LoveForFood {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();

        Stack<Integer> foodStack = new Stack<>();

        for(int i = 1; i <= Q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {

                if(!foodStack.isEmpty()) {
                    System.out.println(foodStack.pop());
                } else {
                    System.out.println("No Food");
                }
            } else if (type == 2) {
                foodStack.push(scanner.nextInt());
            }
        }

        scanner.close();
    }
}
