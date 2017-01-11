package com.ib.math;

/**
 * Created by krishna.m1 on 08/05/16.
 */
public class ReverseInteger {

    public int reverse(int a) {

        int result = 0;

        while(a != 0) {

            int tmp = (result * 10) + (a % 10);

            if(tmp > (Integer.MAX_VALUE/10) || tmp < (Integer.MIN_VALUE))
                return 0;
            else
                result = tmp;

            a = a / 10;
        }

        return result;
    }

    public static void main(String args[]) {

        System.out.println(new ReverseInteger().reverse(359191482));
    }
}
