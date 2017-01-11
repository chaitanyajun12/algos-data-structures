package com.hackerearth.arrays;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class RightRotation {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int k = scanner.nextInt();

            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            int rotated[] = new int[N];
            for (int i = 0; i < N; i++) {
                rotated[(i + k) % N] = arr[i];
            }

            for (int i = 0; i < N; i++) {
                System.out.print(rotated[i] + " ");
            }

            System.out.println();
        }
    }
}
