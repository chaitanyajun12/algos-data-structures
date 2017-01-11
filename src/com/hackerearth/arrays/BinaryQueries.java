package com.hackerearth.arrays;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class BinaryQueries {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i = 1; i <= Q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int index = scanner.nextInt() - 1;
                arr[index] = 1 - arr[index];
            } else if (type == 0) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                if(arr[Y - 1] == 0) {
                    System.out.println("EVEN");
                } else {
                    System.out.println("ODD");
                }
            }
        }

    }
}
