package com.spoj.basic;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 09/12/16.
 */
class HalfOfHalf
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 1; i <= T; i++) {
            String str = scanner.next();
            int N = str.length() / 2;
            for(int j = 0; j < N; j += 2) {
                System.out.print(str.charAt(j));
            }

            System.out.println();
        }
    }
}