package com.ib.binarysearch;

/**
 * Created by krishna.m1 on 16/05/16.
 */
public class SquareRoot {

    public int sqrt(int a) {

        if(a <= 0)
            return 0;

        double start = 1;
        double end = a;
        double mid;


        while(start <= end) {

            mid = (start + end) / 2;

            double temp = mid * mid;

            if(Math.floor(temp) == a)
                return (int) mid;
            else if(temp > a)
                end = mid;
            else
                start = mid;
        }

        return 0;
    }

    public static void main(String args[]) {
        System.out.println(new SquareRoot().sqrt(11));
    }
}
