package com.hackerearth.arrays;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class Speed {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int sum = 0;
            int maxSpeed = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int n = scanner.nextInt();
                if (n <= maxSpeed) {
                    maxSpeed = Math.min(n, maxSpeed);
                    sum += 1;
                }
            }

            System.out.println(sum);
        }

        scanner.close();
    }
}
