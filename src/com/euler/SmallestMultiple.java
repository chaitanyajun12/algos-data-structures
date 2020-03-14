package com.euler;

import java.util.Scanner;

/**
 * Created by krishna.m1 on 01/11/16.
 */
public class SmallestMultiple {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int number = n;
            boolean status;

            while (true) {
                status = true;
                for(int i = 2; i <= n; i++) {
                    if(!(number % i == 0)) {
                        status = false;
                        break;
                    }
                }

                if(status) {
                    System.out.println(number);
                    break;
                }

                number++;
                System.out.println(number);
            }
        }

        in.close();
    }
}
