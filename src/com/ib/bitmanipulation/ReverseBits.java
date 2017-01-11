package com.ib.bitmanipulation;

/**
 * Created by krishna.m1 on 10/12/16.
 */
public class ReverseBits {

    public long reverse(long a) {
        long reverse = 0;
        long checker = 1;

        for(int i = 0; i < 32; i++) {
            if((a & (checker << i)) > 0) {
                reverse = reverse | (checker << (31 - i));
            }
        }

        return reverse;
    }

    public static void main(String args[]) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverse(3));
    }
}
