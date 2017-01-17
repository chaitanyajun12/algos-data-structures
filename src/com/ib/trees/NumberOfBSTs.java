package com.practice;

/**
 * Created by krishna.m1 on 26/11/16.
 */
public class NumberOfBSTs {

    private static int numOfBSTs(int n) {
        if(n <= 1) {
            return 1;
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += numOfBSTs(i) * numOfBSTs(n - i - 1);
        }

        return sum;
    }

    public static void main(String args[]) {
        System.out.println("Number of BSTs with 4 nodes is : " + numOfBSTs(1));
    }
}
