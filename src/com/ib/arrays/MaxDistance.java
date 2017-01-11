package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by krishna.m1 on 14/05/16.
 */
public class MaxDistance {


    public int maximumGap(final List<Integer> a) {

        if(a.size() == 0)
            return -1;

        int max = 0;
        int N = a.size();
        boolean stop = false;

        for(int i = (N - 1); i >= 0; i--) {

            if(stop)
                break;

            for(int j = 0; j < N; j++) {

                if(j + i < N) {

                    if(a.get(j) <= a.get(j + i)) {
                        max = i;
                        stop = true;
                        break;
                    }
                }
            }
        }

        return max;
    }

    public int maximumGapOptimal(final List<Integer> a) {

        int index[] = new int[a.size()];

        ArrayList<Integer> list = (ArrayList<Integer>) a;
        ArrayList<Integer> sortedList = (ArrayList<Integer>) list.clone();

        Collections.sort(sortedList);


        return index[0];
    }


        public static void main(String args[]) {

        ArrayList<Integer> a = new ArrayList<>();


        System.out.println(new MaxDistance().maximumGap(a));
    }
}
