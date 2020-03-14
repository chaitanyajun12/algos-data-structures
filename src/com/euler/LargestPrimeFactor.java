package com.euler;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 01/11/16.
 */
public class LargestPrimeFactor {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            if(isPrime(n)) {
                System.out.println(n);
                continue;
            }

            long N = n / 2;
            for(long i = N; i >= 2; i--) {
                if(n % i == 0) {
                    if(isPrime(i)) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }

        in.close();
    }

    private static boolean isPrime(long number) {
        if(number == 2) {
            return true;
        }

        if(number % 2 == 0) {
            return false;
        }

        long sqrt = (long) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }


}
