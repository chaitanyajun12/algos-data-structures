package com.ib.math;

/**
 * Created by krishna.m1 on 09/05/16.
 */
public class ColumnNumber {

    public int titleToNumber(String a) {

        int N = a.length();

        if(N == 1) {
            return (a.charAt(0) - 65 + 1);
        }

        int col = 0;
        int count = 0;

        for(int i = N - 1; i >= 0; i--) {

            int index = a.charAt(count) - 65 + 1;

            if(i > 0) {
                col += index * (int) Math.pow(26, i);
            } else {
                col += index;
            }

            count++;
        }

        return col;
    }

    public static void main(String args[]) {

        System.out.println(new ColumnNumber().titleToNumber("AB"));
    }
}
