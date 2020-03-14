package com.hackerearth.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by krishna.m1 on 09/12/16.
 */
public class UniqueSubArrays {
    public static void main(String args[]) {
        // TODO : Optimize it further
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

            for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int arr[] = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = scanner.nextInt();
            }

            int sum = N;
            for(int i = 0; i < (N - 1); i++) {
                Map<Integer, Integer> countMap = new HashMap<>();
                countMap.put(arr[i], 1);
                for(int size = 1; size <= (N - 1); size++) {
                    if(i + size >= N) {
                        continue;
                    }

                    if(countMap.containsKey(arr[i + size])) {
                        break;
                    }

                    countMap.put(arr[i + size], 1);
                    sum += (size + 1);
                }
            }

            System.out.println(sum);
        }

        scanner.close();
    }
}
