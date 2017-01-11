package com.ib.bitmanipulation;

/**
 * Created by krishna.m1 on 22/12/16.
 */
public class CountBits {
    public int hammingWeight(long n) {
        int checker = 1;
        int count = 0;

        for (int i = 0; i <= 31; i++) {
            if ((n & (checker << i)) > 0) {
                count += 1;
            }
        }

        return count;
    }

    public static int hammingWeight1(int n) {
        int ones = 0;
        while(n!=0) {
            System.out.println(n);
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }

    public static void main(String args[]) {
        CountBits countBits = new CountBits();
        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println(countBits.hammingWeight1(2147483647));

        int n = 1;
        System.out.println(n >>> 2);
    }
}
