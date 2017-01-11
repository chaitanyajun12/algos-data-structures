package com.hackerrank;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by krishna.m1 on 31/10/16.
 */
public class BetweenTwoSets {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int setA[] = new int[n];
        int setB[] = new int[m];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < setA.length; i++) {
            setA[i] = scanner.nextInt();
            if(setA[i] > max) {
                max = setA[i];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < setB.length; i++) {
            setB[i] = scanner.nextInt();
            if(setB[i] < min) {
                min = setB[i];
            }
        }

        int count = 0;
        boolean status = true;

        for(int i = max; i <= min; i++) {

            status = true;
            for(int j = 0; j < setA.length; j++) {
                if(!(i % setA[j] == 0)) {
                    status = false;
                    break;
                }
            }

            if(status) {
                for (int j = 0; j < setB.length; j++) {
                    if (!(setB[j] % i == 0)) {
                        status = false;
                        break;
                    }
                }
            }

            if(status) {
                count++;
            }
        }

        System.out.println(count);
    }
}
