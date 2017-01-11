package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.m1 on 11/05/16.
 */
public class MaxSumSubArray {

    public int maxSubArray(final List<Integer> a) {

        int ans = 0;
        int sum = 0;
        boolean start = false;
        int maxValue = Integer.MIN_VALUE;
        int N = a.size();


        for(int i = 0; i < N; i++) {

            if(!start && a.get(i) < 0) {
                if(a.get(i) > maxValue)
                    maxValue = a.get(i);
                continue;
            }

            start = true;
            sum += a.get(i);

            if(sum < 0)
                sum = 0;

            if(sum > ans)
                ans = sum;
        }

        if(!start)
            return maxValue;

        return ans;
    }
    public static void main(String args[]) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(-5);
        input.add(-1);
        input.add(-4);
        System.out.println(new MaxSumSubArray().maxSubArray(input));

    }
}
