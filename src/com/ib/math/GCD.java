package com.ib.math;

/**
 * Created by krishna.m1 on 09/05/16.
 */
public class GCD {

    public int gcd(int a, int b) {

        if(a == 0 && b == 0)
            return 0;

        while(true) {
            int rem = a % b;
            if(rem == 0)
                break;

            a = b;
            b = rem;
        }

        return b;
    }

    public static void main(String args[]) {

        System.out.println(new GCD().gcd(0, 0));
    }
}
