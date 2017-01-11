package com.hackerearth.arrays;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class MarkAnswer {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int n, sum = 0;
        boolean skip = false;
        for (int i = 0; i < N; i++) {
            n = scanner.nextInt();
            if(n <= X) {
                sum += 1;
            } else {
                if(!skip) {
                    skip = true;
                } else {
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
