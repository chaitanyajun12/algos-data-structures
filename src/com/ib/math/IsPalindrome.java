package com.ib.math;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 08/05/16.
 */
public class IsPalindrome {

    public boolean isPalindrome(int a) {
        if(a < 0)
            return false;

        String num = Integer.toString(a);
        int N = num.length();

        for(int i = 0, j = (N - 1); i < N/2; i++, j--) {
            if(num.charAt(i) != num.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(new IsPalindrome().isPalindrome(121));
    }


}
