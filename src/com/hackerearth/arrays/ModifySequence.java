package com.hackerearth.arrays;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 08/12/16.
 */
class ModifySequence {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        for(int i = 0; i < N - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                System.out.println("NO");
                return;
            } else {
                arr[i + 1] = arr[i+1] - arr[i];
                arr[i] = 0;
            }
        }

        if(arr[N - 1] != 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}