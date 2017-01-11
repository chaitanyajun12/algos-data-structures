package com.hackerrank.arrays;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 07/12/16.
 */
public class ReverseArray {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int array[] = new int[N];

        for(int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        for(int i = N - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
