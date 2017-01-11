package com.euler;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 31/10/16.
 */
public class EvenFibonacci {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();

            long f1 = 1, f2 = 2;
            long evenSum = 0;
            while (true) {

                if(f2 >= n) {
                    break;
                }

                if(f2 % 2 == 0) {
                    evenSum += f2;
                }

                long tmp = f2;
                f2 = f1 + f2;
                f1 = tmp;
            }

            System.out.println(evenSum);
        }

    }
}
