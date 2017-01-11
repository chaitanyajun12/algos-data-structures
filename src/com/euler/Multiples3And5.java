package com.euler;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 31/10/16.
 */
public class Multiples3And5 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int N = n - 1;

            int n3s = N / 3;
            int n5s = N / 5;
            int n15s = n / 15;

            int sum = 0;
            sum += ((3 * n3s) * (n3s + 1)) / 2;
            sum += ((5 * n5s) * (n5s + 1)) / 2;
            sum -= ((15 * n15s) * (n15s + 1)) / 2;

            System.out.println(sum);
        }

    }
}
