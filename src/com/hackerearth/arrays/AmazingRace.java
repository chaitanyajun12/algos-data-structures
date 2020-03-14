package com.hackerearth.arrays;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 09/12/16.
 */
public class AmazingRace {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = scanner.nextInt();
            int arr[] = new int[N];
            int i;
            for(i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            int maxSum = Integer.MIN_VALUE;
            int maxIndex = 0;

            for (i = 0; i < N; i++) {
                int value = arr[i];
                int count = 0;

                for (int j = (i + 1); j < N; j++) {
                    if (arr[j] >= value)
                        break;

                    count += 1;
                }

                for(int k = i - 1; k >= 0; k--) {
                    if(arr[k] >= value)
                        break;

                    count += 1;
                }

                if((count * (i + 1)) > maxSum) {
                    maxSum = Math.max(maxSum, (count * (i + 1)));
                    maxIndex = i + 1;
                }
            }

            System.out.println(maxIndex);
        }

        scanner.close();
    }
}
